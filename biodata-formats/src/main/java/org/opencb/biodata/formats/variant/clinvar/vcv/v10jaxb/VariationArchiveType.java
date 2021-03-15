//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.15 at 01:36:40 AM GMT 
//


package org.opencb.biodata.formats.variant.clinvar.vcv.v10jaxb;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *  This element groups the set of data specific to a VariationArchive 
 *             record, namely the summary data of what has been submitted about a VariationID AND
 *             for Interpreted records only, the content each submission (SCV) provided. 
 *          
 * 
 * <p>Java class for VariationArchiveType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VariationArchiveType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RecordStatus">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="current"/>
 *               &lt;enumeration value="previous"/>
 *               &lt;enumeration value="replaced"/>
 *               &lt;enumeration value="deleted"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="ReplacedBy" type="{}typeRecordHistory" minOccurs="0"/>
 *         &lt;element name="ReplacedList" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Replaced" type="{}typeRecordHistory" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Comment" type="{}typeComment" minOccurs="0"/>
 *         &lt;element name="Species">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attribute name="TaxonomyId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;choice>
 *           &lt;element ref="{}InterpretedRecord"/>
 *           &lt;element ref="{}IncludedRecord"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="VariationID" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="VariationName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="VariationType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DateCreated" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="DateLastUpdated" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Accession" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="NumberOfSubmitters" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="NumberOfSubmissions" use="required" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *       &lt;attribute name="RecordType" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariationArchiveType", propOrder = {
    "recordStatus",
    "replacedBy",
    "replacedList",
    "comment",
    "species",
    "interpretedRecord",
    "includedRecord"
})
public class VariationArchiveType {

    @XmlElement(name = "RecordStatus", required = true, defaultValue = "current")
    protected String recordStatus;
    @XmlElement(name = "ReplacedBy")
    protected TypeRecordHistory replacedBy;
    @XmlElement(name = "ReplacedList")
    protected VariationArchiveType.ReplacedList replacedList;
    @XmlElement(name = "Comment")
    protected TypeComment comment;
    @XmlElement(name = "Species", required = true)
    protected VariationArchiveType.Species species;
    @XmlElement(name = "InterpretedRecord")
    protected InterpretedRecord interpretedRecord;
    @XmlElement(name = "IncludedRecord")
    protected IncludedRecord includedRecord;
    @XmlAttribute(name = "VariationID", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger variationID;
    @XmlAttribute(name = "VariationName", required = true)
    protected String variationName;
    @XmlAttribute(name = "VariationType", required = true)
    protected String variationType;
    @XmlAttribute(name = "DateCreated", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateCreated;
    @XmlAttribute(name = "DateLastUpdated")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateLastUpdated;
    @XmlAttribute(name = "Accession", required = true)
    protected String accession;
    @XmlAttribute(name = "Version", required = true)
    protected int version;
    @XmlAttribute(name = "NumberOfSubmitters", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfSubmitters;
    @XmlAttribute(name = "NumberOfSubmissions", required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger numberOfSubmissions;
    @XmlAttribute(name = "RecordType", required = true)
    protected String recordType;

    /**
     * Gets the value of the recordStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     * Sets the value of the recordStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordStatus(String value) {
        this.recordStatus = value;
    }

    /**
     * Gets the value of the replacedBy property.
     * 
     * @return
     *     possible object is
     *     {@link TypeRecordHistory }
     *     
     */
    public TypeRecordHistory getReplacedBy() {
        return replacedBy;
    }

    /**
     * Sets the value of the replacedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeRecordHistory }
     *     
     */
    public void setReplacedBy(TypeRecordHistory value) {
        this.replacedBy = value;
    }

    /**
     * Gets the value of the replacedList property.
     * 
     * @return
     *     possible object is
     *     {@link VariationArchiveType.ReplacedList }
     *     
     */
    public VariationArchiveType.ReplacedList getReplacedList() {
        return replacedList;
    }

    /**
     * Sets the value of the replacedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariationArchiveType.ReplacedList }
     *     
     */
    public void setReplacedList(VariationArchiveType.ReplacedList value) {
        this.replacedList = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link TypeComment }
     *     
     */
    public TypeComment getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeComment }
     *     
     */
    public void setComment(TypeComment value) {
        this.comment = value;
    }

    /**
     * Gets the value of the species property.
     * 
     * @return
     *     possible object is
     *     {@link VariationArchiveType.Species }
     *     
     */
    public VariationArchiveType.Species getSpecies() {
        return species;
    }

    /**
     * Sets the value of the species property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariationArchiveType.Species }
     *     
     */
    public void setSpecies(VariationArchiveType.Species value) {
        this.species = value;
    }

    /**
     *  This element describes the interpretation of a single
     *                               allele, haplotype, or genotype based on all submissions to ClinVar.
     *                               This differs from the element IncludedRecord, which describes simple
     *                               alleles or haplotypes, referenced in InterpretedRecord, but for which
     *                               no explicit interpretation was submitted. Once that variation is
     *                               described, details are added about the phenotypes being interpreted,
     *                               the intepretation, the submitters providing the intepretations, and
     *                               all supported evidence.
     * 
     * @return
     *     possible object is
     *     {@link InterpretedRecord }
     *     
     */
    public InterpretedRecord getInterpretedRecord() {
        return interpretedRecord;
    }

    /**
     * Sets the value of the interpretedRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link InterpretedRecord }
     *     
     */
    public void setInterpretedRecord(InterpretedRecord value) {
        this.interpretedRecord = value;
    }

    /**
     *  This element describes a single allele or haplotype
     *                               included in submissions to ClinVar, but for which no explicit
     *                               interpretation was submitted. It also references the submissions and
     *                               the Interpreted records that include them. 
     * 
     * @return
     *     possible object is
     *     {@link IncludedRecord }
     *     
     */
    public IncludedRecord getIncludedRecord() {
        return includedRecord;
    }

    /**
     * Sets the value of the includedRecord property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncludedRecord }
     *     
     */
    public void setIncludedRecord(IncludedRecord value) {
        this.includedRecord = value;
    }

    /**
     * Gets the value of the variationID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVariationID() {
        return variationID;
    }

    /**
     * Sets the value of the variationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVariationID(BigInteger value) {
        this.variationID = value;
    }

    /**
     * Gets the value of the variationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariationName() {
        return variationName;
    }

    /**
     * Sets the value of the variationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariationName(String value) {
        this.variationName = value;
    }

    /**
     * Gets the value of the variationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVariationType() {
        return variationType;
    }

    /**
     * Sets the value of the variationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVariationType(String value) {
        this.variationType = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCreated(XMLGregorianCalendar value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the dateLastUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastUpdated() {
        return dateLastUpdated;
    }

    /**
     * Sets the value of the dateLastUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastUpdated(XMLGregorianCalendar value) {
        this.dateLastUpdated = value;
    }

    /**
     * Gets the value of the accession property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccession() {
        return accession;
    }

    /**
     * Sets the value of the accession property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccession(String value) {
        this.accession = value;
    }

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the numberOfSubmitters property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfSubmitters() {
        return numberOfSubmitters;
    }

    /**
     * Sets the value of the numberOfSubmitters property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfSubmitters(BigInteger value) {
        this.numberOfSubmitters = value;
    }

    /**
     * Gets the value of the numberOfSubmissions property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfSubmissions() {
        return numberOfSubmissions;
    }

    /**
     * Sets the value of the numberOfSubmissions property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfSubmissions(BigInteger value) {
        this.numberOfSubmissions = value;
    }

    /**
     * Gets the value of the recordType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecordType() {
        return recordType;
    }

    /**
     * Sets the value of the recordType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecordType(String value) {
        this.recordType = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Replaced" type="{}typeRecordHistory" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "replaced"
    })
    public static class ReplacedList {

        @XmlElement(name = "Replaced", required = true)
        protected List<TypeRecordHistory> replaced;

        /**
         * Gets the value of the replaced property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the replaced property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReplaced().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypeRecordHistory }
         * 
         * 
         */
        public List<TypeRecordHistory> getReplaced() {
            if (replaced == null) {
                replaced = new ArrayList<TypeRecordHistory>();
            }
            return this.replaced;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attribute name="TaxonomyId" type="{http://www.w3.org/2001/XMLSchema}int" />
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Species {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "TaxonomyId")
        protected Integer taxonomyId;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the taxonomyId property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getTaxonomyId() {
            return taxonomyId;
        }

        /**
         * Sets the value of the taxonomyId property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setTaxonomyId(Integer value) {
            this.taxonomyId = value;
        }

    }

}
