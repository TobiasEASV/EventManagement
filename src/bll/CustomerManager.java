package bll;

import be.Customer;
import dal.DBCustomer;

import java.io.IOException;

public class CustomerManager {
    private DBCustomer dbCustomer;
    public CustomerManager() throws IOException {
        dbCustomer = new DBCustomer();
    }
    public Customer createCustomer(Customer customer) {
        return dbCustomer.createCustomer(customer);
    }

    public void updateCustomer(Customer customer)
    {
        dbCustomer.updateCustomer(customer);
    }

    public void deleteCustomer(Customer customer)
    {
        dbCustomer.deleteCustomer(customer);
    }
    public void getCustomer(Customer customer)
    {
        dbCustomer.getCustomer(customer);
    }

}
