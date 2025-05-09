package se.yrgo.services.customers;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;

import se.yrgo.dataaccess.*;
import se.yrgo.domain.*;

public class CustomerManagementServiceProductionImpl implements CustomerManagementService {
    private CustomerDao customerDao;

    public CustomerManagementServiceProductionImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void newCustomer(Customer newCustomer) {
        customerDao.create(newCustomer);
    }

    @Override
    public void updateCustomer(Customer changedCustomer) throws CustomerNotFoundException {
        try {
            customerDao.update(changedCustomer);
        } catch (RecordNotFoundException rec) {
            System.err.println(rec);
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public void deleteCustomer(Customer oldCustomer) throws CustomerNotFoundException {
        try {
            customerDao.delete(oldCustomer);
        } catch (RecordNotFoundException rec) {
            System.err.println(rec);
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public Customer findCustomerById(String customerId) throws CustomerNotFoundException {
        try {
            Customer customer = customerDao.getById(customerId);
            return customer;
        } catch (RecordNotFoundException rec) {
            System.err.println(rec);
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public List<Customer> findCustomersByName(String name) {
        return customerDao.getByName(name);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @Override
    public Customer getFullCustomerDetail(String customerId) throws CustomerNotFoundException {
        try {
            Customer customer = customerDao.getFullCustomerDetail(customerId);
            return customer;
        } catch (RecordNotFoundException rec) {
            System.err.println(rec);
            throw new CustomerNotFoundException();
        }
    }

    @Override
    public void recordCall(String customerId, Call callDetails) throws CustomerNotFoundException {
        try {
            customerDao.addCall(callDetails, customerId);
        } catch (RecordNotFoundException rec) {
            System.err.println(rec);
            throw new CustomerNotFoundException();
        }
    }
}
