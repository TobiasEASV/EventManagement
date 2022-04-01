package dal.interfaces;

import be.Email;


public interface IDBEmailDAO {

    public Email getCredentials();

    public void setCredentials(String email, String password);
}
