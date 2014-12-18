package reit;

public class Customer {
	private String fName;
	private String fVandalismType;
	private double fMinDamage;
	private double fMaxDamage;

	Customer(String name, String VandalismType, double MinDamage,
			double MaxDamage) {
		//constructor with parameters
		fName = name;
		fVandalismType = VandalismType;
		fMinDamage = MinDamage;
		fMaxDamage = MaxDamage;
	}
	public double CalculateDamage() {
		//calculate customer's damage
		return 0;
	}
}
