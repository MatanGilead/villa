package reit;

import java.util.ArrayList;

public class Assets {

	/**
	 * @param fAssets
	 *            Collection of assets.
	 */
	private ArrayList<Asset> fAssets;

	public Assets() {
		fAssets = new ArrayList<Asset>();
	}
	public ArrayList<Asset> damagedAssets() { 
		return null;
	}

	/**
	 * Find a suitable asset for rental request.
	 * 
	 * @param request
	 *            relevant RentalRequest.
	 * @param asset
	 *            if the currently asset is available, try to grab it by calling
	 *            setFound(rentalRequest) method.
	 * @return if an asset has been found - return it. else null.
	 */
	public Asset find(RentalRequest request) {
		for(Asset asset: fAssets){
			if (asset.getAssetSize() >= request.getAssetSize()	&& asset.isAvailable() && setFound(request,asset)) {
					return asset;
					
			}
			}
		return null;
	}

	/**
	 * this is Find complementary function. Checks if a suitable asset for
	 * rental request is still available. if so, pair them.
	 * 
	 * @param relevant
	 *            request.
	 * @param the
	 *            asset that may be suitable.
	 * @return returns true if there is a match, else false.
	 */
	private boolean setFound(RentalRequest request, Asset asset) {
		synchronized (asset) {
			if (asset.getAssetSize() >= request.getAssetSize()
					&& asset.isAvailable()) {
				asset.setBooked();
				return true;
			}
			else
				return false;
		}
	}

	public int findAssetByName(String assetName){
			int i=0;
			boolean found=false;
			while((!found)&&i<fAssets.size()){
			if (fAssets.get(i).getName()==assetName) found=true;
			else
				i++;
			}
			return i; //must find the asset. returns it's index
	}

	
	/**
	 * Add an asset to the collection, Call from management.;
	 */
	public void addAsset (Asset asset){
		fAssets.add(asset);
		
	}

	/**
	 * 
	 * @return returns an ArrayList of damaged assets
	 */
	public ArrayList<Asset> getBroken() {
		// TODO Auto-generated method stub
		 ArrayList<Asset> brokenList=new ArrayList<Asset>();
		 for(Asset borkenAsset: fAssets){
			 if (borkenAsset.getBroken()) brokenList.add(borkenAsset);
		 }
		 return brokenList;
	}
	public Asset findAssetByIndex(int index) {
		// TODO Auto-generated method stub
		if ((fAssets.size()+1>index)&&(index>-1))
		return fAssets.get(index);
		else return null;
	} 

}
