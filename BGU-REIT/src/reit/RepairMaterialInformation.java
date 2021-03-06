package reit;


class RepairMaterialInformation {
	private String fName;
	private int fQuantity;
	
	/**
	 * Create a new Repair Material, used for Warehouse.
	 * 
	 * @param name
	 *            name of material.
	 * @param count
	 *            quantity of material.
	 */
	RepairMaterialInformation(String name, int quantity) {
		fName= name;
		fQuantity = quantity;
	}
	
	/**
	 * Returns material name.
	 * 
	 * @return name.
	 */
	String getName() {
		return fName;
	}

	/**
	 * Returns material quantity.
	 * 
	 * @return quantity.
	 */

	int getQuantity() {
		return fQuantity;
	}
}
