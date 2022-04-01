package dal.interfaces;

import java.util.HashMap;

public interface IDBEmailDAO {

    public HashMap<String,String> getCredentials();

    public void setCredentials(String email, String password);
}
