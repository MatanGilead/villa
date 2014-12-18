package reit;

public class ClerkDetails {
	private String fName;
	private Location fLocation;

	public ClerkDetails(String name, Location location) {
		//constructor with parameters
		fName = name;
		fLocation = location;
	}

	/**
	 * Return the name of the clerk.
	 * 
	 * @return name
	 */
	public String getName() {
		//return name
		return fName;
	}

	/**
	 * Return the location of the clerk.
	 * 
	 * @return location.
	 */
	public Location getLocation(){
		//return location
		return fLocation;
	}
}
