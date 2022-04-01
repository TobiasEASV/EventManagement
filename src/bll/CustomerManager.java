package bll;

import be.Customer;
import dal.DBCustomerDAO;

import java.io.IOException;

public class CustomerManager {
    private DBCustomerDAO dbCustomerDAO;
    public CustomerManager() throws IOException {
        dbCustomerDAO = new DBCustomerDAO();
    }
    public Customer createCustomer(Customer customer) {
        return dbCustomerDAO.createCustomer(customer);
    }

    public void updateCustomer(Customer customer)
    {
        dbCustomerDAO.updateCustomer(customer);
    }

    public void deleteCustomer(Customer customer)
    {
        dbCustomerDAO.deleteCustomer(customer);
    }
    public void getCustomer(Customer customer)
    {
        dbCustomerDAO.getCustomer(customer);
    }

}
