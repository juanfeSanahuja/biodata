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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for typeRCV complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeRCV">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="InterpretedConditionList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="InterpretedCondition" type="{}typeRCVInterpretedCondition" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="TraitSetID" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
 *       &lt;/sequence>
 *       &lt;attribute name="Title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="DateLastEvaluated" type="{http://www.w3.org/2001/XMLSchema}date" />
 *       &lt;attribute name="Interpretation" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="SubmissionCount" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *       &lt;attribute name="ReviewStatus" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Accession" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Version" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeRCV", propOrder = {
    "interpretedConditionList",
    "replacedList"
})
public class TypeRCV {

    @XmlElement(name = "InterpretedConditionList", required = true)
    protected TypeRCV.InterpretedConditionList interpretedConditionList;
    @XmlElement(name = "ReplacedList")
    protected TypeRCV.ReplacedList replacedList;
    @XmlAttribute(name = "Title")
    protected String title;
    @XmlAttribute(name = "DateLastEvaluated")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateLastEvaluated;
    @XmlAttribute(name = "Interpretation")
    protected String interpretation;
    @XmlAttribute(name = "SubmissionCount", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger submissionCount;
    @XmlAttribute(name = "ReviewStatus", required = true)
    protected String reviewStatus;
    @XmlAttribute(name = "Accession", required = true)
    protected String accession;
    @XmlAttribute(name = "Version", required = true)
    protected BigInteger version;

    /**
     * Gets the value of the interpretedConditionList property.
     * 
     * @return
     *     possible object is
     *     {@link TypeRCV.InterpretedConditionList }
     *     
     */
    public TypeRCV.InterpretedConditionList getInterpretedConditionList() {
        return interpretedConditionList;
    }

    /**
     * Sets the value of the interpretedConditionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeRCV.InterpretedConditionList }
     *     
     */
    public void setInterpretedConditionList(TypeRCV.InterpretedConditionList value) {
        this.interpretedConditionList = value;
    }

    /**
     * Gets the value of the replacedList property.
     * 
     * @return
     *     possible object is
     *     {@link TypeRCV.ReplacedList }
     *     
     */
    public TypeRCV.ReplacedList getReplacedList() {
        return replacedList;
    }

    /**
     * Sets the value of the replacedList property.
     * 
     * @param value
     *     allowed object is
     *     {@link TypeRCV.ReplacedList }
     *     
     */
    public void setReplacedList(TypeRCV.ReplacedList value) {
        this.replacedList = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the dateLastEvaluated property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateLastEvaluated() {
        return dateLastEvaluated;
    }

    /**
     * Sets the value of the dateLastEvaluated property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateLastEvaluated(XMLGregorianCalendar value) {
        this.dateLastEvaluated = value;
    }

    /**
     * Gets the value of the interpretation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpretation() {
        return interpretation;
    }

    /**
     * Sets the value of the interpretation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpretation(String value) {
        this.interpretation = value;
    }

    /**
     * Gets the value of the submissionCount property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSubmissionCount() {
        return submissionCount;
    }

    /**
     * Sets the value of the submissionCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSubmissionCount(BigInteger value) {
        this.submissionCount = value;
    }

    /**
     * Gets the value of the reviewStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewStatus() {
        return reviewStatus;
    }

    /**
     * Sets the value of the reviewStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewStatus(String value) {
        this.reviewStatus = value;
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
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setVersion(BigInteger value) {
        this.version = value;
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
     *         &lt;element name="InterpretedCondition" type="{}typeRCVInterpretedCondition" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *       &lt;attribute name="TraitSetID" use="required" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "interpretedCondition"
    })
    public static class InterpretedConditionList {

        @XmlElement(name = "InterpretedCondition")
        protected List<TypeRCVInterpretedCondition> interpretedCondition;
        @XmlAttribute(name = "TraitSetID", required = true)
        @XmlSchemaType(name = "positiveInteger")
        protected BigInteger traitSetID;

        /**
         * Gets the value of the interpretedCondition property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the interpretedCondition property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInterpretedCondition().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TypeRCVInterpretedCondition }
         * 
         * 
         */
        public List<TypeRCVInterpretedCondition> getInterpretedCondition() {
            if (interpretedCondition == null) {
                interpretedCondition = new ArrayList<TypeRCVInterpretedCondition>();
            }
            return this.interpretedCondition;
        }

        /**
         * Gets the value of the traitSetID property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getTraitSetID() {
            return traitSetID;
        }

        /**
         * Sets the value of the traitSetID property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setTraitSetID(BigInteger value) {
            this.traitSetID = value;
        }

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

}