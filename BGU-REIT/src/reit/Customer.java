package reit;

import java.util.Random;

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
		double damageValue;
		if (fVandalismType.equals("Arbitrary")) {
			Random random = new Random();
			damageValue=fMinDamage+(fMaxDamage-fMinDamage)*random.nextDouble();
		} else if (fVandalismType.equals("Fixed")) {
			damageValue=(fMinDamage+fMaxDamage)/2;
		}else
			damageValue=0.5;

		return damageValue / 2;
	}
}
