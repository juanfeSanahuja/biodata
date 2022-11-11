//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.05.23 at 12:52:46 PM UTC 
//


package org.opencb.biodata.formats.pubmed.v233jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}MedlineCitation"/&gt;
 *         &lt;element ref="{}PubmedData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "medlineCitation",
    "pubmedData"
})
@XmlRootElement(name = "PubmedArticle")
public class PubmedArticle {

    @XmlElement(name = "MedlineCitation", required = true)
    protected MedlineCitation medlineCitation;
    @XmlElement(name = "PubmedData")
    protected PubmedData pubmedData;

    /**
     * Gets the value of the medlineCitation property.
     * 
     * @return
     *     possible object is
     *     {@link MedlineCitation }
     *     
     */
    public MedlineCitation getMedlineCitation() {
        return medlineCitation;
    }

    /**
     * Sets the value of the medlineCitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link MedlineCitation }
     *     
     */
    public void setMedlineCitation(MedlineCitation value) {
        this.medlineCitation = value;
    }

    /**
     * Gets the value of the pubmedData property.
     * 
     * @return
     *     possible object is
     *     {@link PubmedData }
     *     
     */
    public PubmedData getPubmedData() {
        return pubmedData;
    }

    /**
     * Sets the value of the pubmedData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PubmedData }
     *     
     */
    public void setPubmedData(PubmedData value) {
        this.pubmedData = value;
    }

}