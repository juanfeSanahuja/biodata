/*
 * <!--
 *   ~ Copyright 2015-2017 OpenCB
 *   ~
 *   ~ Licensed under the Apache License, Version 2.0 (the "License");
 *   ~ you may not use this file except in compliance with the License.
 *   ~ You may obtain a copy of the License at
 *   ~
 *   ~     http://www.apache.org/licenses/LICENSE-2.0
 *   ~
 *   ~ Unless required by applicable law or agreed to in writing, software
 *   ~ distributed under the License is distributed on an "AS IS" BASIS,
 *   ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   ~ See the License for the specific language governing permissions and
 *   ~ limitations under the License.
 *   -->
 *
 */

package org.opencb.biodata.tools.clinical;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.opencb.biodata.models.clinical.interpretation.ClinicalProperty.ModeOfInheritance;
import org.opencb.biodata.models.clinical.interpretation.ClinicalProperty.Penetrance;
import org.opencb.biodata.models.clinical.interpretation.ClinicalProperty.RoleInCancer;
import org.opencb.biodata.models.clinical.interpretation.DiseasePanel;
import org.opencb.biodata.models.clinical.interpretation.ReportedEvent;
import org.opencb.biodata.models.clinical.interpretation.ReportedVariant;
import org.opencb.biodata.models.clinical.interpretation.exceptions.InterpretationAnalysisException;
import org.opencb.biodata.models.commons.Disorder;
import org.opencb.biodata.models.variant.Variant;
import org.opencb.biodata.models.variant.avro.ConsequenceType;

import java.util.*;
import java.util.stream.Collectors;

import static org.opencb.biodata.models.clinical.interpretation.VariantClassification.*;
import static org.opencb.biodata.tools.pedigree.ModeOfInheritance.proteinCoding;

public class TeamReportedVariantCreator extends ReportedVariantCreator {

    public TeamReportedVariantCreator(List<DiseasePanel> diseasePanels, Map<String, RoleInCancer> roleInCancer,
                                      Map<String, List<String>> actionableVariants, Disorder disorder, ModeOfInheritance modeOfInheritance,
                                      Penetrance penetrance) {
        super(diseasePanels, disorder, modeOfInheritance, penetrance, roleInCancer, actionableVariants, null);
    }

    @Override
    public List<ReportedVariant> create(List<Variant> variants) throws InterpretationAnalysisException {
        // Sanity check
        if (variants == null || variants.isEmpty()) {
            return Collections.emptyList();
        }

        // Panels are mandatory in Tiering analysis
        if (CollectionUtils.isEmpty(diseasePanels)) {
            throw new InterpretationAnalysisException("Missing gene panels for TEAM analysis");
        }

        geneToPanelMap = getGeneToPanelMap(diseasePanels);
        variantToPanelMap = getVariantToPanelMap(diseasePanels);

        boolean hasTier;

        List<ReportedVariant> reportedVariants = new ArrayList<>();
        for (Variant variant : variants) {
            hasTier = false;
            List<ReportedEvent> reportedEvents = new ArrayList<>();

            if (MapUtils.isNotEmpty(variantToPanelMap) && variantToPanelMap.containsKey(variant.getId())
                    && CollectionUtils.isNotEmpty(variantToPanelMap.get(variant.getId()))) {
                // Tier 1, variant in panel
                hasTier = true;

                Set<DiseasePanel> panels = variantToPanelMap.get(variant.getId());
                List<String> panelIds = panels.stream().map(DiseasePanel::getId).collect(Collectors.toList());

                if (variant.getAnnotation() != null && CollectionUtils.isNotEmpty(variant.getAnnotation().getConsequenceTypes())) {
                    for (ConsequenceType ct : variant.getAnnotation().getConsequenceTypes()) {
                        if (ct.getBiotype() != null && proteinCoding.contains(ct.getBiotype())) {
                            reportedEvents.addAll(createReportedEvents(TIER_1, panelIds, ct, variant));
                        }
                    }
                } else {
                    // We create the reported events anyway!
                    reportedEvents.addAll(createReportedEvents(TIER_1, panelIds, null, variant));
                }
            } else {
                // Tier 2
                if (variant.getAnnotation() != null && CollectionUtils.isNotEmpty(variant.getAnnotation().getConsequenceTypes())) {
                    for (ConsequenceType ct : variant.getAnnotation().getConsequenceTypes()) {
                        if (ct.getBiotype() != null && proteinCoding.contains(ct.getBiotype())) {
                            if (MapUtils.isNotEmpty(geneToPanelMap) && geneToPanelMap.containsKey(ct.getEnsemblGeneId())
                                    && CollectionUtils.isNotEmpty(geneToPanelMap.get(ct.getEnsemblGeneId()))) {
                                // Tier 2, gene in panel
                                hasTier = true;
                                Set<DiseasePanel> panels = geneToPanelMap.get(ct.getEnsemblGeneId());
                                List<String> panelIds = panels.stream().map(DiseasePanel::getId).collect(Collectors.toList());

                                reportedEvents.addAll(createReportedEvents(TIER_2, panelIds, ct, variant));
                            }
                        }
                    }
                }
            }

            // Tier 3, actionable variants
            if (!hasTier && MapUtils.isNotEmpty(actionableVariants)) {
                if (variant.getAnnotation() != null && actionableVariants.containsKey(variant.getId())) {
                    if (CollectionUtils.isNotEmpty(variant.getAnnotation().getConsequenceTypes())) {
                        for (ConsequenceType ct : variant.getAnnotation().getConsequenceTypes()) {
                            if (ct.getBiotype() != null && proteinCoding.contains(ct.getBiotype())) {
                                reportedEvents.addAll(createReportedEvents(UNTIERED, null, ct, variant));
                            }
                        }
                    } else {
                        // We create the reported events anyway!
                        reportedEvents.addAll(createReportedEvents(UNTIERED, null, null, variant));
                    }
                }
            }

            // If we have reported events, then we have to create the reported variant
            if (CollectionUtils.isNotEmpty(reportedEvents)) {
                ReportedVariant reportedVariant = new ReportedVariant(variant.getImpl(), 0, new ArrayList<>(),
                        Collections.emptyList(), ReportedVariant.Status.NOT_REVIEWED, Collections.emptyMap());
                reportedVariant.setEvidences(reportedEvents);

                // Add variant to the list
                reportedVariants.add(reportedVariant);
            }
        }
        return reportedVariants;
    }
}