package reit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;



public class Management {

	private Assets fAssets;
	private Warehouse fWarehouse;
	private ArrayList<ClerkDetails> fClerkDetails;
	private ArrayList<CustomerGroupDetails> fCustomerGroupDetails;
	private HashMap<String, ArrayList<RepairMaterialInformation>> fRepairMaterialsInfo;
	private HashMap<String, ArrayList<RepairToolInformation>> fRepairToolsInfo;
	private Statistics fStatistics;
	private BlockingQueue<RentalRequest> fRentalRequests;
	private int fNumMaintancePersons;
	private Semaphore fMaintancePersons; // used for maitance threads
	private Semaphore fMaintenceThreadsCount; // used for maitance threads
	private int fTotalNumberOfRentalRequest;
	private AtomicInteger fRequestsFinishedByClerk;
	private CountDownLatch fCountDownLatch;
	private final Object fLock;
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
		//empty constructor
		fAssets=new Assets();
		fWarehouse=new Warehouse();
		fClerkDetails=new ArrayList<ClerkDetails>();
		fCustomerGroupDetails=new ArrayList<CustomerGroupDetails>();
		fRepairMaterialsInfo = new HashMap<String, ArrayList<RepairMaterialInformation>>();
		fRepairToolsInfo = new HashMap<String, ArrayList<RepairToolInformation>>();
		fStatistics=new Statistics();
		fRentalRequests = new LinkedBlockingQueue<RentalRequest>();
		fLock=new Object();
		fRequestsFinishedByClerk=null;
		fMaintancePersons = new Semaphore(0, true);
		fMaintenceThreadsCount = new Semaphore(0, true);

	}
	public void addMaintancePersons(int numOfMaintancePersons) {
		fNumMaintancePersons = numOfMaintancePersons;
	}

	public void setCountDownLatch(int num) {
		fCountDownLatch = new CountDownLatch(num);
		fTotalNumberOfRentalRequest = num;
	}

	public void FixAsset(DamageReport report, RentalRequest rentalRequest)
	{
		fStatistics.addDamageReport(report, rentalRequest);
		synchronized (fLock) {
			if (report.getAsset().getHealth() > 65) {
			fMaintenceThreadsCount.release(-1);
			if (fMaintenceThreadsCount.availablePermits() == 0)
				fMaintenceThreadsCount.notifyAll();
			}
		}

		// if not need repair - decrease number of needed repairman
		///create runnablemaintence 

		//release thread

	}
	
	
	public void addAsset(Asset asset){
		//add asset to the assets collection
		fAssets.addAsset(asset);
	}

	

	public void addCustomerGroup(CustomerGroupDetails customerGroup) {
		//add CustomerGroup to the CustomerGroup collection
		fCustomerGroupDetails.add(customerGroup);
	}

	//change it so we won't send the whole collection!!!!
	public void addItemRepairTool(String name, ArrayList<RepairToolInformation> tool) {
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
	


    //change it so we won't send the whole collection!!
	public void addItemRepairMaterial(String name, ArrayList<RepairMaterialInformation> material) {
		fRepairMaterialsInfo.put(name, material);
	}
	
	/*
	 * ArrayList<RepairMaterialInformation> materialList = repairMaterialsInfo
	 * .get(name); if (!(materialList == null)) materialList.add(material); else
	 * { materialList = new ArrayList<RepairMaterialInformation>();
	 * materialList.add(material);
	 */	
		
	public void addClerk(ClerkDetails clerk) {
		fClerkDetails.add(clerk);
	}

	public void addRepairTool(RepairTool tool) {
		fWarehouse.addTool(tool);
	}

	public void addRepairMaterial(RepairMaterial material) {
		fWarehouse.addMaterial(material);
	}

	public void start() {
		new Thread(fStatistics).start();
		createRunnableCustomersGroup();
		createRunnableClerk();

	}

	public void flagForRepair() {
		synchronized (fLock) {
			try {
				fMaintenceThreadsCount.release(fRequestsFinishedByClerk.get());
				if (fMaintenceThreadsCount.availablePermits() != 0)
					fMaintenceThreadsCount.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	private void createRunnableClerk() {
		Object lock = new Object();
		AtomicInteger totalNewNumber=new AtomicInteger(fTotalNumberOfRentalRequest);
		CyclicBarrier newShift = new CyclicBarrier(fClerkDetails.size(),
				new Runnable() {
					@Override
					public void run() {
						flagForRepair();
					};
				});
		for(ClerkDetails clerk: fClerkDetails)
			(new Thread(new RunnableClerk(clerk, fRentalRequests, fAssets,
					totalNewNumber, lock, fRequestsFinishedByClerk,
					newShift))).start();
		
	}
	private void createRunnableCustomersGroup() {
		// TODO Auto-generated method stub
	}



	

}

