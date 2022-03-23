package gui.controller;

import be.Customer;
import be.Event;
import be.Ticket;
import bll.TicketManager;
import gui.model.CustomerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static utility.SceneSwapper.getDashboardController;

public class SellTicketViewController implements Initializable {
    @FXML
    private Label lblPrice;
    @FXML
    private TextField txtCustomerName;
    @FXML
    private TextField txtCustomerEmail;
    @FXML
    private TextField txtSeat;
    @FXML
    private TextField txtRow;
    @FXML
    private CheckBox checkVIP;
    @FXML
    private CheckBox checkFood;
    @FXML
    private CheckBox checkDrinks;
    @FXML
    private CheckBox checkSeated;
    @FXML
    private CheckBox checkHasPaid;

    private Event event;
    private double price;
    private TicketManager ticketManager;
    private CustomerModel customerModel;

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
            ticketManager = new TicketManager();
            customerModel = new CustomerModel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        price = event.getPriceProperty().get();
        lblPrice.setText(String.valueOf(price));
        txtRow.setDisable(true);
        txtSeat.setDisable(true);
    }

    public void btnSave(ActionEvent actionEvent) {


        String seat = "No Seat nr";
        String row = "No Row nr";

        boolean vip = false;
        boolean food = false;
        boolean drinks = false;
        boolean hasPaid = false;
        boolean isSeated = false;
        if (checkSeated.isSelected()) {
            seat = txtSeat.getText();
            row = txtRow.getText();
            isSeated= true;
        }
        if (checkVIP.isSelected()){
            vip = true;
        }
        if(checkFood.isSelected()){
            food = true;
        }
        if (checkDrinks.isSelected()){
            drinks = true;
        }
        if (checkHasPaid.isSelected()){
            hasPaid = true;
        }

        Customer customer = new Customer(txtCustomerEmail.getText(), txtCustomerName.getText());

        Ticket ticket = new Ticket(customerModel.createCustomer(customer), event, Double.parseDouble(lblPrice.getText()), hasPaid, vip, drinks, food, isSeated);
        ticket.setRow(row);
        ticket.setSeat(seat);
        ticketManager.createTicket(ticket);
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

    public void foodClick(ActionEvent actionEvent) {
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

    public void drinksclick(ActionEvent actionEvent) {
        if (checkDrinks.isSelected())
        {
            price = price + event.getDrinkPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        }
        else
        {
            price = price - event.getDrinkPriceProperty().get();
            lblPrice.setText(String.valueOf(price));
        }
    }

    public void seatedClick(ActionEvent actionEvent) {
        if (!checkSeated.isSelected()){
            txtSeat.setDisable(true);
            txtRow.setDisable(true);
        } else{
            txtSeat.setDisable(false);
            txtRow.setDisable(false);
        }
    }


}
