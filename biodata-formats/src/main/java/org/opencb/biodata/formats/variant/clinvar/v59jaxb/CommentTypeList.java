//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.01.28 at 11:05:29 AM GMT 
//


package org.opencb.biodata.formats.variant.clinvar.v59jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommentTypeList.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommentTypeList">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="public"/>
 *     &lt;enumeration value="ConvertedByNCBI"/>
 *     &lt;enumeration value="MissingFromAssembly"/>
 *     &lt;enumeration value="GenomicLocationNotEstablished"/>
 *     &lt;enumeration value="LocationOnGenomeAndProductNotAligned"/>
 *     &lt;enumeration value="DeletionComment"/>
 *     &lt;enumeration value="MergeComment"/>
 *     &lt;enumeration value="AssemblySpecificAlleleDefinition"/>
 *     &lt;enumeration value="AlignmentGapMakesAppearInconsistent"/>
 *     &lt;enumeration value="ExplanationOfInterpretation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommentTypeList")
@XmlEnum
public enum CommentTypeList {

    @XmlEnumValue("public")
    PUBLIC("public"),
    @XmlEnumValue("ConvertedByNCBI")
    CONVERTED_BY_NCBI("ConvertedByNCBI"),
    @XmlEnumValue("MissingFromAssembly")
    MISSING_FROM_ASSEMBLY("MissingFromAssembly"),
    @XmlEnumValue("GenomicLocationNotEstablished")
    GENOMIC_LOCATION_NOT_ESTABLISHED("GenomicLocationNotEstablished"),
    @XmlEnumValue("LocationOnGenomeAndProductNotAligned")
    LOCATION_ON_GENOME_AND_PRODUCT_NOT_ALIGNED("LocationOnGenomeAndProductNotAligned"),
    @XmlEnumValue("DeletionComment")
    DELETION_COMMENT("DeletionComment"),
    @XmlEnumValue("MergeComment")
    MERGE_COMMENT("MergeComment"),
    @XmlEnumValue("AssemblySpecificAlleleDefinition")
    ASSEMBLY_SPECIFIC_ALLELE_DEFINITION("AssemblySpecificAlleleDefinition"),
    @XmlEnumValue("AlignmentGapMakesAppearInconsistent")
    ALIGNMENT_GAP_MAKES_APPEAR_INCONSISTENT("AlignmentGapMakesAppearInconsistent"),
    @XmlEnumValue("ExplanationOfInterpretation")
    EXPLANATION_OF_INTERPRETATION("ExplanationOfInterpretation");
    private final String value;

    CommentTypeList(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommentTypeList fromValue(String v) {
        for (CommentTypeList c: CommentTypeList.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
