package gui.model;

import be.Admin;
import bll.interfaces.IAdminManager;

public class AdminModel {

    private IAdminManager adminManager;

    public AdminModel(IAdminManager adminManager) {
        this.adminManager = adminManager;
    }

    public Admin checkCredential(String userName, String password){
        return adminManager.checkCredential(userName, password);
    }
}
