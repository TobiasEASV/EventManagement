package bll;

import be.Admin;
import bll.interfaces.IAdminManager;
import dal.interfaces.IDBAdminDAO;
import dal.interfaces.IDatabaseFacade;

public class AdminManager implements IAdminManager {

    private IDatabaseFacade databaseFacade;

    public AdminManager(IDatabaseFacade databaseFacade) {
        this.databaseFacade = databaseFacade;
    }

    @Override
    public Admin checkCredential(String userName, String password) {
        return databaseFacade.checkCredentialForAdmin(userName, password);
    }
}
