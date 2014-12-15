package test;

public class RepairTool {
	private String fName;
	private int fQuantity;
	public RepairTool(String name, int count) {
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
