package gui.controller;

import gui.model.PrintModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventCoordinatorDashboardController implements Initializable {
    @FXML
    private GridPane parentGridPane;

    @FXML
    private TableColumn tcName;
    @FXML
    private TableColumn tcTicketPrice;
    @FXML
    private TableColumn tcPaymentStatus;

    @FXML
    private TextField textFieldSearch;
    @FXML
    private TextField txtAlternativeEmail;

    @FXML
    private ComboBox comboBoxChoosePrinter;
    @FXML
    private ComboBox comboBoxChooseEvent;

    @FXML
    private CheckBox checkBoxTicketTypeStandard;
    @FXML
    private CheckBox checkBoxTicketTypeVIP;
    @FXML
    private CheckBox checkBoxTicketTypeFoodIncl;
    @FXML
    private CheckBox checkBoxTicketTypeDrinksIncl;

    @FXML
    private Label txtEventTitle;
    @FXML
    private Label txtEventLocation;
    @FXML
    private Label txtEventDescription;
    @FXML
    private Label txtEventArtists;
    @FXML
    private Label txtEventStartDate;
    @FXML
    private Label txtEventEndDate;
    @FXML
    private Label txtEventPrice;
    @FXML
    private Label txtEventContactEmail;

    @FXML
    private Label txtTicketTitle;
    @FXML
    private Label txtTicketName;
    @FXML
    private Label txtTicketEmail;
    @FXML
    private Label txtTicketStartDate;
    @FXML
    private Label txtTicketEndDate;
    @FXML
    private Label txtTicketPrice;
    @FXML
    private Label txtTicketType;

    //Array that holds printservices available on the PC.
    private PrintService[] printServices;

    //gui.model.PrintModel for printing tickets (a singleton)
    PrintModel printModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //instantiate the singleton PrintModel
        printModel = PrintModel.getInstance();

        //Get print services
        printServices = PrintServiceLookup.lookupPrintServices(null, null);
        //Add print services to choose printer drop-down
        comboBoxChoosePrinter.getItems().setAll(printServices);
    }

    public void handleSellTicketButton(ActionEvent actionEvent) {
    }

    public void handleRefundTicketButton(ActionEvent actionEvent) {
    }

    public void handlePrintTicketButton(ActionEvent actionEvent) throws IOException, PrintException {
        FileInputStream fin = new FileInputStream("src/gui/images/Icons/ticket_2_icon.png");
        printModel.print((PrintService) comboBoxChoosePrinter.getSelectionModel().getSelectedItem(), fin);
    }

    public void handleMailTicketButton(ActionEvent actionEvent) {
    }

    public void handleEditEventButton(ActionEvent actionEvent) {
    }

    public void handleNewEventButton(ActionEvent actionEvent) {
    }

    public void handleLogoutButton(ActionEvent actionEvent) {
    }

    public void handleUserSettingsButton(ActionEvent actionEvent) {
    }
}
