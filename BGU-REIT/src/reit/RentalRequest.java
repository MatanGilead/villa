package reit;

public class RentalRequest {
	private int fId;
	private String fAssetType;
	private double fAssetSize;
	private int fDurationOfStay;
	private Asset fAsset;
	private String fRequestStatus;

	/**
	 * Create a new RentalRequest.
	 * 
	 * @param id
	 *            id of the rentalRequest.
	 * @param assetType
	 *            the state of the RentalRequest.
	 * @param assetSize
	 *            the required asset size.
	 * @param durationOfStay
	 *            the days requested.
	 */
	public RentalRequest(int id, String assetType, double assetSize,
			int durationOfStay) {
		this.fId = id;
		this.fAssetType = assetType;
		this.fAssetSize = assetSize;
		this.fDurationOfStay = durationOfStay;
		this.fAsset = null;
		this.fRequestStatus = "INCOMPLETE";
	}

	/**
	 * Change the type of the current rentalRequest. can be
	 * INCOMPLETE,FULLFILLED,INPROGRESS,COMPLETE.
	 * 
	 * @param state
	 */
	public void setRequestStatus(String state) {
		fRequestStatus = state;
	}

	/**
	 * Set a an asset, should be an asset which fulfill the requirements.
	 * 
	 * @param foundOne
	 */
	public void setAsset(Asset foundOne) {
		fAsset = foundOne;

	}

	/**
	 * Returns the type of the rental request.
	 * 
	 * @return type
	 */
	public String getRentalRequestStatus() {
		return fRequestStatus;
	}

	/**
	 * Returns the id of the rental request.
	 * 
	 * @return id
	 */
	public int getId() {
		return fId;
	}

	/**
	 * Return the number of days requested.
	 * 
	 * @return days.
	 */
	public int getDurationOfStay() {
		return fDurationOfStay;
	}

	/**
	 * Return requested size.
	 * 
	 * @return size
	 */
	public double getAssetSize() {
		return fAssetSize;
	}

	/**
	 * Return requested asset type.
	 * 
	 * @return type
	 */
	public String getAssetType() {
		return fAssetType;
	}
	
	public String getAssetName(){
		//use this function only when a suitable asset is found (asset is not null)
		return fAsset.getName();
	}

}