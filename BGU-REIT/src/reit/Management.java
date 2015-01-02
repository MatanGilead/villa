package reit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Management {

	private Assets fAssets;
	private Warehouse fWarehouse;
	private ArrayList<ClerkDetails> fClerkDetails;
	private ArrayList<CustomerGroupDetails> fCustomerGroupDetails;
	private HashMap<String, ArrayList<RepairMaterialInformation>> fRepairMaterialsInfo;
	private HashMap<String, ArrayList<RepairToolInformation>> fRepairToolsInfo;
	private Statistics fStatistics;
	private BlockingQueue<RentalRequest> fRentalRequests;
	private Semaphore fMaintancePersons; // used for maitance threads
	private Semaphore fMaintenceThreadsCount; // used for maitance threads
	private CountDownLatch fTotalNumberOfRentalRequest;
	private Logger logger;
	private AtomicBoolean killClerks;

	// RunnableMaintenanceRequest blocking queue---semaphore--
	// we will use countDownLatch, set to num of rentalRequests to printout
	// statistics.. we will do -1 whan the rental will complete
	// every Runnable clerk will know if he needs to continue his life cycle by
	// his rental requests number------------
	// -when will he check it? we will need to check at start what is the number
	// of clercks, befaore taking somethinf from the line..
	// if the number of clerks is greater than the number of rental requests
	// that we need to take care of, than the thread will exit and will do -- on
	// clercks num
	// if we are entering to the function and this is not the case, continue
	// regular. this will be a boolean method; in this way clerks will stop
	// alone;
	// we will use CyclicBarrier to wake up all the threads on all parts except
	// from the last part - in that case we will not wait, we will skip on the
	// cyclic-barrier and we will end our code safely!
	// we will need a smart method for that.

	// how much threads of clercks to run?

	// RunnableCustomer will stop running id he completed his RentalRequests
	// runnable maintance will continue running while he didnt fixed

	public Management() {
		fAssets = new Assets();
		fWarehouse = new Warehouse();
		fClerkDetails = new ArrayList<ClerkDetails>();
		fCustomerGroupDetails = new ArrayList<CustomerGroupDetails>();
		fRepairMaterialsInfo = new HashMap<String, ArrayList<RepairMaterialInformation>>();
		fRepairToolsInfo = new HashMap<String, ArrayList<RepairToolInformation>>();
		fStatistics = new Statistics();
		fRentalRequests = new LinkedBlockingQueue<RentalRequest>();
		fMaintenceThreadsCount = new Semaphore(0, true);
		logger = MyLogger.getLogger("Management");
		killClerks = new AtomicBoolean(false);
	}

	public void addMaintancePersons(int numOfMaintancePersons) {
		fMaintancePersons = new Semaphore(numOfMaintancePersons, true);
	}

	public void setTotalNumberOfRentalRequest(int num) {
		fTotalNumberOfRentalRequest = new CountDownLatch(num);
	}

	public void addAsset(Asset asset) {
		// add asset to the assets collection
		fAssets.addAsset(asset);
	}

	public void addCustomerGroup(CustomerGroupDetails customerGroup) {
		// add CustomerGroup to the CustomerGroup collection
		fCustomerGroupDetails.add(customerGroup);
	}

	// change it so we won't send the whole collection!!!!
	public void addItemRepairTool(String assetContentName, String toolName,
			int toolQuantity) {
		if (fRepairToolsInfo.get(assetContentName) == null)
			fRepairToolsInfo.put(assetContentName,
					new ArrayList<RepairToolInformation>());

		fRepairToolsInfo.get(assetContentName).add(
				new RepairToolInformation(toolName, toolQuantity));
	}

	// change it so we won't send the whole collection!!
	public void addItemRepairMaterial(String assetContentName,
			String materialName, int materialQuantity) {
		if (fRepairMaterialsInfo.get(assetContentName) == null)
			fRepairMaterialsInfo.put(assetContentName,
					new ArrayList<RepairMaterialInformation>());

		fRepairMaterialsInfo.get(assetContentName).add(
				new RepairMaterialInformation(materialName, materialQuantity));
	}

	public void addClerk(String name, int xNum, int yNum) {
		fClerkDetails.add(new ClerkDetails(name, new Location(xNum, yNum)));
	}

	public void addRepairTool(String name, int quantity) {
		fWarehouse.addTool(new RepairTool(name, quantity));
	}

	public void addRepairMaterial(String name, int quantity) {
		fWarehouse.addMaterial(new RepairMaterial(name, quantity));
	}

	public void start() {
		logger.info("BGU-REIT is in progress!");
		logger.info("Clerks shift has started!");
		createRunnableCustomersGroup();
		createRunnableClerk();
		try {
			fTotalNumberOfRentalRequest.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (fMaintenceThreadsCount) {
			fMaintenceThreadsCount.notifyAll();
		}

		// synchronized (fMaintenceThreadsCount) {
		// fMaintenceThreadsCount.notifyAll();
		// }

		fStatistics.print();

	}

	void startRepair() {
		ArrayList<Asset> brokenList = fAssets.getBroken();
		fMaintenceThreadsCount.release(brokenList.size());
		if (brokenList.size() == 0)
			logger.info("there are no damanged assets!");
		if (brokenList.size() != 0)
			logger.info("there are " + brokenList.size()
					+ " assets need to be repaired");
		synchronized (fMaintenceThreadsCount) {

			for (Asset asset : brokenList) {
				new Thread(new RunnableMaintenanceRequest(fRepairMaterialsInfo,
						fRepairToolsInfo, asset, fWarehouse, fMaintancePersons,
						fMaintenceThreadsCount, fTotalNumberOfRentalRequest,
						fStatistics))
						.start();
			}
			try {
				if (brokenList.size() != 0)
					fMaintenceThreadsCount.wait();

					logger.info("Clerks shift has started!");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (fTotalNumberOfRentalRequest.getCount() == 0) {
				killClerks.set(true);
				logger.info("It's time to get rid of the celrks once and for all!");
			}
		}

	}

	private void createRunnableClerk() {
		Object lock = new Object();
		AtomicInteger totalNewNumber = new AtomicInteger(
				(int) fTotalNumberOfRentalRequest.getCount());
		CyclicBarrier newShift = new CyclicBarrier(fClerkDetails.size(),
				new Runnable() {
					@Override
					public void run() {
						logger.logp(Level.INFO, "Management",
								"createRunnableClerk",
								"Clerk's its time to rest! end shift!");
						startRepair();
					};
				});

		for (ClerkDetails clerk : fClerkDetails)
			(new Thread(new RunnableClerk(clerk, fRentalRequests, fAssets,
					totalNewNumber, lock, newShift, killClerks))).start();

	}

	private void createRunnableCustomersGroup() {
		for (CustomerGroupDetails groupManager : fCustomerGroupDetails)
			new Thread(new RunnableCustomerGroupManager(groupManager,
					fRentalRequests, this))
					.start();
	}

	public void addRentalRequest(RentalRequest rentalRequest) {
		fRentalRequests.add(rentalRequest);
	}

	void FixAsset(DamageReport report, RentalRequest rentalRequest) {
		boolean stillGood = report.runReportImplications();
		fStatistics.addDamageReport(report, rentalRequest);

		if (stillGood) {
			for (ClerkDetails clerk : fClerkDetails) {
				synchronized (clerk) {
					clerk.notifyAll();
				}
			}
			fTotalNumberOfRentalRequest.countDown();
		} else {
			System.out
					.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			synchronized (rentalRequest.getAsset()) {
				rentalRequest.getAsset().notifyAll();
			}
		}

		logger.info("Number of remaining requests: "
				+ fTotalNumberOfRentalRequest.getCount());

		
	}

}
