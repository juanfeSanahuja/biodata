//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.03.15 at 01:36:40 AM GMT 
//


package org.opencb.biodata.formats.variant.clinvar.vcv.v10jaxb;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * A structure to support reporting the name of a submitter, its
 *             organization id, and its abbreviation and type
 * 
 * <p>Java class for SubmitterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubmitterType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}SubmitterIdentifiers"/>
 *       &lt;attribute name="Type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="primary"/>
 *             &lt;enumeration value="secondary"/>
 *             &lt;enumeration value="behalf"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitterType")
public class SubmitterType {

    @XmlAttribute(name = "Type", required = true)
    protected String type;
    @XmlAttribute(name = "SubmitterName", required = true)
    protected String submitterName;
    @XmlAttribute(name = "OrgID", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger orgID;
    @XmlAttribute(name = "OrganizationCategory", required = true)
    protected String organizationCategory;
    @XmlAttribute(name = "OrgAbbreviation")
    protected String orgAbbreviation;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the submitterName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubmitterName() {
        return submitterName;
    }

    /**
     * Sets the value of the submitterName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubmitterName(String value) {
        this.submitterName = value;
    }

    /**
     * Gets the value of the orgID property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setOrgID(BigInteger value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the organizationCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrganizationCategory() {
        return organizationCategory;
    }

    /**
     * Sets the value of the organizationCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrganizationCategory(String value) {
        this.organizationCategory = value;
    }

    /**
     * Gets the value of the orgAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgAbbreviation() {
        return orgAbbreviation;
    }

    /**
     * Sets the value of the orgAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgAbbreviation(String value) {
        this.orgAbbreviation = value;
    }

}
