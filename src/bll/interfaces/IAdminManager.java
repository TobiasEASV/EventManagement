package bll.interfaces;

import be.Admin;

public interface IAdminManager {

    public Admin checkCredential(String userName, String password);
}
