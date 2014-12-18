package reit;

import java.util.HashMap;
import java.util.Vector;

public class Statistics {
	private double fMoneyGained;
	private Vector<RentalRequest> fRentals;
	private HashMap<String, Integer> fRepairMaterials;
	private HashMap<String, Integer> fRepairTools;

	public Statistics() {
		fMoneyGained = 0;
		fRentals = new Vector<RentalRequest>();
		fRepairMaterials = new HashMap<String, Integer>();
		fRepairTools = new HashMap<String, Integer>();
	}

	protected void print() {
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
		// report.getAsset().
		
	}
}
