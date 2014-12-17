package reit;

import java.util.ArrayList;

public class RepairToolInformation {
	private String fName;
	private int fCountity;

	public RepairToolInformation(String name){
		fName = name;
		fCountity = 0;
		
	}
	
	public RepairToolInformation(String name, int countity) {
		fName = name;
		fCountity = countity;
	}
}
