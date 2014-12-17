package reit;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class RunnableCustomerGroupManager implements Runnable {

	private CustomerGroupDetails fCustomerGroupDetails;
	private Management management;
	private Asset fAsset;
	
	//CallableSimulateStayInAsset

	@Override
	public void run() {
		// TODO Auto-generated method stub
		RentalRequest newRequest=fCustomerGroupDetails.sendRentalRequest();
		management.addRentalRequest(newRequest);
		while (newRequest.getRentalRequestStatus()!= "Fulfilled") sleep();
		
		ArrayList<Customer> customers = fCustomerGroupDetails.getCustomers();
		CallableSimulateStayInAsset CallableStay= new CallableSimulateStayInAsset();
		FutureTask<Double> future = new FutureTask<Double>(CallableStay);
	
		ExecutorService executorS =  Executors.newFixedThreadPool(customers.size());
		executorS.execute(future);

		
		//(CallableStay);
		boolean listen = true;
		while (listen) {
			if (future.isDone()) {
				Double result;
				try {
					result = future.get();
					listen = false;
					System.out.println(result);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		if (future.isDone()){
			double assetDamage=future.get();

		}
		
	}
		for (int i=0; i<customers.size();i++) 
		
			CallableSumulateStayInAsset();
		
		//sumulate sty in asset
		//create damage report
		
	}
	
	public void sleep(){
		
	}
	

}
