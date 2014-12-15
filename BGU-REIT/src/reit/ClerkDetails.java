package reit;

public class ClerkDetails {
	private String fName;
	private Location fLocation;

	public ClerkDetails(String name, Location location) {
		fName = name;
		fLocation = location;
	}

	public String getName() {
		return fName;
	}
	public Location getLocation(){
		return fLocation;
	}
}
