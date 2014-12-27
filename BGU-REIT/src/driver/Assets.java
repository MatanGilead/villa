//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.22 at 07:14:11 PM IST 
//


package driver;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="Asset" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="Location">
 *                     &lt;complexType>
 *                       &lt;simpleContent>
 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                           &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                         &lt;/extension>
 *                       &lt;/simpleContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="CostPerNight" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="AssetContents">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AssetContent" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="RepairMultiplier" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "asset"
})
@XmlRootElement(name = "Assets")
public class Assets {

    @XmlElement(name = "Asset")
    protected List<Assets.Asset> asset;

    /**
     * Gets the value of the asset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Assets.Asset }
     * 
     * 
     */
    public List<Assets.Asset> getAsset() {
        if (asset == null) {
            asset = new ArrayList<Assets.Asset>();
        }
        return this.asset;
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
     *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Type" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Size" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="Location">
     *           &lt;complexType>
     *             &lt;simpleContent>
     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                 &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *               &lt;/extension>
     *             &lt;/simpleContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="CostPerNight" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="AssetContents">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AssetContent" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="RepairMultiplier" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
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
        "name",
        "type",
        "size",
        "location",
        "costPerNight",
        "assetContents"
    })
    public static class Asset {

        @XmlElement(name = "Name", required = true)
        protected String name;
        @XmlElement(name = "Type", required = true)
        protected String type;
        @XmlElement(name = "Size")
        protected byte size;
        @XmlElement(name = "Location", required = true)
        protected Assets.Asset.Location location;
        @XmlElement(name = "CostPerNight")
        protected byte costPerNight;
        @XmlElement(name = "AssetContents", required = true)
        protected Assets.Asset.AssetContents assetContents;

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

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
         * Gets the value of the size property.
         * 
         */
        public byte getSize() {
            return size;
        }

        /**
         * Sets the value of the size property.
         * 
         */
        public void setSize(byte value) {
            this.size = value;
        }

        /**
         * Gets the value of the location property.
         * 
         * @return
         *     possible object is
         *     {@link Assets.Asset.Location }
         *     
         */
        public Assets.Asset.Location getLocation() {
            return location;
        }

        /**
         * Sets the value of the location property.
         * 
         * @param value
         *     allowed object is
         *     {@link Assets.Asset.Location }
         *     
         */
        public void setLocation(Assets.Asset.Location value) {
            this.location = value;
        }

        /**
         * Gets the value of the costPerNight property.
         * 
         */
        public byte getCostPerNight() {
            return costPerNight;
        }

        /**
         * Sets the value of the costPerNight property.
         * 
         */
        public void setCostPerNight(byte value) {
            this.costPerNight = value;
        }

        /**
         * Gets the value of the assetContents property.
         * 
         * @return
         *     possible object is
         *     {@link Assets.Asset.AssetContents }
         *     
         */
        public Assets.Asset.AssetContents getAssetContents() {
            return assetContents;
        }

        /**
         * Sets the value of the assetContents property.
         * 
         * @param value
         *     allowed object is
         *     {@link Assets.Asset.AssetContents }
         *     
         */
        public void setAssetContents(Assets.Asset.AssetContents value) {
            this.assetContents = value;
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
         *         &lt;element name="AssetContent" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="RepairMultiplier" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
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
            "assetContent"
        })
        public static class AssetContents {

            @XmlElement(name = "AssetContent")
            protected List<Assets.Asset.AssetContents.AssetContent> assetContent;

            /**
             * Gets the value of the assetContent property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the assetContent property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getAssetContent().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Assets.Asset.AssetContents.AssetContent }
             * 
             * 
             */
            public List<Assets.Asset.AssetContents.AssetContent> getAssetContent() {
                if (assetContent == null) {
                    assetContent = new ArrayList<Assets.Asset.AssetContents.AssetContent>();
                }
                return this.assetContent;
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
             *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="RepairMultiplier" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
                "name",
                "repairMultiplier"
            })
            public static class AssetContent {

                @XmlElement(name = "Name", required = true)
                protected String name;
                @XmlElement(name = "RepairMultiplier")
                protected float repairMultiplier;

                /**
                 * Gets the value of the name property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getName() {
                    return name;
                }

                /**
                 * Sets the value of the name property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setName(String value) {
                    this.name = value;
                }

                /**
                 * Gets the value of the repairMultiplier property.
                 * 
                 */
                public float getRepairMultiplier() {
                    return repairMultiplier;
                }

                /**
                 * Sets the value of the repairMultiplier property.
                 * 
                 */
                public void setRepairMultiplier(float value) {
                    this.repairMultiplier = value;
                }

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
         *       &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}byte" />
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
        public static class Location {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "x")
            protected Byte x;
            @XmlAttribute(name = "y")
            protected Byte y;

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
             * Gets the value of the x property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getX() {
                return x;
            }

            /**
             * Sets the value of the x property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setX(Byte value) {
                this.x = value;
            }

            /**
             * Gets the value of the y property.
             * 
             * @return
             *     possible object is
             *     {@link Byte }
             *     
             */
            public Byte getY() {
                return y;
            }

            /**
             * Sets the value of the y property.
             * 
             * @param value
             *     allowed object is
             *     {@link Byte }
             *     
             */
            public void setY(Byte value) {
                this.y = value;
            }

        }

    }

}
