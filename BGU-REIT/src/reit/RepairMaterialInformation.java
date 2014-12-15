package reit;

import java.util.ArrayList;


public class RepairMaterialInformation {
	private String fName;
	private ArrayList<RepairMaterial> fMaterials;

	public RepairMaterialInformation(String name) {
		fName = name;
		fMaterials = new ArrayList<RepairMaterial>();
	}

	public void addRepairMaterial(String name, int quantity) {
		fMaterials.add(new RepairMaterial(name, quantity));
	}
}