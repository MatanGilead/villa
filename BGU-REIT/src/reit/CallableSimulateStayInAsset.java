package reit;

import java.util.concurrent.Callable;

class CallableSimulateStayInAsset implements
		Callable<CallableSimulateStayInAsset> {

	private Customer fCustomer;
	private int fStayDuration;
	private double fDamageToAsset;
	//private Asset asset;
	
	CallableSimulateStayInAsset(Customer customer, int duration,
			double damage) {
		fCustomer=customer;
		fStayDuration= duration;
		fDamageToAsset=damage;
	}
	
	double getDamage() {
		return fDamageToAsset;
	}
	
	@Override
	public CallableSimulateStayInAsset call() throws Exception {
		// TODO Auto-generated method stub
		try{
			double durationInSec=fStayDuration*24; // a day in the simulation is 24 sec
			Thread.sleep((long) (durationInSec * 1000)); // converted to 1000
														// milliseconds
		}catch(InterruptedException e){}
		//wait();
		fDamageToAsset=fCustomer.CalculateDamage();
		return this;
	}

}
