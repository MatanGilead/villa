package reit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import test.Warehouse;

public class Management {

	private Assets fAssets;
	private Warehouse fWarehouse;
	private ArrayList<ClerkDetails> fClerkDetails;
	private ArrayList<CustomerGroupDetails> fCustomerGroupDetails;
	private HashMap<String, RepairMaterialInformation> fRepairMaterialsInfo;
	private HashMap<String, RepairToolInformation> fRepairToolsInfo;
	private Statistics fStatistics;
	private BlockingQueue<RentalRequest> fRentalRequests;
	private Semaphore fMaintancePersons; //used for maitance threads
	private int fTotalNumberOfRentalRequest;
	private CountDownLatch fCountDownLatch;
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
		fAssets=new Assets();
		fWarehouse=new Warehouse();
		fClerkDetails=new ArrayList<ClerkDetails>();
		fCustomerGroupDetails=new ArrayList<CustomerGroupDetails>();
		fRepairMaterialsInfo = new HashMap<String, RepairMaterialInformation>();
		fRepairToolsInfo = new HashMap<String, RepairToolInformation>();
		fStatistics=new Statistics();
		fRentalRequests = new LinkedBlockingQueue<RentalRequest>();
		

	}
	
	
	public void addMaintancePersons(int numOfMaintancePersons) {
		fMaintancePersons=new Semaphore(numOfMaintancePersons,true);
	}
	public void FixAsset(DamageReport report) 
	{
		
		///create runnablemaintence 

		//release thread

	}
	
	
	public void addAsset(Asset asset){
		fAssets.addAsset(asset);
	}

	

	public void addCustomerGroup(CustomerGroupDetails customerGroup) {
		fCustomerGroupDetails.add(customerGroup);
	}

	public void addItemRepairTool(String name, RepairToolInformation tool) {

		fRepairToolsInfo.put(name, tool);
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
	



	public void addItemRepairMaterial(String name,
			RepairMaterialInformation material) {
		fRepairMaterialsInfo.put(name, material);
	}
	
	/*
	 * ArrayList<RepairMaterialInformation> materialList = repairMaterialsInfo
	 * .get(name); if (!(materialList == null)) materialList.add(material); else
	 * { materialList = new ArrayList<RepairMaterialInformation>();
	 * materialList.add(material);
	 */	
		

	public void start() {
		createRunnableCustomersGroup();
		createRunnableClerk();
		fStatistics.print();
	}
	private void createRunnableClerk() {
		Object lock=new Object();
		AtomicInteger NumOfClerks=new AtomicInteger(fClerkDetails.size());
		AtomicInteger TotalNumberOfRentalRequest=new AtomicInteger(fTotalNumberOfRentalRequest);
		CyclicBarrier newShift=new CyclicBarrier(fClerkDetails.size());
		for(ClerkDetails clerk: fClerkDetails)
			(new Thread(new RunnableClerk(clerk,fRentalRequests,fAssets,TotalNumberOfRentalRequest,lock,NumOfClerks,newShift))).start(); 
		
		
	}
	private void createRunnableCustomersGroup() {
		// TODO Auto-generated method stub
	}
	public void releaseRepairMap() {
		fCountDownLatch.countDown();
		fMaintancePersons.release();
		
	}
	public void takeRepairMan() {
		try {
			fMaintancePersons.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	

}

