package reit;

import java.util.Vector;

public class CustomerGroupDetails {
	private Vector fRentalRequests; //only one thread on every customerGroup, so vector is good.
	private Vector fCustomers;
	private String fGroupManagerName;

	public void addCustomer(Customer customer) {
		//add customer 

	}

	public void addRentalRequest(RentalRequest rentalRequest) {

	}

}
