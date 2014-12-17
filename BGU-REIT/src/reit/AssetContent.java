package reit;


public class AssetContent {
	private String fName;
	private double fRepairCostMultiplyer;

	public AssetContent(String name, double repairCostMultiplyer){
		//constructor with parameters
		fName=name;
		fRepairCostMultiplyer= repairCostMultiplyer;
	}

	public String getName() {
		return fName;
	}
	public double getMultiplier() {
		return fRepairCostMultiplyer;
	}
	
}
