package reit;

class ClerkDetails {
	private String fName;
	private Location fLocation;

	ClerkDetails(String name, Location location) {
		//constructor with parameters
		fName = name;
		fLocation = location;
	}

	/**
	 * Return the name of the clerk.
	 * 
	 * @return name
	 */
	String getName() {
		//return name
		return fName;
	}

	/**
	 * Return the location of the clerk.
	 * 
	 * @return location.
	 */
	Location getLocation() {
		//return location
		return fLocation;
	}
}
