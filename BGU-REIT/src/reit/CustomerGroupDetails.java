package reit;

import java.util.ArrayList;

public class CustomerGroupDetails {
	private ArrayList<RentalRequest> fRentalRequests; // only one thread on
														// every customerGroup,
														// so vector is good.
	private ArrayList<Customer> fCustomers;
	private String fGroupManagerName;

	CustomerGroupDetails(String name) {
		fRentalRequests = new ArrayList<RentalRequest>();
		fCustomers = new ArrayList<Customer>();
		fGroupManagerName = name;
	}

	public void addCustomer(Customer customer) {
		fCustomers.add(customer);
	}

	public void addRentalRequest(RentalRequest rentalRequest) {
		fRentalRequests.add(rentalRequest);
	}

}
