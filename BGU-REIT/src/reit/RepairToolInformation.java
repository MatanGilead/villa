package reit;

import java.util.ArrayList;

import test.RepairTool;

public class RepairToolInformation {
	private String fName;
	private ArrayList<RepairTool> fTools;

	public RepairToolInformation(String name) {
		fName = name;
		fTools = new ArrayList<RepairTool>();
	}

	public void addRepairTool(String name, int quantity) {
		fTools.add(new RepairTool(name, quantity));
	}
}
