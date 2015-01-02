package reit;


class RepairToolInformation {
	private String fName;
	private int fQuantity;

	RepairToolInformation(String name) {
		fName = name;
		fQuantity = 0;
		
	}
	
	RepairToolInformation(String name, int quantity) {
		fName = name;
		fQuantity = quantity;
	}

	String getName() {
		return fName;
	}

	int getQuantity() {
		return fQuantity;
	}
}
