package reit;

import java.util.HashMap;
import java.util.Map.Entry;

public class Warehouse {
	private HashMap<String, RepairMaterial> materials;
	private HashMap<String, RepairTool> tools;

	public Warehouse(){
		materials = new HashMap<String, RepairMaterial>();
		tools = new HashMap<String, RepairTool>();
	}


	public synchronized void AcquireTool(HashMap<String, Integer> requiredTools) {
		
		boolean hasItems = false;
		while(hasItems==false){
			hasItems=true;
			for (Entry<String, Integer> tool : requiredTools.entrySet()) {
				if (tools.get(tool.getKey()).getQuantity() < tool.getValue()) hasItems = false;
			}
			if (hasItems == false)
				waitForTools();
		}
		for (Entry<String, Integer> tool : requiredTools.entrySet()) {
			RepairTool currentTool = tools.get(tool.getKey());
			currentTool
					.setQuantity(currentTool.getQuantity() - tool.getValue());
		}
	}
	

	private synchronized void waitForTools() {
		try {
			wait();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}


	public synchronized void ReleaseTool(HashMap<String, Integer> returnTools) {
		for (Entry<String, Integer> tool : returnTools.entrySet()) {
			RepairTool currentTool = tools.get(tool.getKey());
			currentTool
					.setQuantity(currentTool.getQuantity() + tool.getValue());
			notifyAll();
		}

	}


	public synchronized void AcquireMaterial(
			HashMap<String, Integer> requiredMaterials) {
		for (Entry<String, Integer> material : requiredMaterials.entrySet()) {
			RepairMaterial currentMaterial = materials.get(material.getKey());
			currentMaterial.setQuantity(currentMaterial.getQuantity() - material.getValue());
		}
	}


	public void addTool(RepairTool tool) {
		tools.put(tool.getName(), tool);
	}


	public void addMaterial(RepairMaterial material) {
		materials.put(material.getName(), material);

	}


}
