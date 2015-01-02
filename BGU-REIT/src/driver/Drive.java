package driver;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import reit.Asset;
import reit.Management;

public class Drive {
	public static void main(String[] args) {
		Management management = new Management();
	    createAssets(management);
		createAssetContentsRepairDetails(management);
		createCustomersGroup(management);
		createReit(management);
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

	private static void createCustomersGroup(Management management) {
		//initialize fCustomerGroupDetails field in management
		CustomersGroups allCustomers = (CustomersGroups) returnObject(
				"CustomersGroups.xml", "driver.CustomersGroups"); //JAXB object of type CustomerGroups
		List<CustomersGroups.CustomerGroups.CustomerGroupDetails> custumersDetailsList = allCustomers
				.getCustomerGroups().getCustomerGroupDetails(); //list of all CustomerGroupDatails
		for(CustomersGroups.CustomerGroups.CustomerGroupDetails groupManager: custumersDetailsList){//go over all managers
			reit.CustomerGroupDetails group = new reit.CustomerGroupDetails(
					groupManager.getGroupManagerName());
			List<CustomersGroups.CustomerGroups.CustomerGroupDetails.Customers.Customer> customerList = groupManager.getCustomers().getCustomer();
			for (CustomersGroups.CustomerGroups.CustomerGroupDetails.Customers.Customer customer : customerList) {//go over all customers
				group.addCustomer(customer.getName(), customer.getVandalism(),
						customer.getMinimumDamage(),
						customer.getMaximumDamage()); // add customer to group
				}
			CustomersGroups.CustomerGroups.CustomerGroupDetails.RentalRequests rentalRequests=groupManager.getRentalRequests();
			List<CustomersGroups.CustomerGroups.CustomerGroupDetails.RentalRequests.Request> RentalRequestsList= rentalRequests.getRequest();
			for(CustomersGroups.CustomerGroups.CustomerGroupDetails.RentalRequests.Request request:RentalRequestsList){//go over all rentalRequests
				group.addRentalRequest(request.getId(), request.getType(),
						request.getSize(), request.getDuration());
			}
			management.addCustomerGroup(group);//update management
			
		}

	}
	private static void createAssets(Management management){
		//initialize assets field in management class
		Assets allAssets= (Assets)returnObject ("Assets.xml","driver.Assets"); // JAXB object of type Assets
		List<Assets.Asset> list = allAssets.getAsset(); //get all Assets
		for (Assets.Asset asset : list) { //go over every Asset
			String name = asset.getName(); //Asset name
			String type = asset.getType();  //Asset type
			String status= "AVAILABLE"; // Asset status
			int cost = asset.getCostPerNight();  //Asset costPerNight
			int size = asset.getSize(); //Asset size
			Asset newAsset = new Asset(name, type, asset.getLocation().getX(),
					asset.getLocation().getY(), status, cost, size); // create a
																		// new
																		// object
																		// with
																		// all
																		// values
			
			List<Assets.Asset.AssetContents.AssetContent> contents = asset.getAssetContents().getAssetContent(); //all AssetContents
			
			for (Assets.Asset.AssetContents.AssetContent content: contents){ //go over all AssetContents

				newAsset.addAssetContent(content.getName(),
						content.getRepairMultiplier()); // add the AssetConetent
														// to the assetContents
														// collection
			}
			management.addAsset(newAsset);//update management 
		}		
	}
	private static void createReit(Management management) {
		//initialize warehouse, clerks, maintenance person and CountDownLatch 
		REIT reit = (REIT) returnObject("InitialData.xml", "driver.REIT"); //JAXB object of type REIT
		REIT.Warehouse warehouse = reit.getWarehouse(); //get management
		REIT.Staff staff = reit.getStaff();  //get all staff
		REIT.Staff.Clerks clerks = staff.getClerks(); //get Clerks 
		REIT.Warehouse.Tools tools=warehouse.getTools(); //get warehouse tools
		REIT.Warehouse.Materials materials = warehouse.getMaterials(); //get warehouse materials
		
		for (REIT.Warehouse.Materials.Material material : materials
				.getMaterial()) {//go over all materials
			management.addRepairMaterial(material.getName(),
					material.getQuantity()); // update management
		}	
		for (REIT.Warehouse.Tools.Tool tool : tools.getTool()) {//go over all tools
			management.addRepairTool(tool.getName(), tool.getQuantity()); // update
																			// management
		}
		for (REIT.Staff.Clerks.Clerk clerk : clerks.getClerk()) {// go over all clerks
			management.addClerk(clerk.getName(), clerk.getLocation().getX(),
					clerk.getLocation().getY());
		}
		management.addMaintancePersons(staff.getNumberOfMaintenancePersons()); //update management
		management.setTotalNumberOfRentalRequest(staff
				.getTotalNumberOfRentalRequests()); // update management
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
		//initialization of the fRepairToolsInfo and fRepairMaterialsInfo fields in management
		AssetContentsRepairDetails allAssetContents = (AssetContentsRepairDetails) returnObject(
				"AssetContentsRepairDetails.xml",
				"driver.AssetContentsRepairDetails"); //JAXB object of type AssetContentsRepairDetails
		List<AssetContentsRepairDetails.AssetContent> list = allAssetContents.getAssetContent(); // list of all assetContents
		for (AssetContentsRepairDetails.AssetContent assetContent : list) { // go over every assetContent
			//RepairToolInformation tools=new RepairToolInformation(assetContent.getName()); 
			List<AssetContentsRepairDetails.AssetContent.Tools.Tool> toolList=assetContent.getTools().getTool();
			for(AssetContentsRepairDetails.AssetContent.Tools.Tool tool: toolList){// go over all tools
				management.addItemRepairTool(assetContent.getName(),
						tool.getName(), tool.getQuantity());
				}
			

			List<AssetContentsRepairDetails.AssetContent.Materials.Material> materialList=assetContent.getMaterials().getMaterial();
			for(AssetContentsRepairDetails.AssetContent.Materials.Material material: materialList){ // go over all materials
				management.addItemRepairMaterial(assetContent.getName(),
						material.getName(), material.getQuantity());
				}

		}
	}
	
	
	// Create an object of the required class for initialization from the xml files
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