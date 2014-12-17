package reit;

import java.util.ArrayList;


public class RepairMaterialInformation {
	//should change to only material and then count.
	
	private String fName;
//	private ArrayList<RepairMaterial> fMaterials;
	private int fCountity;
	
	
	public RepairMaterialInformation(String name, int countity){
		fName= name;
		fCountity=countity;
	}
	
//	public RepairMaterialInformation(String name) {
	//	fName = name;
	//	fMaterials = new ArrayList<RepairMaterial>();
//	}

	//public void addRepairMaterial(String name, int quantity) {
	//	fMaterials.add(new RepairMaterial(name, quantity));
	//}
}