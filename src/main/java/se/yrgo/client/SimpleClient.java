package se.yrgo.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import se.yrgo.domain.Customer;
import se.yrgo.services.customers.CustomerManagementService;

import java.util.*;

public class SimpleClient {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        CustomerManagementService service = container.getBean("CustomerManagementService",
            CustomerManagementService.class);
        
        List<Customer> customer = service.getAllCustomers();
        for (Customer c : customer) {
            System.out.println(c.toString());
        }

        container.close();
    }
}