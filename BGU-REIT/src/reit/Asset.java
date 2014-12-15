package reit;

import java.util.ArrayList;

import test.RepairTool;

public class Asset {
	private String fName;
	private String fType;
	private Location fLocation;
	private ArrayList<AssetContent> fAssetContent;
	private String fStatus; // possibly switch to int
	private int fCostPerInt;
	private int fSize;

	public Asset(String name,String type,Location location,String status,int costPetInt,int size){
		//constructor with parameters
		fName=name;
		fType=type;
		fLocation=location;
		fAssetContent = new ArrayList<AssetContent>() ;
		fStatus=status;
		fSize=size;	
		
	}
	
	public Location getLocation(){
		//return location
		return fLocation;
	}
	
	public void addAssetContent(AssetContent assetContent){
		//add asset content to the asset content collection
		fAssetContent.add(assetContent);
	}
}

