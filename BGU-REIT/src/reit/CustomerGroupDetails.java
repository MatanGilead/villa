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
	CustomerGroupDetails(String name) {
		fRentalRequests = new ArrayList<RentalRequest>();
		fCustomers = new ArrayList<Customer>();
		fGroupManagerName = name;
	}

	/**
	 * Add customer to the group.
	 * 
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		//add customer to the Customers collection
		fCustomers.add(customer);
	}

	/**
	 * add rental requests for the group.
	 * 
	 * @param rentalRequest
	 *            rental request
	 */
	public void addRentalRequest(RentalRequest rentalRequest) {
		//add rentalRequest to the RentalRequests collection
		fRentalRequests.add(rentalRequest);
	}
	
	/**
	 * remove the first rental request from the collection and return it.
	 * 
	 * @return RentalRequest
	 */
	public RentalRequest sendRentalRequest(){
	  RentalRequest newRequest = fRentalRequests.remove(0);
	  return newRequest;
	}

	/**
	 * returns a list of all customers at the group.
	 * 
	 * @return
	 */
	public ArrayList<Customer> getCustomers(){
		return fCustomers;
	}

	/**
	 * returns the group manager name.
	 * 
	 * @return
	 */
	public String getGroupManagerName() {
		return fGroupManagerName;
	}

	public int getNumberOfCustomersInGroup(){
		return fCustomers.size();
	}

	public Customer getCustomer(int index){
		return fCustomers.get(index);
	}


}
