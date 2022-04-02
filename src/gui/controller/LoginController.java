package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private AnchorPane APWelcome;
    @FXML
    private AnchorPane APEventCoordinatorLogin;
    @FXML
    private AnchorPane APAdminLogin;

    @FXML
    private TextField txtEventCoordinatorLoginName;
    @FXML
    private TextField txtAdminLoginName;

    @FXML
    private PasswordField PtxtEventCoordinatorPassword;
    @FXML
    private PasswordField PtxtAdminPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleEventCoordinatorLogin(ActionEvent actionEvent) {
    }

    public void handleAdminLogin(ActionEvent actionEvent) {
    }
}
