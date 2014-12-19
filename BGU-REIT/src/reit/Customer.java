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
		if (fVandalismType=="ARBITRARY"){
			Random random = new Random();
			damageValue=fMinDamage+(fMaxDamage-fMinDamage)*random.nextDouble();
		}if (fVandalismType=="FIXED"){
			damageValue=(fMinDamage+fMaxDamage)/2;
		}else
			damageValue=0.5;

		return damageValue;
	}
}
