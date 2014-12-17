package reit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class RunnableMaintenanceRequest implements Runnable {

	private HashMap<String, ArrayList<RepairMaterialInformation>> fRepairMaterialsInfo;
	private HashMap<String, ArrayList<RepairToolInformation>> fRepairToolsInfo;
	private Asset fAsset;
	private Warehouse fWarehouse;
	private Semaphore fMaintancePersons; // used for maitance threads
	private Semaphore fMaintenceThreadsCount; // used for maitance threads
	private CountDownLatch fCountDownLatch;
	private HashMap<String, Integer> allRequiredMaterials;
	private HashMap<String, Integer> allRequiredTools;
	private Statistics fStatistics;



	public RunnableMaintenanceRequest(
			HashMap<String, ArrayList<RepairMaterialInformation>> fRepairMaterialsInfo,
			HashMap<String, ArrayList<RepairToolInformation>> fRepairToolsInfo,
			Asset fAsset, Warehouse fWarehouse, Semaphore fMaintancePersons,
			Semaphore fMaintenceThreadsCount, CountDownLatch fCountDownLatch,
			Statistics statistics) {
		super();
		this.fRepairMaterialsInfo = fRepairMaterialsInfo;
		this.fRepairToolsInfo = fRepairToolsInfo;
		this.fAsset = fAsset;
		this.fWarehouse = fWarehouse;
		this.fMaintancePersons = fMaintancePersons;
		this.fMaintenceThreadsCount = fMaintenceThreadsCount;
		this.fCountDownLatch = fCountDownLatch;
		allRequiredMaterials = new HashMap<String, Integer>();
		allRequiredTools = new HashMap<String, Integer>();
		fStatistics = statistics;
	}

	@Override
	public void run() {
		takeRepairMan();
		createLists();
		fWarehouse.AcquireTool(allRequiredTools);
		fWarehouse.AcquireMaterial(allRequiredMaterials);
		goToSleep();
		fWarehouse.ReleaseTool(allRequiredTools);
		fAsset.setFixed();
		fStatistics.addTools(allRequiredTools);
		fStatistics.addMaterials(allRequiredMaterials);
		releaseRepairMan();
	}

	private void goToSleep() {
		ArrayList<AssetContent> assetContentList = fAsset.getContent();
		double sleepTime = 0;
		for (AssetContent assetContent : assetContentList) {
			sleepTime = sleepTime + (100-fAsset.getHealth()) * assetContent.getMultiplier();
		}
		Thread.sleep((long) sleepTime);

	}


	private void createLists() {
		ArrayList<AssetContent> assetContentList = fAsset.getContent();
		for (AssetContent assetContent : assetContentList) {
			ArrayList<RepairMaterialInformation> materialList=fRepairMaterialsInfo.get(assetContent.getName());
			ArrayList<RepairToolInformation> toolList = fRepairToolsInfo.get(assetContent.getName());
			for(RepairMaterialInformation material: materialList){
				if(allRequiredMaterials.get(material.getName()==null) allRequiredMaterials.put(material.getName(),material.getQuantity());
				else allRequiredMaterials.put(material.getName(),allRequiredMaterials.get(material.getName())+material.getQuantity());
			}
			for(RepairToolInformation tool: toolList){
				if(allRequiredTools.get(material.getName()==null) allRequiredTools.put(material.getName(),material.getQuantity());
				else allRequiredTools.put(material.getName(),max(allRequiredTools.get(material.getName()),material.getQuantity()));
			}

		}
		
	}

	private void takeRepairMan() {
		try {
			fMaintenceThreadsCount.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void releaseRepairMan() {
	fCountDownLatch.countDown();
	fMaintancePersons.release();
	try {
		fMaintenceThreadsCount.acquire();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	if(fMaintenceThreadsCount.availablePermits()==0) fMaintenceThreadsCount.notifyAll();
	
}

}