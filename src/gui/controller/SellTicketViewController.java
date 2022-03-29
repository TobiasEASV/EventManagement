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
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static utility.SceneSwapper.getDashboardController;

public class SellTicketViewController implements Initializable {

    @FXML
    private  GridPane parentPane;

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
        EventCoordinatorDashboardController dashboardController = getDashboardController();
        event = dashboardController.getSelectedEvent();
        if(event == null){
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
        lblPrice.setText(String.valueOf(price));
        txtRow.setDisable(true);
        txtSeat.setDisable(true);

        checkVIP.setDisable(event.getVipPriceProperty().get() == 0);
        checkFood.setDisable(event.getFoodPriceProperty().get() == 0);
        checkDrinks.setDisable(event.getDrinkPriceProperty().get() == 0);
    }

    public void btnSave(ActionEvent actionEvent) {
        String seat = "No Seat nr";
        String row = "No Row nr";

        boolean vip = false;
        boolean food = false;
        boolean drinks = false;

        boolean isSeated = false;
        if (checkSeated.isSelected()) {
            seat = txtSeat.getText();
            row = txtRow.getText();
            isSeated= true;
        }
        if (checkVIP.isSelected()){
            vip = true;
<<<<<<< Updated upstream
        }
        if(checkFood.isSelected()){
            food = true;
        }
        if (checkDrinks.isSelected()){
            drinks = true;
        }

        String telephoneNumber = "";

        //if a country code is not specified, default to +45
        if (txtTelephoneCountryCode.getText().isEmpty())
            txtTelephoneCountryCode.setText(DEFAULT_COUNTRY_CODE_DK);

        // if the telephone number field is not empty or blank, set telephone number to the user input from the textfield(s)
        if (!txtCustomerTelephoneNumber.getText().isEmpty() && !txtCustomerTelephoneNumber.getText().isBlank()){
            telephoneNumber = txtTelephoneCountryCode.getText() + " ";
            String tempPhoneNumber = txtCustomerTelephoneNumber.getText().replaceAll("\\s+",""); //replaces white spaces and non-visible characters
            for (int i = 0; i < tempPhoneNumber.length(); i++) {
                if (i % 2 == 0)
                    telephoneNumber = telephoneNumber + " " + tempPhoneNumber.charAt(i);
                else telephoneNumber = telephoneNumber + tempPhoneNumber.charAt(i);
            }
        }
=======

        if (checkHasPaid.isSelected())
            hasPaid = true;
        if (checkSeated.isSelected())
            isSeated= true;
>>>>>>> Stashed changes


<<<<<<< Updated upstream

        Customer customer = new Customer(txtCustomerEmail.getText(), txtCustomerName.getText(), telephoneNumber);

        Ticket ticket = new Ticket(customerModel.createCustomer(customer), event, Double.parseDouble(lblPrice.getText()), vip, drinks, food, isSeated);
        ticket.setRow(row);
        ticket.setSeat(seat);
        ticketListModel.addTicketToList(ticket);
        EXITScene();
=======
        Ticket ticket = new Ticket(customer,seat, row,Integer.parseInt(lblPrice.getText()), hasPaid, vip, isSeated);
>>>>>>> Stashed changes
    }

    public void vipClick(ActionEvent actionEvent) {
        if (checkVIP.isSelected())
        {
            price = price + event.getVipPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        }
        else
        {
            price = price - event.getVipPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        }

    }

<<<<<<< Updated upstream
    public void foodClick(ActionEvent actionEvent) {
        System.out.println(event.getFoodPriceProperty().get());
        if (checkFood.isSelected())
        {
            price = price + event.getFoodPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        }
        else
        {
            price = price - event.getFoodPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        }
    }
=======
>>>>>>> Stashed changes


    public void seatedClick(ActionEvent actionEvent) {
        if (!checkSeated.isSelected()){
            txtSeat.setDisable(true);
            txtRow.setDisable(true);
        } else{
            txtSeat.setDisable(false);
            txtRow.setDisable(false);
        }
    }

    public void EXITScene(){
        Stage stage = (Stage) parentPane.getScene().getWindow();
        stage.close();
    }

    public void handleButtonCancel(ActionEvent actionEvent) {
        EXITScene();
    }
}
