//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.27 at 10:52:16 PM IST 
//


package driver;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the driver package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: driver
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AssetContentsRepairDetails }
     * 
     */
    public AssetContentsRepairDetails createAssetContentsRepairDetails() {
        return new AssetContentsRepairDetails();
    }

    /**
     * Create an instance of {@link AssetContentsRepairDetails.AssetContent }
     * 
     */
    public AssetContentsRepairDetails.AssetContent createAssetContentsRepairDetailsAssetContent() {
        return new AssetContentsRepairDetails.AssetContent();
    }

    /**
     * Create an instance of {@link AssetContentsRepairDetails.AssetContent.Materials }
     * 
     */
    public AssetContentsRepairDetails.AssetContent.Materials createAssetContentsRepairDetailsAssetContentMaterials() {
        return new AssetContentsRepairDetails.AssetContent.Materials();
    }

    /**
     * Create an instance of {@link AssetContentsRepairDetails.AssetContent.Tools }
     * 
     */
    public AssetContentsRepairDetails.AssetContent.Tools createAssetContentsRepairDetailsAssetContentTools() {
        return new AssetContentsRepairDetails.AssetContent.Tools();
    }

    /**
     * Create an instance of {@link AssetContentsRepairDetails.AssetContent.Materials.Material }
     * 
     */
    public AssetContentsRepairDetails.AssetContent.Materials.Material createAssetContentsRepairDetailsAssetContentMaterialsMaterial() {
        return new AssetContentsRepairDetails.AssetContent.Materials.Material();
    }

    /**
     * Create an instance of {@link AssetContentsRepairDetails.AssetContent.Tools.Tool }
     * 
     */
    public AssetContentsRepairDetails.AssetContent.Tools.Tool createAssetContentsRepairDetailsAssetContentToolsTool() {
        return new AssetContentsRepairDetails.AssetContent.Tools.Tool();
    }

}
