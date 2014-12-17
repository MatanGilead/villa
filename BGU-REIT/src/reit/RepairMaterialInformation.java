package reit;



public class RepairMaterialInformation {
	//should change to only material and then count.
	
	private String fName;
//	private ArrayList<RepairMaterial> fMaterials;
	private int fQountity;
	
	
	public RepairMaterialInformation(String name, int quantity) {
		fName= name;
		fQountity = quantity;
	}
	
	public String getName() {
		return fName;
	}

	public Integer getQuantity() {
		return fQountity;
	}
}
