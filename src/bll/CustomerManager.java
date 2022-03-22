package bll;

import be.Customer;
import dal.DBCustomer;

import java.io.IOException;

public class CustomerManager {
    private DBCustomer dbCustomer;
    public CustomerManager() throws IOException {
        dbCustomer = new DBCustomer();
    }
    public void createCustomer(Customer customer)
    {
        dbCustomer.createCustomer(customer);
    }

}
