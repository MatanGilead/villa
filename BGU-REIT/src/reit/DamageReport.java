package reit;

public class DamageReport {
	private Asset fAsset;
	private double fDamagePercentage;

	public DamageReport(Asset asset, double damagePercentage) {
		fDamagePercentage = damagePercentage;
		fAsset = asset;
	}

	public Asset getAsset() {
		return fAsset;
	}

	public void setAsset(Asset fAsset) {
		this.fAsset = fAsset;
	}

	public double getDamagePercentage() {
		return fDamagePercentage;
	}
}
