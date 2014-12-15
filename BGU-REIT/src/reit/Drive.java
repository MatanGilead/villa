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

	private static void createAssetContentsRepairDetails(Management management) {
		AssetContentsRepairDetails AssetreturnObject= (AssetContentsRepairDetails)returnObject ("AssetContentsRepairDetails.xml","AssetContentsRepairDetails.class");
		List<AssetContentsRepairDetails.AssetContent> list = AssetreturnObject
				.getAssetContent();
		for (AssetContentsRepairDetails.AssetContent assetContent : list) {
			assetContent.getName();
			assetContent.getTools();
			assetContent.getMaterials();
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