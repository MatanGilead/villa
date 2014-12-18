package reit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;

public class Warehouse {
	private HashMap<String, RepairMaterial> materials;
	private HashMap<String, RepairTool> tools;

	public Warehouse(){
		materials = new HashMap<String, RepairMaterial>();
		tools = new HashMap<String, RepairTool>();
	}


	public void AcquireTool(TreeMap<String, Integer> requiredTools) {
		boolean hasItems = false;
		Stack<Semaphore> locks=new Stack<Semaphore>();
		while(hasItems==false){
			hasItems=true;
			for (Iterator<String> it = requiredTools.keySet().iterator(); it.hasNext() && hasItems;) {
				String toolName = it.next();
				RepairTool tool=tools.get(toolName);
					synchronized(tool){
						if(tool.getQuantity()<requiredTools.get(tool.getName())) {
							hasItems=false;
							waitForTools(tool,locks);
						}
						else{
							getLock(tool);
							locks.add(tool.getLock());
							if(tool.getQuantity()<requiredTools.get(tool.getName())) {
								hasItems=false;
								waitForTools(tool,locks);
								}
						}
					}
				}
			}

		if (hasItems = false) System.out.println("ERROR IN WAREHOUSE");
		for (Entry<String, Integer> tool : requiredTools.entrySet()) {
			RepairTool currentTool = tools.get(tool.getKey());
			currentTool.setQuantity(currentTool.getQuantity() - tool.getValue());
		}
		for(Semaphore lock: locks) lock.release();
	}
	


	private void getLock(RepairTool tool) {
		try {
			tool.getLock().acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void waitForTools(RepairTool tool, Stack<Semaphore> locks) {
		for(Semaphore lock: locks) lock.release();
		try {
			tool.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void ReleaseTool(TreeMap<String, Integer> returnTools) {
		for (Entry<String, Integer> tool : returnTools.entrySet()) {
			RepairTool currentTool = tools.get(tool.getKey());
			synchronized(tool){
			currentTool.setQuantity(currentTool.getQuantity() + tool.getValue());
			currentTool.notifyAll();
			}
		}	
	}


	public void AcquireMaterial(TreeMap<String, Integer> requiredMaterials) {
		for (Entry<String, Integer> material : requiredMaterials.entrySet()) {
			RepairMaterial currentMaterial = materials.get(material.getKey());
			synchronized (currentMaterial) {
			currentMaterial.setQuantity(currentMaterial.getQuantity() - material.getValue());
			}
		}
	}


	public void addTool(RepairTool tool) {
		tools.put(tool.getName(), tool);
	}


	public void addMaterial(RepairMaterial material) {
		materials.put(material.getName(), material);

	}


}
