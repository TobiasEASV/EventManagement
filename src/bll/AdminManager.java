package bll;

import be.Admin;
import bll.interfaces.IAdminManager;
import dal.interfaces.IDatabaseFacade;
import javafx.scene.control.Alert;

public class AdminManager implements IAdminManager {

    private IDatabaseFacade databaseFacade;

    public AdminManager(IDatabaseFacade databaseFacade) {
        this.databaseFacade = databaseFacade;
    }

    @Override
    public Admin checkCredential(String userName, String password) {
        Admin admin = databaseFacade.checkCredentialForAdmin(userName, password);
        if(admin != null ){
            return admin;
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setContentText("username or password is wrong");
            alert.showAndWait();
        }
    return null;
    }

}
