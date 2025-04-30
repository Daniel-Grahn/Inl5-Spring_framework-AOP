package se.yrgo.services.customers;

import java.util.*;

import se.yrgo.domain.*;

public class CustomerManagementMockImpl implements CustomerManagementService {
	private HashMap<String,Customer> customerMap;

	public CustomerManagementMockImpl() {
		customerMap = new HashMap<String,Customer>();
		customerMap.put("OB74", new Customer("OB74" ,"Fargo Ltd", "some notes"));
		customerMap.put("NV10", new Customer("NV10" ,"North Ltd", "some other notes"));
		customerMap.put("RM210", new Customer("RM210" ,"River Ltd", "some more notes"));
	}

	@Override
	public void newCustomer(Customer newCustomer) {
		customerMap.put(newCustomer.getCustomerId(), newCustomer);
	}

	@Override
	public void updateCustomer(Customer changedCustomer) {
		customerMap.put(changedCustomer.getCustomerId(), changedCustomer);

	}

	@Override
	public void deleteCustomer(Customer oldCustomer) {
		customerMap.remove(oldCustomer.getCustomerId());

	}

	@Override
	public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
		Customer CustomerById = customerMap.get(customerId);
		return CustomerById;
	}

	@Override
	public List<Customer> findCustomersByName(String name) {
		List<Customer> findCustomers = new ArrayList<>();
		for(Customer c : customerMap.values()){
			if(c.getCompanyName().equals(name)){
				findCustomers.add(c);
			}
		}
		return findCustomers;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allCustomers = new ArrayList<>();
		for(Customer c : customerMap.values()){	
			allCustomers.add(c);
		}
		return allCustomers;
	}

	@Override
	public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException { //I don't know if this is right
		Customer customer = findCustomerById(customerId);
		return customer;
	}

	@Override
	public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
		//First find the customer
		Customer customer = findCustomerById(customerId);
		//Call the addCall on the customer
		customer.addCall(callDetails);
		
	}

}
