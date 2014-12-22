package reit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
		for (Asset assaet : fAssets)
			// print
			System.out.println(assaet.isAvailable() + "     "
					+ assaet.getName() + "     " +
 assaet.getHealth()
					+ "         "
					+ assaet.getAssetType() + "    " + assaet.getAssetSize());
				
		for(Asset asset: fAssets){
			if (asset.getAssetSize() >= request.getAssetSize()	&& request.getAssetType().equals(asset.getAssetType()) && asset.isAvailable() && setFound(request,asset)) {
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
			if (asset.isAvailable()) {
				asset.setBooked();
				return true;
			}
			else
				return false;
		}
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

			synchronized (borkenAsset) {
				if (borkenAsset.isOccupied())
				waitForAsset(borkenAsset);
			}
			 if (borkenAsset.getBroken()) brokenList.add(borkenAsset);

		 }
		 return brokenList;
	}

	private void waitForAsset(Asset borkenAsset) {
			try {
				borkenAsset.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	protected void sort(){
		Collections.sort(fAssets, new Comparator<Asset>(){
			public int compare(Asset s1, Asset s2) {
				  if (s1.getAssetSize()>s2.getAssetSize()) return 1;
				else
					return -1;
			 }
		});
	}




}
