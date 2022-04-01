package gui.controller;

import be.Customer;
import be.Event;
import be.Ticket;
import bll.TicketManager;
import gui.model.CustomerModel;
import gui.model.TicketListModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.Scenes.DashboardScene;
import utility.Scenes.SceneSwapper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SellTicketViewController implements Initializable {

    @FXML
    private GridPane parentPane;

    @FXML
    private Label lblPrice;

    @FXML
    private TextField txtCustomerName;
    @FXML
    private TextField txtCustomerEmail;
    @FXML
    private TextField txtCustomerTelephoneNumber;
    @FXML
    private TextField txtTelephoneCountryCode;
    @FXML
    private TextField txtSeat;
    @FXML
    private TextField txtRow;

    @FXML
    private CheckBox checkVIP;
    @FXML

    private CheckBox checkSeated;

    private Event event;
    private double price;
    private TicketManager ticketManager;
    private CustomerModel customerModel;
    private TicketListModel ticketListModel;
    private final String DEFAULT_COUNTRY_CODE_DK = "+45";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        event = new DashboardScene().getController().getSelectedEvent();
        if (event == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Something went wrong");
            alert.setHeaderText("Du skal vælge en Event først");
            alert.show();
        }
        try {
            ticketListModel = TicketListModel.getInstance();
            ticketManager = new TicketManager();
            customerModel = new CustomerModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        price = event.getPriceProperty().get();
        lblPrice.setText(price + " DKK");
        txtRow.setDisable(true);
        txtSeat.setDisable(true);

        checkVIP.setDisable(event.getVipPriceProperty().get() == 0);

    }

    public void btnSave(ActionEvent actionEvent) {

        String seat = "N/A";
        String row = "N/A";

        boolean vip = false;


        boolean isSeated = false;
        if (checkSeated.isSelected()) {
            seat = txtSeat.getText();
            row = txtRow.getText();
            isSeated = true;
        }
        if (checkVIP.isSelected())
            vip = true;


        String telephoneNumber = "";

        //if a country code is not specified, default to +45
        if (txtTelephoneCountryCode.getText().isEmpty())
            txtTelephoneCountryCode.setText(DEFAULT_COUNTRY_CODE_DK);

        // if the telephone number field is not empty or blank, set telephone number to the user input from the textfield(s)
        if (!txtCustomerTelephoneNumber.getText().isEmpty() && !txtCustomerTelephoneNumber.getText().isBlank()) {
            telephoneNumber = txtTelephoneCountryCode.getText() + " ";
            String tempPhoneNumber = txtCustomerTelephoneNumber.getText().replaceAll("\\s+", ""); //replaces white spaces and non-visible characters
            for (int i = 0; i < tempPhoneNumber.length(); i++) {
                if (i % 2 == 0)
                    telephoneNumber = telephoneNumber + " " + tempPhoneNumber.charAt(i);
                else telephoneNumber = telephoneNumber + tempPhoneNumber.charAt(i);
            }
        }

        if (checkSeated.isSelected())
            isSeated = true;

        if (!txtCustomerName.getText().isEmpty() && !txtCustomerEmail.getText().isEmpty() && !txtCustomerTelephoneNumber.getText().isEmpty()) {
            Customer customer = new Customer(txtCustomerEmail.getText(), txtCustomerName.getText(), telephoneNumber);

            Ticket ticket = new Ticket(customerModel.createCustomer(customer), event, Double.parseDouble(lblPrice.getText()), vip, isSeated);
            ticket.setRow(row);
            ticket.setSeat(seat);
            ticketListModel.addTicketToList(ticket);
            EXITScene();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You have to fill Name, E-mail and Telephone", ButtonType.OK);
            alert.show();
        }
    }


    public void vipClick(ActionEvent actionEvent) {
        if (checkVIP.isSelected()) {
            price = price + event.getVipPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        } else {
            price = price - event.getVipPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        }
    }

    public void seatedClick(ActionEvent actionEvent) {
        if (!checkSeated.isSelected()) {
            txtSeat.setDisable(true);
            txtRow.setDisable(true);
        } else {
            txtSeat.setDisable(false);
            txtRow.setDisable(false);
        }
    }

    public void EXITScene() {
        Stage stage = (Stage) parentPane.getScene().getWindow();
        stage.close();
    }

    public void handleButtonCancel(ActionEvent actionEvent) {
        EXITScene();
    }
}
