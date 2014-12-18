package reit;

public class DamageReport {
	private Asset fAsset;
	private double fDamagePercentage;

	/**
	 * 
	 * @param asset
	 *            relevant asset.
	 * @param damagePercentage
	 *            the damage that needed to be added to the asset.
	 */
	public DamageReport(Asset asset, double damagePercentage) {
		fDamagePercentage = damagePercentage;
		fAsset = asset;
	}

	/**
	 * Returns the asset of the report.
	 * 
	 * @return asset
	 */
	public Asset getAsset() {
		return fAsset;
	}

	/**
	 * Returns the damage that the customers have done to the asset.
	 * 
	 * @return the damage.
	 */
	public double getDamagePercentage() {
		return fDamagePercentage;
	}
}
