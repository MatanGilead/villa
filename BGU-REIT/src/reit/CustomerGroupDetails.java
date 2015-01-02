package reit;

import java.util.ArrayList;

public class CustomerGroupDetails {
	private ArrayList<RentalRequest> fRentalRequests;
	private ArrayList<Customer> fCustomers;
	private String fGroupManagerName;

	/**
	 * Creates a new CustomersGroup & initializing values.
	 * 
	 * @param name
	 *            name of the group manager.
	 */
	public CustomerGroupDetails(String name) {
		fRentalRequests = new ArrayList<RentalRequest>();
		fCustomers = new ArrayList<Customer>();
		fGroupManagerName = name;
	}

	/**
	 * Add customer to the group.
	 * 
	 * @param customer
	 */
	public void addCustomer(String name, String vandalism, byte minimumDamage,
			byte maximumDamage) {
		fCustomers.add(new Customer(name, vandalism, minimumDamage,
				maximumDamage));

	}

	boolean isEmptyRentalRequest() {
		return fRentalRequests.isEmpty();
	}
	/**
	 * add rental requests for the group.
	 * 
	 * @param rentalRequest
	 *            rental request
	 */
	
	public void addRentalRequest(Byte id, String type, byte size, byte duration) {
		fRentalRequests.add(new RentalRequest(id, type, size, duration));

	}

	/**
	 * remove the first rental request from the collection and return it.
	 * 
	 * @return RentalRequest
	 */
	RentalRequest sendRentalRequest() {
	  RentalRequest newRequest = fRentalRequests.remove(0);
	  return newRequest;
	}

	/**
	 * returns a list of all customers at the group.
	 * 
	 * @return
	 */
	ArrayList<Customer> getCustomers() {
		return fCustomers;
	}

	/**
	 * returns the group manager name.
	 * 
	 * @return
	 */
	String getGroupManagerName() {
		return fGroupManagerName;
	}

	int getNumberOfCustomersInGroup() {
		return fCustomers.size();
	}

	Customer getCustomer(int index) {
		return fCustomers.get(index);
	}




}
