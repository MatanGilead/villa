package reit;

public class ClerkDetails {
	private String fName;
	private Location fLocation;

	public ClerkDetails(String name, Location location) {
		//constructor with parameters
		fName = name;
		fLocation = location;
	}

	public String getName() {
		//return name
		return fName;
	}
	public Location getLocation(){
		//return location
		return fLocation;
	}
}
