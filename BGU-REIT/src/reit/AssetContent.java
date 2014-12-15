package reit;


public class AssetContent {
	private String fName;
	private double fHealth; // beteen 0 to 100, including edges
	private double fRepairCostMultiplyer;

	public AssetContent(String name, double repairCostMultiplyer){
		//constructor with parameters
		fName=name;
		fHealth=100;
		fRepairCostMultiplyer= repairCostMultiplyer;
	}
	
}
