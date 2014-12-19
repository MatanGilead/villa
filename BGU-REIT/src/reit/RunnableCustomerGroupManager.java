package reit;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableCustomerGroupManager implements Runnable {

	private CustomerGroupDetails fCustomerGroupDetails;
	private BlockingQueue<RentalRequest> fRentalRequests;
	private ArrayList<DamageReport> fDamageReports;
	private Assets fAssets;
	
	
	public RunnableCustomerGroupManager(CustomerGroupDetails customerGroupD, BlockingQueue<RentalRequest> rentalRequests, Assets assets){
	fCustomerGroupDetails=customerGroupD;
	fRentalRequests=rentalRequests;
	fAssets=assets;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		RentalRequest newRentalRequest=fCustomerGroupDetails.sendRentalRequest();
		fRentalRequests.add(newRentalRequest);
		
		while (newRentalRequest.getRentalRequestStatus()!= "Fulfilled"){ 
			try {
				newRentalRequest.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //should be notified by clerk (notifyAll on retnalRequest)
		}
		

		String assetName = newRentalRequest.getAssetName(); //asset name
		int indexOfAsset=fAssets.findAssetByName(assetName); //find asset index in assets
		Asset usedAsset=fAssets.findAssetByIndex(indexOfAsset); //find asset in assets
		usedAsset.setOccupied(); //update asset status
		newRentalRequest.setRequestStatus("InProgress"); //update request status
		
		

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
			} //wait till every customers finish his stay in asset
		}
		
		executorS.shutdown(); 
		usedAsset.reduceHealth(TotalAssetDamage);
		if (usedAsset.getHealth()<65)
			usedAsset.setBroken();
		else
			usedAsset.setFixed();
   
		
		newRentalRequest.setRequestStatus("Complete");
		//change request status to finished, can go to the next request (while loop from here or main)

		DamageReport newDamageReport= new DamageReport(usedAsset,TotalAssetDamage); //create new damage report
		fDamageReports.add(newDamageReport);		
	
	}

}

