package gui.controller;

import be.EventCoordinator;
import bll.util.PDFConverter;
import gui.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utility.EmailClient;
import utility.Scenes.AdminDashboardScene;
import utility.Scenes.EventCoordinatorDashboardScene;
import utility.Scenes.interfaces.ILoadScene;

import java.io.IOException;
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
    private TextField txtAdminLogin;

    @FXML
    private PasswordField PtxtEventCoordinatorPassword;
    @FXML
    private PasswordField PtxtAdminPassword;

    private CustomerModel customerModel;
    private EventListModel eventListModel;
    private EmailClient emailClient;
    private TicketListModel ticketListModel;
    private PrintModel printModel;
    private EventCoordinatorModel eventCoordinatorModel;
    private AdminModel adminModel;
    private Stage primaryStage;
    private PDFConverter pdfConverter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        APAdminLogin.setDisable(true);
        APAdminLogin.setVisible(false);
        APEventCoordinatorLogin.setDisable(true);
        APEventCoordinatorLogin.setVisible(false);
    }

    public void setPdfConverter(PDFConverter pdfConverter){
        this.pdfConverter = pdfConverter;
    }

    public void setCustomerModel(CustomerModel customerModel){
        this.customerModel = customerModel;
    }

    public void setTicketListModel(TicketListModel ticketListModel){
        this.ticketListModel = ticketListModel;
    }

    public void setEventListModel(EventListModel eventListModel){
        this.eventListModel = eventListModel;
    }

    public void setEmailClient(EmailClient emailClient){
        this.emailClient = emailClient;
    }

    public void setPrintModel(PrintModel printModel){
        this.printModel = printModel;
    }

    public void setEventCoordinatorModel(EventCoordinatorModel eventCoordinatorModel) {
        this.eventCoordinatorModel = eventCoordinatorModel;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public void setPrimaryStage(Stage stage){
        this.primaryStage = stage;
    }


    @FXML
    private void handleEventCoordinatorLogin(ActionEvent actionEvent) throws IOException {
        EventCoordinator eventCoordinator = eventCoordinatorModel.checkCredential(txtEventCoordinatorLoginName.getText(), PtxtEventCoordinatorPassword.getText());
        if( eventCoordinator != null){
            ILoadScene<EventCoordinatorDashboardController> dashboardScene =  new EventCoordinatorDashboardScene();
            dashboardScene.loadNewScene(this.primaryStage);
            EventCoordinatorDashboardController dashboardSceneController = dashboardScene.getController();
            dashboardSceneController.setController(dashboardSceneController);
            dashboardSceneController.setEventListModel(eventListModel);
            dashboardSceneController.setEmailClient(emailClient);
            dashboardSceneController.setCustomerModel(customerModel);
            dashboardSceneController.setTicketListModel(ticketListModel);
            dashboardSceneController.setEventCoordinatorModel(eventCoordinatorModel);
            dashboardSceneController.setPrintModel(printModel);
            dashboardSceneController.setPdfConverter(new PDFConverter());

            eventCoordinatorModel.setWhoIsLogin(eventCoordinator);
        }
    }

    @FXML
    private void handleAdminLogin(ActionEvent actionEvent) throws IOException {
        if(adminModel.checkCredential(txtAdminLogin.getText(), PtxtAdminPassword.getText()) != null){
            ILoadScene<AdminDashboardController> adminDashboardScene =  new AdminDashboardScene();
            adminDashboardScene.loadNewScene(this.primaryStage);
            AdminDashboardController adminDashboardController = adminDashboardScene.getController();
            adminDashboardController.setEventCoordinatorModel(eventCoordinatorModel);
            adminDashboardController.setEventListModel(eventListModel);
        }
    }

    @FXML
    private void handelSetEventCoordinatorLogin(ActionEvent actionEvent) {
        APWelcome.setDisable(true);
        APWelcome.setVisible(false);
        APEventCoordinatorLogin.setDisable(false);
        APEventCoordinatorLogin.setVisible(true);
        APAdminLogin.setDisable(true);
        APAdminLogin.setVisible(false);
    }

    @FXML
    private void handelSetAdminLogin(ActionEvent actionEvent) {
        APWelcome.setDisable(true);
        APWelcome.setVisible(false);
        APEventCoordinatorLogin.setDisable(true);
        APEventCoordinatorLogin.setVisible(false);
        APAdminLogin.setDisable(false);
        APAdminLogin.setVisible(true);

    }



}
