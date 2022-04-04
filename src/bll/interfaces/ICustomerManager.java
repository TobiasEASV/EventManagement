package bll.interfaces;

import be.Customer;

public interface ICustomerManager {

    public Customer createCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);

    public void getCustomer(Customer customer);
}
