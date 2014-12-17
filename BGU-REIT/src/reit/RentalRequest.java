package reit;

public class RentalRequest {
	private int fId;
	private String fAssetType;
	private double fAssetSize;
	private int fDurationOfStay;
	private Asset fAsset;
	private String fRequestStatus;


public RentalRequest(int id, String assetType, double assetSize,
			int durationOfStay) {
	//constructor with parameters
	this.fId =id;
	this.fAssetType = assetType;
	this.fAssetSize = assetSize;
	this.fDurationOfStay = durationOfStay;
		this.fAsset = null;
		this.fRequestStatus = "INCOMPLETE";
	}

public synchronized void setRequestStatus(String state){

}

public void setAsset(Asset foundOne) {
	// TODO Auto-generated method stub
	
}

public String getRentalRequestStatus(){
	return fRequestStatus;
}

}