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

	public Asset(String name, String type, int xNum, int yNum, String status,
			int costPetInt, int size) {
		//constructor with parameters
		fName=name;
		fType=type;
		fLocation = new Location(xNum, yNum);
		fAssetContent = new ArrayList<AssetContent>() ;
		fStatus=status;
		fSize=size;	
		fHealth = 100;
		fCostPerInt = costPetInt;
	}
	
	/**
	 * Returns the location of the asset;
	 * 
	 * @return the location.
	 */
	Location getLocation() {
		//return location
		return fLocation;
	}

	/**
	 * Creates an AssetContent and add it to the AssetContent list.
	 * 
	 * @param name
	 *            name of assetContent.
	 * 
	 * @param repairMultiplier
	 *            asset multiplier
	 */

	public void addAssetContent(String name, float repairMultiplier) {
		fAssetContent.add(new AssetContent(name, repairMultiplier));

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
	 * @return remaining health number > 65.
	 */
	public boolean isFaulty() {
		return fHealth < 65;
	}

	/**
	 * Changed Asset state to "AVAILABLE".
	 */
	public void setFixed() {
		fStatus = "AVAILABLE";
		fHealth = 100;

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
	} //better change function name to setStatusUnavailalbe

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
	
	public void setOccupied(){
		fStatus = "OCCUPIED";
	}//we can just use a single setStatus function for all status types

	public boolean isOccupied(){
		if (fStatus.equals("OCCUPIED"))
			return true;
		return false;
	}

	public boolean reduceHealth(double damagePercentage) {
		fHealth=fHealth-damagePercentage;
		fHealth=Math.min(fHealth,100);
		fHealth = Math.max(fHealth, 0);
		if (fHealth > 65) {
			fStatus = "AVAILABLE";
			return true;
		}
		else {
			fStatus = "UNAVAILABLE";
			return false;
		}

	}

	public String getName() {
		return fName;
	}

	public int getCostPerInt() {
		return fCostPerInt;
	}

	public double CalculateSleepTime() {
		double sleepTime=0;
		for (AssetContent assetContent : fAssetContent)
			sleepTime = sleepTime + (100-fHealth) * assetContent.getMultiplier();
		return sleepTime;

	}

	public int CalculateGain(int duration) {
		return fCostPerInt * duration;
	}

	public String getAssetType() {
		return fType;
	}

	public double getHealth() {
		return fHealth;
	}

	}

