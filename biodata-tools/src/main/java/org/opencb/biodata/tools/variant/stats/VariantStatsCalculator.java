package org.opencb.biodata.tools.variant.stats;

import org.opencb.biodata.models.feature.Genotype;
import org.opencb.biodata.models.variant.Variant;
import org.opencb.biodata.models.variant.VariantAggregatedVcfFactory;
import org.opencb.biodata.models.variant.VariantSourceEntry;
import org.opencb.biodata.models.variant.VariantVcfFactory;
import org.opencb.biodata.models.variant.stats.VariantAggregatedStats;
import org.opencb.biodata.models.variant.stats.VariantStats;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jmmut on 2015-08-25.
 *
 * @author Jose Miguel Mut Lopez &lt;jmmut@ebi.ac.uk&gt;
 */
public class VariantStatsCalculator {

    protected Properties tagMap;
    protected Map<String, String> reverseTagMap;

    private final static String COMMA = ",";
    private final static Pattern numNum = Pattern.compile("^(\\d+)[|/](\\d+)$");

    /**
     * @param tagMap Properties that contains case-sensitive tag mapping for aggregation data.
     * A valid example structure of this file is:
     * EUR.AF=EUR_AF
     * EUR.AC=AC_EUR
     * EUR.AN=EUR_AN
     * EUR.GTC=EUR_GTC
     * ALL.AF=AF
     * ALL.AC=TAC
     * ALL.AN=AN
     * ALL.GTC=GTC
     *
     * where the right side of the '=' is how the values appear in the vcf, and left side is how it will loaded.
     * It must be a bijection, i.e. there must not be repeated entries in any side.
     * The part before the '.' can be any string naming the group. The part after the '.' must be one of AF, AC, AN or GTC.
     */
    public VariantAggregatedVcfFactory(Properties tagMap) {
        this.tagMap = tagMap;
        if (tagMap != null) {
            this.reverseTagMap = new LinkedHashMap<>(tagMap.size());
            for (String tag : tagMap.stringPropertyNames()) {
                this.reverseTagMap.put(tagMap.getProperty(tag), tag);
            }
        } else {
            this.reverseTagMap = null;
        }
    }

    public void calculate(Variant variant, VariantSourceEntry study) {
//        Map<String, String> infoMap = VariantAggregatedVcfFactory.getInfoMap(info);
        Map<String, String> infoMap = study.getAttributes();
        int numAllele = 0;
        String[] alternateAlleles = {variant.getAlternate()};
        if (infoMap.containsKey(VariantVcfFactory.ORI)) {
            String[] ori = infoMap.get(VariantVcfFactory.ORI).split(":");
            numAllele = Integer.parseInt(ori[3]);
            alternateAlleles = ori[2].split(",");
        }
        if (tagMap == null) {
            parseStats(variant, study, numAllele, alternateAlleles, infoMap);
        } else {
            parseCohortStats(variant, study, numAllele, alternateAlleles, infoMap);
        }
    }

    protected void parseStats(Variant variant, VariantSourceEntry file, int numAllele, String[] alternateAlleles, Map<String, String> info) {
        VariantStats vs = new VariantStats(variant);
        Map<String, String> stats = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : info.entrySet()) {

            String infoTag = entry.getKey();
            String infoValue = entry.getValue();

            if ((infoTag.equals("AC") || infoTag.equals("AN") || infoTag.equals("AF")
                    || infoTag.equals("GTC") || infoTag.equals("GTS"))) {
                stats.put(infoTag, infoValue);
            }
        }

        calculate(variant, file, numAllele, alternateAlleles, stats, vs);

        file.setStats(vs);
    }

    protected void parseCohortStats (Variant variant, VariantSourceEntry file, int numAllele, String[] alternateAlleles, Map<String, String> info) {
        Map<String, Map<String, String>> cohortStats = new LinkedHashMap<>();   // cohortName -> (statsName -> statsValue): EUR->(AC->3,2)
        for (Map.Entry<String, String> entry : info.entrySet()) {
            if (reverseTagMap.containsKey(entry.getKey())) {
                String opencgaTag = reverseTagMap.get(entry.getKey());
                String[] tagSplit = opencgaTag.split(DOT);
                String cohortName = tagSplit[0];
                String statName = tagSplit[1];
                Map<String, String> parsedValues = cohortStats.get(cohortName);
                if (parsedValues == null) {
                    parsedValues = new LinkedHashMap<>();
                    cohortStats.put(cohortName, parsedValues);
                }
                parsedValues.put(statName, entry.getValue());
            }
        }

        for (String cohortName : cohortStats.keySet()) {
            VariantStats vs = new VariantStats(variant);
            calculate(variant, file, numAllele, alternateAlleles, cohortStats.get(cohortName), vs);
            file.setCohortStats(cohortName, vs);
        }

    }

    /**
     * sets (if the map of attributes contains AF, AC, AF and GTC) alleleCount, refAlleleCount, maf, mafAllele, alleleFreq and genotypeCounts,
     * @param variant
     * @param sourceEntry
     * @param numAllele
     * @param alternateAlleles
     * @param attributes
     * @param variantStats results are returned by reference here
     */
    protected void calculate(Variant variant, VariantSourceEntry sourceEntry, int numAllele, String[] alternateAlleles,
                            Map<String, String> attributes, VariantStats variantStats) {

        if (attributes.containsKey("AN") && attributes.containsKey("AC")) {
            int total = Integer.parseInt(attributes.get("AN"));
            String[] alleleCountString = attributes.get("AC").split(COMMA);

            if (alleleCountString.length != alternateAlleles.length) {
                return;
            }

            int[] alleleCount = new int[alleleCountString.length];

            String mafAllele = variant.getReference();
            int referenceCount = total;

            for (int i = 0; i < alleleCountString.length; i++) {
                alleleCount[i] = Integer.parseInt(alleleCountString[i]);
                if (i == numAllele) {
                    variantStats.setAltAlleleCount(alleleCount[i]);
                }
                referenceCount -= alleleCount[i];
            }

            variantStats.setRefAlleleCount(referenceCount);
            float maf = (float) referenceCount / total;

            for (int i = 0; i < alleleCount.length; i++) {
                float auxMaf = (float) alleleCount[i] / total;
                if (auxMaf < maf) {
                    maf = auxMaf;
                    mafAllele = alternateAlleles[i];
                }
            }

            variantStats.setMaf(maf);
            variantStats.setMafAllele(mafAllele);
        }

        if (attributes.containsKey("AF")) {
            String[] afs = attributes.get("AF").split(COMMA);
            if (afs.length == alternateAlleles.length) {
                variantStats.setAltAlleleFreq(Float.parseFloat(afs[numAllele]));
                if (variantStats.getMaf() == -1) {  // in case that we receive AFs but no ACs
                    float sumFreq = 0;
                    for (String af : afs) {
                        sumFreq += Float.parseFloat(af);
                    }
                    float maf = 1 - sumFreq;
                    String mafAllele = variantStats.getRefAllele();

                    for (int i = 0; i < afs.length; i++) {
                        float auxMaf = Float.parseFloat(afs[i]);
                        if (auxMaf < maf) {
                            maf = auxMaf;
                            mafAllele = alternateAlleles[i];
                        }
                    }
                    variantStats.setMaf(maf);
                    variantStats.setMafAllele(mafAllele);
                }
            }
        }
        if (attributes.containsKey("GTC")) {
            String[] gtcs = attributes.get("GTC").split(COMMA);
            if (sourceEntry.hasAttribute("GTS")) {    // GTS contains the format like: GTS=GG,GT,TT or GTS=A1A1,A1R,RR
                addGenotypeWithGTS(variant, sourceEntry, gtcs, alternateAlleles, numAllele, variantStats);
            } else {
                for (int i = 0; i < gtcs.length; i++) {
                    String[] gtcSplit = gtcs[i].split(":");
                    Integer alleles[] = new Integer[2];
                    Integer gtc = 0;
                    String gt = null;
                    boolean parseable = true;
                    if (gtcSplit.length == 1) { // GTC=0,5,8
                        getGenotype(i, alleles);
                        gtc = Integer.parseInt(gtcs[i]);
                        gt = VariantVcfFactory.mapToMultiallelicIndex(alleles[0], numAllele) + "/" + VariantVcfFactory.mapToMultiallelicIndex(alleles[1], numAllele);
                    } else {    // GTC=0/0:0,0/1:5,1/1:8
                        Matcher matcher = numNum.matcher(gtcSplit[0]);
                        if (matcher.matches()) {    // number/number:number
                            alleles[0] = Integer.parseInt(matcher.group(1));
                            alleles[1] = Integer.parseInt(matcher.group(2));
                            gtc = Integer.parseInt(gtcSplit[1]);
                            gt = VariantVcfFactory.mapToMultiallelicIndex(alleles[0], numAllele) + "/" + VariantVcfFactory.mapToMultiallelicIndex(alleles[1], numAllele);
                        } else {
                            if (gtcSplit[0].equals("./.")) {    // ./.:number
                                alleles[0] = -1;
                                alleles[1] = -1;
                                gtc = Integer.parseInt(gtcSplit[1]);
                                gt = "./.";
                            } else {
                                parseable = false;
                            }
                        }
                    }
                    if (parseable) {
                        Genotype genotype = new Genotype(gt, variant.getReference(), alternateAlleles[numAllele]);
                        variantStats.addGenotype(genotype, gtc);
                    }
                }
            }
        }
    }

    public static void addGenotypeWithGTS(Variant variant, VariantSourceEntry sourceEntry, String[] splitsGTC, String[] alternateAlleles
            , int numAllele, VariantStats cohortStats) {
        if (sourceEntry.hasAttribute("GTS")) {
            String splitsGTS[] = sourceEntry.getAttribute("GTS").split(COMMA);
            if (splitsGTC.length == splitsGTS.length) {
                for (int i = 0; i < splitsGTC.length; i++) {
                    String gt = splitsGTS[i];
                    int gtCount = Integer.parseInt(splitsGTC[i]);

                    Genotype g = VariantAggregatedVcfFactory.parseGenotype(gt, variant, numAllele, alternateAlleles);
                    if (g != null) {
                        cohortStats.addGenotype(g, gtCount);
                    }
                }
            }
        }
    }

    /**
     * returns in alleles[] the genotype specified in index in the sequence:
     * 0/0, 0/1, 1/1, 0/2, 1/2, 2/2, 0/3...
     * @param index in this sequence, starting in 0
     * @param alleles returned genotype.
     */
    public static void getGenotype(int index, Integer alleles[]) {
//        index++;
//        double value = (-3 + Math.sqrt(1 + 8 * index)) / 2;    // slower than the iterating version, right?
//        alleles[1] = new Double(Math.ceil(value)).intValue();
//        alleles[0] = alleles[1] - ((alleles[1] + 1) * (alleles[1] +2) / 2 - index);

        int cursor = 0;
        final int MAX_ALLOWED_ALLELES = 100;   // should we allow more than 100 alleles?
        for (int i = 0; i < MAX_ALLOWED_ALLELES; i++) {
            for (int j = 0; j <= i; j++) {
                if (cursor == index) {
                    alleles[0] = j;
                    alleles[1] = i;
                    return;
                }
                cursor++;
            }
        }
    }
}
