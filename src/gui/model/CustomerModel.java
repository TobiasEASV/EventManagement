package gui.model;

import be.Customer;
import bll.CustomerManager;

import java.io.IOException;

public class CustomerModel {
    private CustomerManager customerManager;

    public CustomerModel() throws IOException {
        customerManager = new CustomerManager();
    }

    public Customer createCustomer(Customer customer){
        return customerManager.createCustomer(customer);
    }

    public void updateCustomer(Customer customer)
    {
        customerManager.updateCustomer(customer);
    }

    public void deleteCustomer(Customer customer)
    {
        customerManager.deleteCustomer(customer);
    }
    public void getCustomer(Customer customer)
    {
        customerManager.getCustomer(customer);
    }
}
