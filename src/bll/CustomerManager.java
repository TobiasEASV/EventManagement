package bll;

import be.Customer;
import bll.interfaces.ICustomerManager;
import dal.interfaces.IDatabaseFacade;

public class CustomerManager implements ICustomerManager {


    private IDatabaseFacade iDatabaseFacade;

    public CustomerManager(IDatabaseFacade iDatabaseFacade) {
        this.iDatabaseFacade = iDatabaseFacade;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return iDatabaseFacade.createCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer){
        iDatabaseFacade.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer){
        iDatabaseFacade.deleteCustomer(customer);
    }

    @Override
    public void getCustomer(Customer customer) {
        iDatabaseFacade.getCustomer(customer);
    }

}
