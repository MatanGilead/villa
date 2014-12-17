package reit;

import java.util.ArrayList;

public class CustomerGroupDetails {
	private ArrayList<RentalRequest> fRentalRequests; // only one thread on
														// every customerGroup,
														// so vector is good.
	private ArrayList<Customer> fCustomers;
	private String fGroupManagerName;

	CustomerGroupDetails(String name) {
		//constructor with parameters
		fRentalRequests = new ArrayList<RentalRequest>();
		fCustomers = new ArrayList<Customer>();
		fGroupManagerName = name;
	}

	public void addCustomer(Customer customer) {
		//add customer to the Customers collection
		fCustomers.add(customer);
	}

	public void addRentalRequest(RentalRequest rentalRequest) {
		//add rentalRequest to the RentalRequests collection
		fRentalRequests.add(rentalRequest);
	}

}
