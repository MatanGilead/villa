package reit;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class Statistics {
	private double fMoneyGained;
	private Vector<RentalRequest> fRentals;
	private Vector<RepairMaterialInformation> fRepairMaterials;
	private Vector<RepairToolInformation> fRepairTools;
	private CountDownLatch fCountDownLatch;
	public void print() {
		try {
			fCountDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//now wait
		
	}
}
