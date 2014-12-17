package reit;

import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse implements WarehouseInter {
	private HashMap<String, RepairMaterial> materials;
	private HashMap<String, RepairTool> tools;

	public Warehouse(){
		materials = new HashMap<String, RepairMaterial>();
		tools = new HashMap<String, RepairTool>();
	}

	@Override
	public void AcquireTool(HashMap<String, Integer> tool) {
		// TODO Auto-generated method stub
	tools.	

	}

	@Override
	public void ReleaseTool(ArrayList<RepairTool> tool) {
		// TODO Auto-generated method stub

	}

	@Override
	public void AcquireMaterial(ArrayList<RepairMaterial> material) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTool(RepairTool tool) {
		tools.put(tool.getName(), tool);
	}

	@Override
	public void addMaterial(RepairMaterial material) {
		materials.put(material.getName(), material);

	}


}
