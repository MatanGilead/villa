package reit;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import driver.AssetContentsRepairDetails;

public class Drive {
	public static void main(String[] args) {
		Management management = new Management();
		createAssetContentsRepairDetails(management);

		management.start();
	}

	/**
	 * a. get JAXB Object.
	 * b. get list of AssetContents.
	 * c. for each AssetContent. get list of materials and tools.
	 * d. for each list, create RepairtToolInformation & RepairMaterialInformation containing this list.
	 * e. add them to management.
	 * 
	 */
	private static void createAssetContentsRepairDetails(Management management) {
		AssetContentsRepairDetails allAssetContents= (AssetContentsRepairDetails)returnObject ("AssetContentsRepairDetails.xml","AssetContentsRepairDetails.class");
		List<AssetContentsRepairDetails.AssetContent> list = allAssetContents.getAssetContent();
		for (AssetContentsRepairDetails.AssetContent assetContent : list) {
			RepairToolInformation tools=new RepairToolInformation(assetContent.getName());
			List<AssetContentsRepairDetails.AssetContent.Tools.Tool> toolList=assetContent.getTools().getTool();
			for(AssetContentsRepairDetails.AssetContent.Tools.Tool tool: toolList){
				tools.addRepairTool(tool.getName(), tool.getQuantity());
				}
			
			RepairMaterialInformation materials=new RepairMaterialInformation (assetContent.getName());
			List<AssetContentsRepairDetails.AssetContent.Materials.Material> materialList=assetContent.getMaterials().getMaterial();
			for(AssetContentsRepairDetails.AssetContent.Materials.Material material: materialList){
				materials.addRepairTool(material.getName(), material.getQuantity());
				}

			management.addItemRepairTool(assetContent.getName(), tools);
			management.addItemRepairMaterial(assetContent.getName(), materials);
		}
	}

	// Create an object of the required class;
	public static Object returnObject(String fileName, String className) {
		try {
			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(className);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object myObj = jaxbUnmarshaller.unmarshal(file);
			return myObj;


		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
	}



}