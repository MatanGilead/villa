package reit;


class AssetContent {
	private String fName;
	private double fRepairCostMultiplyer;

	/**
	 * 
	 * @param name the name of the asset content.
	 * @param repairCostMultiplyer cost measure.
	 */
	AssetContent(String name, double repairCostMultiplyer) {
		fName=name;
		fRepairCostMultiplyer= repairCostMultiplyer;
	}

	/**
	 * Return the name;
	 * @return the name;
	 */
	String getName() {
		return fName;
	}

	/**
	 * Return the multiplier;
	 * 
	 * @return the multiplier;
	 */
	double getMultiplier() {
		return fRepairCostMultiplyer;
	}
	
}
