package reit;

class Location {
private int fX;
private int fY;

/**
 * Create a new Location by x,y coordinates.
 * @param fX x x coordinate.
 *@param y y coordinate.
 */
	Location(int x, int y) {
	fX=x;
	fY=y;
}

	/**
	 * Calculates the distance between two Locations.
	 * 
	 * @param other
	 *            the other Location to do the measure.
	 * @return the euclidean distance.
	 */
	double CalculateDistance(Location other) {
	return Math.sqrt(Math.pow(fX-other.fX,2)+Math.pow(fY-other.fY,2));
}
	
}
