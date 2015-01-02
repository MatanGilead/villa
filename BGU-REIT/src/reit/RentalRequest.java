package reit;

class RentalRequest {
	private int fId;
	private String fAssetType;
	private int fAssetSize;
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
	RentalRequest(int id, String assetType, int assetSize,
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
	void setRequestStatus(String state) {
		fRequestStatus = state;
	}

	/**
	 * Set a an asset, should be an asset which fulfill the requirements.
	 * 
	 * @param foundOne
	 */
	void setAsset(Asset foundOne) {
		fAsset = foundOne;

	}

	/**
	 * Returns the type of the rental request.
	 * 
	 * @return type
	 */
	String getRentalRequestStatus() {
		return fRequestStatus;
	}

	/**
	 * Returns the id of the rental request.
	 * 
	 * @return id
	 */
	int getId() {
		return fId;
	}

	/**
	 * Return the number of days requested.
	 * 
	 * @return days.
	 */
	int getDurationOfStay() {
		return fDurationOfStay;
	}

	/**
	 * Return requested size.
	 * 
	 * @return size
	 */
	int getAssetSize() {
		return fAssetSize;
	}

	/**
	 * Return requested asset type.
	 * 
	 * @return type
	 */
	String getAssetType() {
		return fAssetType;
	}
	
	String getAssetName() {
		//use this function only when a suitable asset is found (asset is not null)
		return fAsset.getName();
	}

	Asset getAsset() {
		return fAsset;
	}

	@Override
	public String toString(){
		return new String("Rental Request  " + fId + " requires: " + fAssetType
				+ " at size " + fAssetSize + ", for " + fDurationOfStay
				+ " nights, is at status " + fRequestStatus)
				+ "\n";
	}
}