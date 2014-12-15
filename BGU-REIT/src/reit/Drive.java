package reit;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import driver.AssetContentsRepairDetails;
import driver.Assets;
import driver.CustomersGroups;
import driver.REIT;

public class Drive {
	public static void main(String[] args) {
		Management management = new Management();
	    createAssets(management);
		createAssetContentsRepairDetails(management);
		createCustomersGroup(management);
		createReit(management);
		
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

	private static void createCustomersGroup(Management management) {
		CustomersGroups allCustomers = (CustomersGroups) returnObject(
				"CustomersGroups.xml", "driver.CustomersGroups");
		List<CustomersGroups.CustomerGroups.CustomerGroupDetails> custumersDetailsList = allCustomers
				.getCustomerGroups().getCustomerGroupDetails();
		for(CustomersGroups.CustomerGroups.CustomerGroupDetails groupManager: custumersDetailsList){
			CustomerGroupDetails group= new CustomerGroupDetails(groupManager.getGroupManagerName());
			List<CustomersGroups.CustomerGroups.CustomerGroupDetails.Customers.Customer> customerList = groupManager.getCustomers().getCustomer();
			for (CustomersGroups.CustomerGroups.CustomerGroupDetails.Customers.Customer customer : customerList) {
				group.addCustomer(new Customer(customer.getName(),customer.getVandalism(),customer.getMinimumDamage(),customer.getMaximumDamage()));
				}
			CustomersGroups.CustomerGroups.CustomerGroupDetails.RentalRequests rentalRequests=groupManager.getRentalRequests();
			List<CustomersGroups.CustomerGroups.CustomerGroupDetails.RentalRequests.Request> RentalRequestsList= rentalRequests.getRequest();
			for(CustomersGroups.CustomerGroups.CustomerGroupDetails.RentalRequests.Request request:RentalRequestsList){
				group.addRentalRequest(new RentalRequest(request.getId(),request.getType(),request.getSize(),request.getDuration()));
			}
			management.addCustomerGroup(group);
			
		}

	}
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
	private static void createReit(Management management) {
		REIT reit = (REIT) returnObject("InitialData.xml", "driver.REIT");
		REIT.Warehouse warehouse = reit.getWarehouse();
		REIT.Staff staff = reit.getStaff();
		REIT.Staff.Clerks clerks = staff.getClerks();
		REIT.Warehouse.Tools tools=warehouse.getTools();
		REIT.Warehouse.Materials materials = warehouse.getMaterials();
		for (REIT.Warehouse.Materials.Material material : materials
				.getMaterial()) {
			management.addRepairMaterial(new RepairMaterial(material.getName(),
					material.getQuantity()));
		}
		for (REIT.Warehouse.Tools.Tool tool : tools.getTool()) {
			management.addRepairTool(new RepairTool(tool.getName(), tool.getQuantity()));
		}
		
		
		for (REIT.Staff.Clerks.Clerk clerk : clerks.getClerk()) {
			management.addClerk(new ClerkDetails(clerk.getName(),new Location(clerk.getLocation().getX(),clerk.getLocation().getY())));
		}
		management.addMaintancePersons(staff.getNumberOfMaintenancePersons());
		management.setCountDownLatch(staff.getTotalNumberOfRentalRequests());

		// warehouse.getMaterials()
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
		AssetContentsRepairDetails allAssetContents = (AssetContentsRepairDetails) returnObject(
				"AssetContentsRepairDetails.xml",
				"driver.AssetContentsRepairDetails");
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
				materials.addRepairMaterial(material.getName(), material.getQuantity());
				}

			management.addItemRepairTool(assetContent.getName(), tools);
			management.addItemRepairMaterial(assetContent.getName(), materials);
		}
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