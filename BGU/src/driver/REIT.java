//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.15 at 05:02:48 PM IST 
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
 *         &lt;element name="Warehouse">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Tools">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Tool" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
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
 *                   &lt;element name="Materials">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Material" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
 *         &lt;element name="Staff">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Clerks">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Clerk" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="Location">
 *                                         &lt;complexType>
 *                                           &lt;simpleContent>
 *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                               &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                               &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                             &lt;/extension>
 *                                           &lt;/simpleContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
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
 *                   &lt;element name="NumberOfMaintenancePersons" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="TotalNumberOfRentalRequests" type="{http://www.w3.org/2001/XMLSchema}byte"/>
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
    "warehouse",
    "staff"
})
@XmlRootElement(name = "REIT")
public class REIT {

    @XmlElement(name = "Warehouse", required = true)
    protected REIT.Warehouse warehouse;
    @XmlElement(name = "Staff", required = true)
    protected REIT.Staff staff;

    /**
     * Gets the value of the warehouse property.
     * 
     * @return
     *     possible object is
     *     {@link REIT.Warehouse }
     *     
     */
    public REIT.Warehouse getWarehouse() {
        return warehouse;
    }

    /**
     * Sets the value of the warehouse property.
     * 
     * @param value
     *     allowed object is
     *     {@link REIT.Warehouse }
     *     
     */
    public void setWarehouse(REIT.Warehouse value) {
        this.warehouse = value;
    }

    /**
     * Gets the value of the staff property.
     * 
     * @return
     *     possible object is
     *     {@link REIT.Staff }
     *     
     */
    public REIT.Staff getStaff() {
        return staff;
    }

    /**
     * Sets the value of the staff property.
     * 
     * @param value
     *     allowed object is
     *     {@link REIT.Staff }
     *     
     */
    public void setStaff(REIT.Staff value) {
        this.staff = value;
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
     *         &lt;element name="Clerks">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Clerk" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="Location">
     *                               &lt;complexType>
     *                                 &lt;simpleContent>
     *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                     &lt;attribute name="x" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                     &lt;attribute name="y" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                   &lt;/extension>
     *                                 &lt;/simpleContent>
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
     *         &lt;element name="NumberOfMaintenancePersons" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="TotalNumberOfRentalRequests" type="{http://www.w3.org/2001/XMLSchema}byte"/>
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
        "clerks",
        "numberOfMaintenancePersons",
        "totalNumberOfRentalRequests"
    })
    public static class Staff {

        @XmlElement(name = "Clerks", required = true)
        protected REIT.Staff.Clerks clerks;
        @XmlElement(name = "NumberOfMaintenancePersons")
        protected byte numberOfMaintenancePersons;
        @XmlElement(name = "TotalNumberOfRentalRequests")
        protected byte totalNumberOfRentalRequests;

        /**
         * Gets the value of the clerks property.
         * 
         * @return
         *     possible object is
         *     {@link REIT.Staff.Clerks }
         *     
         */
        public REIT.Staff.Clerks getClerks() {
            return clerks;
        }

        /**
         * Sets the value of the clerks property.
         * 
         * @param value
         *     allowed object is
         *     {@link REIT.Staff.Clerks }
         *     
         */
        public void setClerks(REIT.Staff.Clerks value) {
            this.clerks = value;
        }

        /**
         * Gets the value of the numberOfMaintenancePersons property.
         * 
         */
        public byte getNumberOfMaintenancePersons() {
            return numberOfMaintenancePersons;
        }

        /**
         * Sets the value of the numberOfMaintenancePersons property.
         * 
         */
        public void setNumberOfMaintenancePersons(byte value) {
            this.numberOfMaintenancePersons = value;
        }

        /**
         * Gets the value of the totalNumberOfRentalRequests property.
         * 
         */
        public byte getTotalNumberOfRentalRequests() {
            return totalNumberOfRentalRequests;
        }

        /**
         * Sets the value of the totalNumberOfRentalRequests property.
         * 
         */
        public void setTotalNumberOfRentalRequests(byte value) {
            this.totalNumberOfRentalRequests = value;
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
         *         &lt;element name="Clerk" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
            "clerk"
        })
        public static class Clerks {

            @XmlElement(name = "Clerk")
            protected List<REIT.Staff.Clerks.Clerk> clerk;

            /**
             * Gets the value of the clerk property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the clerk property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getClerk().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link REIT.Staff.Clerks.Clerk }
             * 
             * 
             */
            public List<REIT.Staff.Clerks.Clerk> getClerk() {
                if (clerk == null) {
                    clerk = new ArrayList<REIT.Staff.Clerks.Clerk>();
                }
                return this.clerk;
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
             *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
                "location"
            })
            public static class Clerk {

                @XmlElement(required = true)
                protected String name;
                @XmlElement(name = "Location", required = true)
                protected REIT.Staff.Clerks.Clerk.Location location;

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
                 * Gets the value of the location property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link REIT.Staff.Clerks.Clerk.Location }
                 *     
                 */
                public REIT.Staff.Clerks.Clerk.Location getLocation() {
                    return location;
                }

                /**
                 * Sets the value of the location property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link REIT.Staff.Clerks.Clerk.Location }
                 *     
                 */
                public void setLocation(REIT.Staff.Clerks.Clerk.Location value) {
                    this.location = value;
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
     *         &lt;element name="Tools">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Tool" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
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
     *         &lt;element name="Materials">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Material" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
        "tools",
        "materials"
    })
    public static class Warehouse {

        @XmlElement(name = "Tools", required = true)
        protected REIT.Warehouse.Tools tools;
        @XmlElement(name = "Materials", required = true)
        protected REIT.Warehouse.Materials materials;

        /**
         * Gets the value of the tools property.
         * 
         * @return
         *     possible object is
         *     {@link REIT.Warehouse.Tools }
         *     
         */
        public REIT.Warehouse.Tools getTools() {
            return tools;
        }

        /**
         * Sets the value of the tools property.
         * 
         * @param value
         *     allowed object is
         *     {@link REIT.Warehouse.Tools }
         *     
         */
        public void setTools(REIT.Warehouse.Tools value) {
            this.tools = value;
        }

        /**
         * Gets the value of the materials property.
         * 
         * @return
         *     possible object is
         *     {@link REIT.Warehouse.Materials }
         *     
         */
        public REIT.Warehouse.Materials getMaterials() {
            return materials;
        }

        /**
         * Sets the value of the materials property.
         * 
         * @param value
         *     allowed object is
         *     {@link REIT.Warehouse.Materials }
         *     
         */
        public void setMaterials(REIT.Warehouse.Materials value) {
            this.materials = value;
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
         *         &lt;element name="Material" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
            "material"
        })
        public static class Materials {

            @XmlElement(name = "Material")
            protected List<REIT.Warehouse.Materials.Material> material;

            /**
             * Gets the value of the material property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the material property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getMaterial().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link REIT.Warehouse.Materials.Material }
             * 
             * 
             */
            public List<REIT.Warehouse.Materials.Material> getMaterial() {
                if (material == null) {
                    material = new ArrayList<REIT.Warehouse.Materials.Material>();
                }
                return this.material;
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
             *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
                "quantity"
            })
            public static class Material {

                @XmlElement(required = true)
                protected String name;
                protected short quantity;

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
                 * Gets the value of the quantity property.
                 * 
                 */
                public short getQuantity() {
                    return quantity;
                }

                /**
                 * Sets the value of the quantity property.
                 * 
                 */
                public void setQuantity(short value) {
                    this.quantity = value;
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
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Tool" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
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
            "tool"
        })
        public static class Tools {

            @XmlElement(name = "Tool")
            protected List<REIT.Warehouse.Tools.Tool> tool;

            /**
             * Gets the value of the tool property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the tool property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTool().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link REIT.Warehouse.Tools.Tool }
             * 
             * 
             */
            public List<REIT.Warehouse.Tools.Tool> getTool() {
                if (tool == null) {
                    tool = new ArrayList<REIT.Warehouse.Tools.Tool>();
                }
                return this.tool;
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
             *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
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
                "quantity"
            })
            public static class Tool {

                @XmlElement(required = true)
                protected String name;
                protected byte quantity;

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
                 * Gets the value of the quantity property.
                 * 
                 */
                public byte getQuantity() {
                    return quantity;
                }

                /**
                 * Sets the value of the quantity property.
                 * 
                 */
                public void setQuantity(byte value) {
                    this.quantity = value;
                }

            }

        }

    }

}
