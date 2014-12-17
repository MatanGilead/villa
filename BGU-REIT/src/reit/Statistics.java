package reit;

import java.util.HashMap;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class Statistics implements Runnable {
	private double fMoneyGained;
	private Vector<RentalRequest> fRentals;
	private HashMap<String, Integer> fRepairMaterials;
	private HashMap<String, Integer> fRepairTools;
	private CountDownLatch fCountDownLatch;

	public void run() {
		try {
			fCountDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		print();
		
		//now wait
		
	}

	private void print() {
		/*
		 * StringBuilder string=new StringBuilder();
		 * StringBuilder.append(fRentals.toString()); fRepairTools.toString();
		 * fRepairMaterials.toString();
		 */}

	public void addMaterials(HashMap<String, Integer> allRequiredMaterials) {

	}

	public void addTools(HashMap<String, Integer> allRequiredTools) {
		// TODO Auto-generated method stub

	}

	public void addDamageReport(DamageReport report, RentalRequest rentalRequest) {
		report.getAsset(). 
		
	}
}
