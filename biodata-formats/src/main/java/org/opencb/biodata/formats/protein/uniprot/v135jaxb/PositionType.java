/*
 * Copyright 2015 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//
// This path was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this path will be lost upon recompilation of the source schema.
// Generated on: 2010.06.14 at 12:38:27 PM CEST 
//


package org.opencb.biodata.formats.protein.uniprot.v135jaxb;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;


/**
 * <p>Java class for positionType complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="positionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="position" type="{http://www.w3.org/2001/XMLSchema}unsignedLong" />
 *       &lt;attribute name="status" default="certain">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="certain"/>
 *             &lt;enumeration value="uncertain"/>
 *             &lt;enumeration value="less than"/>
 *             &lt;enumeration value="greater than"/>
 *             &lt;enumeration value="unknown"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="evidence" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "positionType")
public class PositionType {

    @XmlAttribute
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger position;
    @XmlAttribute
    protected String status;
    @XmlAttribute
    protected String evidence;

    /**
     * Gets the value of the position property.
     *
     * @return possible object is
     *         {@link java.math.BigInteger }
     */
    public BigInteger getPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     *
     * @param value allowed object is
     *              {@link java.math.BigInteger }
     */
    public void setPosition(BigInteger value) {
        this.position = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getStatus() {
        if (status == null) {
            return "certain";
        } else {
            return status;
        }
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the evidence property.
     *
     * @return possible object is
     *         {@link String }
     */
    public String getEvidence() {
        return evidence;
    }

    /**
     * Sets the value of the evidence property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEvidence(String value) {
        this.evidence = value;
    }

}
