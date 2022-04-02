package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private TableView tvEvents;
    @FXML
    private TableColumn tcEventName;
    @FXML
    private TableView tvEventCoordinator;
    @FXML
    private TableColumn tcUserName;

    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void handleDeleteEvent(ActionEvent actionEvent) {
    }

    @FXML
    private void handleCreateUser(ActionEvent actionEvent) {
    }

    @FXML
    private void handleDeleteUser(ActionEvent actionEvent) {
    }
}
