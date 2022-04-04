package dal.interfaces;

import be.Admin;

public interface IDBAdminDAO {

    public Admin checkCredential(String userName, String password);
}
