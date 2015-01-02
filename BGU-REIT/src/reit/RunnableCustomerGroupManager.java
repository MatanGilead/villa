package reit;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

class RunnableCustomerGroupManager implements Runnable {

	private CustomerGroupDetails fCustomerGroupDetails;
	private BlockingQueue<RentalRequest> fRentalRequests;
	private Logger logger;
	private Management fManagement;

	RunnableCustomerGroupManager(CustomerGroupDetails customerGroupD,
			BlockingQueue<RentalRequest> rentalRequests, Management management) {
	fCustomerGroupDetails=customerGroupD;
	fRentalRequests=rentalRequests;
		fManagement = management;
		logger = MyLogger.getLogger("RunnableCustomerGroupManager");

	}
	
	@Override
	public void run() {
		
		while (!fCustomerGroupDetails.isEmptyRentalRequest()) {
		RentalRequest newRentalRequest = fCustomerGroupDetails.sendRentalRequest();
			synchronized (newRentalRequest) {
		fRentalRequests.add(newRentalRequest);
			logger.info(fCustomerGroupDetails.getGroupManagerName()
					+ " added a request id " + newRentalRequest.getId());
		waitForClerk(newRentalRequest);
			}
		logger.info(fCustomerGroupDetails.getGroupManagerName() + "recieves an asset");
		Asset usedAsset = newRentalRequest.getAsset();
			synchronized (usedAsset) {
				usedAsset.setOccupied(); // update asset status
			}
		newRentalRequest.setRequestStatus("INPROGRESS"); //update request status
		logger.info(fCustomerGroupDetails.getGroupManagerName() + "start staying process");
		double totalAssetDamage = SimulateStayInAsset(newRentalRequest);
		DamageReport newDamageReport = new DamageReport(usedAsset,
		totalAssetDamage); // create new damage report
			// fDamageReports.add(newDamageReport);
			fManagement.FixAsset(newDamageReport, newRentalRequest);
			logger.info(fCustomerGroupDetails.getGroupManagerName()
					+ "group has left the asset" + "   " + usedAsset.getName()
					+ " damage:" + totalAssetDamage);
		newRentalRequest.setRequestStatus("COMPLETE");

		}
	}

	private double SimulateStayInAsset(RentalRequest newRentalRequest) {
		int numOfCustomers = fCustomerGroupDetails.getNumberOfCustomersInGroup();
		int stayDuration = newRentalRequest.getDurationOfStay();
		ExecutorService executorS = Executors.newFixedThreadPool(numOfCustomers);
		CompletionService<CallableSimulateStayInAsset> compServiceExecutor= new ExecutorCompletionService <CallableSimulateStayInAsset>(executorS);
		
		for (int i=0;i<numOfCustomers;i++){ //simulate stay in asset for every customer in group
			Customer customer = fCustomerGroupDetails.getCustomer(i);
			Callable<CallableSimulateStayInAsset> callableStay= new CallableSimulateStayInAsset(customer,stayDuration,0);
			compServiceExecutor.submit(callableStay);
		}
		
		double TotalAssetDamage=0;
		for (int i=0;i<numOfCustomers;i++){
			try {
				CallableSimulateStayInAsset assetAfterCustomerStay;
				assetAfterCustomerStay = compServiceExecutor.take().get();
				TotalAssetDamage+=assetAfterCustomerStay.getDamage(); //calculate total damage
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //wait till every customer finish his stay in asset
		}
		
		executorS.shutdown(); 
		return TotalAssetDamage;
	}

	private void waitForClerk(RentalRequest newRentalRequest) {
		synchronized (newRentalRequest) {
			logger.info(fCustomerGroupDetails.getGroupManagerName() + "wait for the clerk");
			while (!newRentalRequest.getRentalRequestStatus().equals("FULLFILLED")) {

				try {
					newRentalRequest.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // should be notified by clerk (notifyAll on retnalRequest)
			}
		}

	}



}

