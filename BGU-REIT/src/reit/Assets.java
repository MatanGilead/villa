package reit;

import java.util.ArrayList;

public class Assets {
	//we want that the search would be fast ,but every change on asset need to be through a sync method on asset with retns boolean if succeed
	private ArrayList<Asset> fAssets;
	
	//might be in use for statistics. every assets will enter here twice
	public Assets() {
		//empty constructor
		fAssets = new ArrayList<Asset>();
	}
	public ArrayList<Asset> damagedAssets() { 
		return null;
	}

	public Asset find(RentalRequest request) {  //changes on this method would be safe because no one will iterate on not available asset
		return null;
	}
	
	public void addAsset (Asset asset){
		//add a single asset to the assets collection
		fAssets.add(asset);
		
	} 

}
