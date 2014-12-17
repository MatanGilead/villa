package reit;


public class RepairToolInformation {
	private String fName;
	private int fQuantity;

	public RepairToolInformation(String name){
		fName = name;
		fQuantity = 0;
		
	}
	
	public RepairToolInformation(String name, int quantity) {
		fName = name;
		fQuantity = quantity;
	}
}
