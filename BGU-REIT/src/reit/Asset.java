package reit;

import java.util.ArrayList;

public class Asset {
	private String fName;
	private String fType;
	private Location fLocation;
	private ArrayList<AssetContent> fAssetContent;
	private String fStatus; // possibly switch to int
	private int fCostPerInt;
	private int fSize;
	
	public Location getLocation(){
		return fLocation;
	}
}


// /aaaa///