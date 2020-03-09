//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.03.09 at 11:00:25 AM GMT 
//


package org.opencb.biodata.formats.protein.uniprot;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nameListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nameListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="consortium" type="{http://uniprot.org/uniprot}consortiumType"/>
 *         &lt;element name="person" type="{http://uniprot.org/uniprot}personType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nameListType", propOrder = {
    "consortiumOrPerson"
})
public class NameListType {

    @XmlElements({
        @XmlElement(name = "consortium", type = ConsortiumType.class),
        @XmlElement(name = "person", type = PersonType.class)
    })
    protected List<Object> consortiumOrPerson;

    /**
     * Gets the value of the consortiumOrPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the consortiumOrPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConsortiumOrPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsortiumType }
     * {@link PersonType }
     * 
     * 
     */
    public List<Object> getConsortiumOrPerson() {
        if (consortiumOrPerson == null) {
            consortiumOrPerson = new ArrayList<Object>();
        }
        return this.consortiumOrPerson;
    }

}
