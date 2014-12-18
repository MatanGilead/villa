package reit;

public class RepairMaterial {
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
	public RepairMaterial(String name, int quantity) {
		fName = name;
		fQuantity = quantity;
	}

	/**
	 * Returns material name.
	 * 
	 * @return name.
	 */
	public String getName() {
		return fName;
	}

	/**
	 * Returns material quantity.
	 * 
	 * @return quantity.
	 */

	public int getQuantity() {
		return fQuantity;
	}

	/**
	 * Set material quantity.
	 * 
	 * @param quantity
	 *            the desireable quantity.
	 */
	public void setQuantity(int quantity) {
		fQuantity = quantity;
	}

}
