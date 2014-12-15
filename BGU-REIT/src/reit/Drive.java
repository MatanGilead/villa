package reit;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import driver.Assets;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

//import driver.AssetContentsRepairDetails;

public class Drive {
	public static void main(String[] args) {
		Management management = new Management();
        createAssets(management);
		// management.start();
	}

	/**
	 * a. get JAXB Object.
	 * b. get list of AssetContents.
	 * c. for each AssetContent. get list of materials and tools.
	 * d. for each list, create RepairtToolInformation & RepairMaterialInformation containing this list.
	 * e. add them to management.
	 * 
	 */

	private static void createAssets(Management management){
		Assets allAssets= (Assets)returnObject ("Assets.xml","driver.Assets");
		List<Assets.Asset> list = allAssets.getAsset();
		for (Assets.Asset asset : list) {
			String name = asset.getName();
			String type = asset.getType();
			Location location= new Location(asset.getLocation().getX(), asset.getLocation().getY());
			String status= "AVAILABLE";
			int cost = asset.getCostPerNight();  
			int size = asset.getSize();
			Asset newAsset = new Asset (name, type, location, status, cost, size);
			
			List<Assets.Asset.AssetContents.AssetContent> contents = asset.getAssetContents().getAssetContent();
			
			for (Assets.Asset.AssetContents.AssetContent content: contents){
			AssetContent newContent = new AssetContent (content.getName(), content.getRepairMultiplier());
            newAsset.addAssetContent(newContent);
			}
			management.addAsset(newAsset);
		}		
	}
	
	private static void getName() {
		// TODO Auto-generated method stub
		
	}

	// Create an object of the required class;

	public static Object returnObject(String fileName, String className) {

		try {
			File file = new File(fileName);
			JAXBContext jaxbContext = JAXBContext.newInstance(Class.forName(className));
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Object myObj = jaxbUnmarshaller.unmarshal(file);
			return myObj;


		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}
	
}