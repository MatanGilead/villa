package reit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

import test.Warehouse;

public class Management {

	private Assets assets;
	private Warehouse warehouse;
	private Vector<ClerkDetails> clerkDetails;
	private Vector<CustomerGroupDetails> customerGroupDetails;
	private HashMap<String, ArrayList<RepairMaterialInformation>> repairMaterialsInfo;
	private HashMap<String, ArrayList<RepairToolInformation>> repairToolsInfo;
	private Statistics statistics;
	private BlockingQueue<RentalRequest> rentalRequests;
	private Semaphore fMaintancePersons; //used for maitance threads
	// RunnableMaintenanceRequest blocking queue---semaphore--
	//we will use countDownLatch, set to num of rentalRequests to printout statistics.. we will do -1 whan the rental will complete
	//every Runnable clerk will know  if he needs to continue his life cycle by his rental requests number------------
	//-when will he check it? we will need to check at start what is the number of clercks, befaore taking somethinf from the line..
	//if the number of clerks is greater than the number of rental requests that we need to take care of, than the thread will exit and will do -- on clercks num
	//if we are entering to the function and this is not the case, continue regular. this will be a boolean method; in this way clerks will stop alone;
	//we will use CyclicBarrier to wake up all the threads on all parts except from the last part - in that case we will not wait, we will skip on the cyclic-barrier and we will end our code safely!
	//we will need a smart method for that. 
	
	//how much threads of clercks to run?
	
	
	//RunnableCustomer will stop running id he completed his RentalRequests
	//runnable maintance will continue running while he didnt fixed


	public Management() {
		assets=new Assets();
		warehouse=new Warehouse();
		clerkDetails=new Vector<ClerkDetails>();
		customerGroupDetails=new Vector<CustomerGroupDetails>();
		repairMaterialsInfo = new HashMap<String, ArrayList<RepairMaterialInformation>>();
		repairToolsInfo=new HashMap<String, ArrayList<RepairToolInformation>>();
		statistics=new Statistics();
		rentalRequests = new LinkedBlockingQueue<RentalRequest>();

	}
	public void addMaintancePersons(int numOfMaintancePersons) {
		fMaintancePersons=new Semaphore(numOfMaintancePersons,true);
	}
	public void FixAsset(DamageReport report) 
	{
		
		///send to fix after that line
		try {
			fMaintancePersons.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//release thread
		fMaintancePersons.release();

	}

	public void addCustomerGroup(CustomerGroupDetails customerGroup) {
		customerGroupDetails.add(customerGroup);
	}

	public void addItemRepairTool(String name, ArrayList<RepairToolInformation> toolList) {

		repairToolsInfo.put(name, toolList);
	}
	/*	ArrayList<RepairToolInformation> toolList = repairToolsInfo.get(name);
		if (!(toolList == null))
			toolList.add(tool);
		else {
			toolList = new ArrayList<RepairToolInformation>();
			toolList.add(tool);
			repairToolsInfo.put(name, toolList);
		}
*/
	



	public void addItemRepairMaterial(String name, ArrayList<RepairMaterialInformation> materialList) {
		repairMaterialsInfo.put(name, materialList);
	}
	
	/*
	 * ArrayList<RepairMaterialInformation> materialList = repairMaterialsInfo
	 * .get(name); if (!(materialList == null)) materialList.add(material); else
	 * { materialList = new ArrayList<RepairMaterialInformation>();
	 * materialList.add(material);
	 */	
		

	public void start() {
		for(CustomerGroupDetails group: customerGroupDetails){
			new RunableMaintanceRequest()
	}
	}

}

