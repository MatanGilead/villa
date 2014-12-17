package reit;

public class RepairMaterial {
	private String fName;
	private int fQuantity;
	public RepairMaterial(String name, int count) {
		fName = name;
		fQuantity = count;
	}

	public String getName() {
		return fName;
	}


	public int getQuantity() {
		return fQuantity;
	}

	public void setQuantity(int quantity) {
		fQuantity = quantity;
	}

}
