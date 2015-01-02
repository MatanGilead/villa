package reit;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

class Warehouse {
	private HashMap<String, RepairMaterial> materials;
	private HashMap<String, RepairTool> tools;

	// private Logger logger;
	public Warehouse(){
		materials = new HashMap<String, RepairMaterial>();
		tools = new HashMap<String, RepairTool>();
		// logger = MyLogger.getLogger("Warehouse");
	}

	/**
	 * Give tools to the repairman. Method of work: Check if the warehouse
	 * private collection contains the tool. a. if true: grab the tool special
	 * lock, check then the tools is still exist(if not, go to b) and check the
	 * next tool. b. if not - release all the locks and wait for this specific
	 * tool, then start over the search. if all the tools locks have been
	 * acquired, grab the items and release the locks!
	 * 
	 * @param requiredTools
	 *            required tools by repair man, needed to be ordered
	 *            lexicographically.
	 */
	void AcquireTool(TreeMap<String, Integer> requiredTools) {
		boolean hasItems = false;
		while(hasItems==false){
			hasItems=true;
			for (Iterator<Entry<String, Integer>> it = requiredTools.entrySet().iterator(); it.hasNext() && hasItems;) {
				Entry<String,Integer> set=it.next();
				String toolName = set.getKey();
				RepairTool tool=tools.get(toolName);
					synchronized(tool){
					if (!tool.acquireTool(set.getValue())) {
							hasItems=false;
							waitForTools(set,requiredTools);
						}
				}
			}
		}


	}
	
	private void waitForTools(Entry<String, Integer> set,
			TreeMap<String, Integer> requiredTools) {
		for (Iterator<Entry<String, Integer>> it = requiredTools.entrySet()
				.iterator(); it.hasNext();) {
			Entry<String, Integer> releaseTool = it.next();
			if(set.equals(it)) break;
			RepairTool warehouseTool = tools.get(releaseTool.getKey());
			synchronized (warehouseTool) {
				warehouseTool.setQuantity(releaseTool.getValue());
				warehouseTool.notifyAll();
			}
		}
		RepairTool waitForRepairTool = tools.get(set.getKey());

		try {
				waitForRepairTool.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}


	void ReleaseTool(TreeMap<String, Integer> returnTools) {
		for (Entry<String, Integer> tool : returnTools.entrySet()) {
			RepairTool currentTool = tools.get(tool.getKey());
			synchronized (currentTool) {
				currentTool.setQuantity(tool.getValue());
				currentTool.notifyAll();
				}
			}
		}	



	void AcquireMaterial(TreeMap<String, Integer> requiredMaterials) {
		for (Entry<String, Integer> material : requiredMaterials.entrySet()) {
			RepairMaterial currentMaterial = materials.get(material.getKey());
			synchronized (currentMaterial) {
			currentMaterial.setQuantity(currentMaterial.getQuantity() - material.getValue());
			}
		}
	}


	void addTool(RepairTool tool) {
		tools.put(tool.getName(), tool);
	}


	void addMaterial(RepairMaterial material) {
		materials.put(material.getName(), material);

	}


}
