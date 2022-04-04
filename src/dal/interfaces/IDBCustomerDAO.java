package dal.interfaces;

import be.Customer;

public interface IDBCustomerDAO {

    public Customer createCustomer(Customer customer);

    public Customer getCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);
}
