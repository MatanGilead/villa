package reit;

import java.util.ArrayList;

import test.Warehouse;

public class RunnableMaintenanceRequest implements Runnable {

	private ArrayList<RepairToolInformation> fRepairToolsInformation;
	private ArrayList<RepairMaterialInformation> fRepairMaterialInformation;
	private Asset fAsset;
	private Warehouse fWarehouse;

	public RunnableMaintenanceRequest() {

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
