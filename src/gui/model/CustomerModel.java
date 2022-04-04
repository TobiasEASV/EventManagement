package gui.model;

import be.Customer;
import bll.CustomerManager;
import bll.interfaces.ICustomerManager;

import java.io.IOException;

public class CustomerModel {
    private ICustomerManager customerManager;

    public CustomerModel(ICustomerManager customerManager) throws IOException {
        this.customerManager = customerManager;
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
