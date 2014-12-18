package reit;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
	private AtomicInteger fMoneyGained;
	private Vector<RentalRequest> fRentals;
	private HashMap<String, AtomicInteger> fRepairMaterials;
	private HashMap<String, AtomicInteger> fRepairTools;

	public Statistics() {
		fMoneyGained = new AtomicInteger();
		fRentals = new Vector<RentalRequest>();
		fRepairMaterials = new HashMap<String, AtomicInteger>();
		fRepairTools = new HashMap<String, AtomicInteger>();
	}

	protected void print() {

		StringBuilder printer = new StringBuilder();
		for (RentalRequest rentalRequest : fRentals)
			printer.append(rentalRequest);
		printer.append(fRepairMaterials);
		printer.append(fRepairTools);
		printer.append(fMoneyGained);
		System.out.println(printer);
	}

	public void addMaterials(TreeMap<String, Integer> allRequiredMaterials) {
		for (Entry<String, Integer> set : allRequiredMaterials.entrySet()) {
			boolean containsKey=fRepairMaterials.containsKey(set.getKey());
			synchronized(fRepairMaterials) {
				if (containsKey) fRepairMaterials.get(set.getKey()).addAndGet(set.getValue());
				else fRepairMaterials.put(set.getKey(), new AtomicInteger(set.getValue()));
				}
			}
		}
	
	public void addTools(TreeMap<String, Integer> allRequiredTools) {
		for (Entry<String, Integer> set : allRequiredTools.entrySet()) {
			boolean containsKey=fRepairTools.containsKey(set.getKey());
			synchronized(fRepairTools) {
			if (containsKey) fRepairTools.get(set.getKey()).addAndGet(set.getValue());
			else fRepairTools.put(set.getKey(), new AtomicInteger(set.getValue()));
				}
		}
	}

	public void addDamageReport(DamageReport report, RentalRequest rentalRequest) {
		fMoneyGained.addAndGet(report.getAsset().getCostPerInt()*rentalRequest.getDurationOfStay());
		fRentals.add(rentalRequest);
		
	}
}
