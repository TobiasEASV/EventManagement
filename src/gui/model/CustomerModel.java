package gui.model;

import be.Customer;
import bll.CustomerManager;
import dal.DBCustomer;

import java.io.IOException;

public class CustomerModel {
    private CustomerManager customerManager;

    public CustomerModel() throws IOException {
        customerManager = new CustomerManager();
    }

    public void createCustomer(Customer customer){
        customerManager.createCustomer(customer);
    }
}
