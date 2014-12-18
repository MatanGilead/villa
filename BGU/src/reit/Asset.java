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
	private double fHealth; // beteen 0 to 100, including edges

	public Asset(String name,String type,Location location,String status,int costPetInt,int size){
		//constructor with parameters
		fName=name;
		fType=type;
		fLocation=location;
		fAssetContent = new ArrayList<AssetContent>() ;
		fStatus=status;
		fSize=size;	
		fHealth = 100;
	}
	
	/**
	 * Returns the location of the asset;
	 * 
	 * @return the location.
	 */
	public Location getLocation(){
		//return location
		return fLocation;
	}

	/**
	 * Add's an AssetContent to the AssetContent list.
	 * 
	 * @param assetContent
	 *            assetContent the content.
	 */
	public void addAssetContent(AssetContent assetContent){
		//add asset content to the asset content collection
		fAssetContent.add(assetContent);
	}

	/**
	 * Returns list of all AssetContents.
	 * 
	 * @return the list.
	 */
	public ArrayList<AssetContent> getContent() {
		return fAssetContent;
	}

	/**
	 * Returns health state.
	 * 
	 * @return remaining health number.
	 */
	public double getHealth() {
		return fHealth;
	}

	/**
	 * Changed Asset state to "AVAILABLE".
	 */
	public void setFixed() {
		fStatus = "AVAILABLE";

	}

	/**
	 * Returns the size of the asset.
	 * 
	 * @return the size.
	 */
	public int getAssetSize() {
		return fSize;
	}

	/**
	 * Returns true if the asset need to be repaired - "UNAVAILABLE".
	 */
	public boolean getBroken() {
		if (fStatus.equals("UNAVAILABLE"))
			return true;
		return false;
	}

	/**
	 * Changed Asset state to "UNAVAILABLE".
	 */
	public void setBroken() {
		fStatus = "UNAVAILABLE";
	}

	/**
	 * Returns true if the asset is "AVAILABLE".
	 */
	public boolean isAvailable() {
		return fStatus.equals("AVAILABLE");
	}

	/**
	 * Set the state of the asset to be "BOOKED" used if the asset has been
	 * booked by an asset for a rental request.
	 */
	public void setBooked() {
		fStatus = "BOOKED";

	}

	public void reduceHealth(double damagePercentage) {
		fHealth=fHealth-fHealth;
		fHealth=Math.min(fHealth,100);
		fHealth=Math.max(fHealth,0);		
	}

	public String getName() {
		return fName;
	}

	public int getCostPerInt() {
		return fCostPerInt;
	}
}

