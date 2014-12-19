package reit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class RunnableMaintenanceRequest implements Runnable {

	private HashMap<String, ArrayList<RepairMaterialInformation>> fRepairMaterialsInfo;
	private HashMap<String, ArrayList<RepairToolInformation>> fRepairToolsInfo;
	private Asset fAsset;
	private Warehouse fWarehouse;
	private Semaphore fMaintancePersons; // used for maitance threads
	private Semaphore fMaintenceThreadsCount; // used for maitance threads
	private CountDownLatch fCountDownLatch;
	private TreeMap<String, Integer> allRequiredMaterials;
	private TreeMap<String, Integer> allRequiredTools;
	private Statistics fStatistics;
	private Logger logger;



	public RunnableMaintenanceRequest(
			HashMap<String, ArrayList<RepairMaterialInformation>> fRepairMaterialsInfo,
			HashMap<String, ArrayList<RepairToolInformation>> fRepairToolsInfo,
			Asset fAsset, Warehouse fWarehouse, Semaphore fMaintancePersons,
			Semaphore fMaintenceThreadsCount, CountDownLatch fCountDownLatch,
			Statistics statistics) {
		this.fRepairMaterialsInfo = fRepairMaterialsInfo;
		this.fRepairToolsInfo = fRepairToolsInfo;
		this.fAsset = fAsset;
		this.fWarehouse = fWarehouse;
		this.fMaintancePersons = fMaintancePersons;
		this.fMaintenceThreadsCount = fMaintenceThreadsCount;
		this.fCountDownLatch = fCountDownLatch;
		allRequiredMaterials = new TreeMap<String, Integer>();
		allRequiredTools = new TreeMap<String, Integer>();
		fStatistics = statistics;
		logger = MyLogger.getLogger("RunnableMaintenanceRequest");
	}

	@Override
	public void run() {
		createLists();
		takeRepairMan();
		fWarehouse.AcquireTool(allRequiredTools);
		logger.info("Tools has been qcquired by the RepairMan to fix asset"
				+ fAsset.getName());
		fWarehouse.AcquireMaterial(allRequiredMaterials);
		logger.info("Materials has been qcquired by the RepairMan to fix asset"
				+ fAsset.getName());
		goToSleep();

		fWarehouse.ReleaseTool(allRequiredTools);
		fAsset.setFixed();
		fStatistics.addTools(allRequiredTools);
		fStatistics.addMaterials(allRequiredMaterials);
		releaseRepairMan();
	}

	private void goToSleep() {
		double sleepTime = fAsset.CalculateSleepTime();
		try {
			logger.info("Simulating fix for asset" + fAsset.getName()
					+ "  by sleeping " + sleepTime);
			Thread.sleep((long) sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void createLists() {
		ArrayList<AssetContent> assetContentList = fAsset.getContent();
		for (AssetContent assetContent : assetContentList) {
			ArrayList<RepairMaterialInformation> materialList=fRepairMaterialsInfo.get(assetContent.getName());
			ArrayList<RepairToolInformation> toolList = fRepairToolsInfo.get(assetContent.getName());
			for(RepairMaterialInformation material: materialList){
				if(allRequiredMaterials.get(material.getName())!=null) allRequiredMaterials.put(material.getName(),material.getQuantity());
				else allRequiredMaterials.put(material.getName(),allRequiredMaterials.get(material.getName())+material.getQuantity());
			}
			for(RepairToolInformation tool: toolList){
				if(allRequiredTools.get(tool.getName())!=null) allRequiredTools.put(tool.getName(),tool.getQuantity());
				else allRequiredTools.put(tool.getName(),Math.max(allRequiredTools.get(tool.getName()),tool.getQuantity()));
			}

		}
	}

	private void takeRepairMan() {
			try {
			fMaintancePersons.acquire();
			logger.info("Repairman start fixing asset" + fAsset.getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
			}

	}

	private void releaseRepairMan() {
	fCountDownLatch.countDown();
	fMaintancePersons.release();
	try {
		fMaintenceThreadsCount.acquire();
			logger.info("Repairman ended fixing asset" + fAsset.getName());
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
		synchronized (fMaintenceThreadsCount) {
	if(fMaintenceThreadsCount.availablePermits()==0) {
				fMaintenceThreadsCount.notifyAll();

			}
		}
	}
}