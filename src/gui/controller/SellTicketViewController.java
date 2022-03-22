package gui.controller;

import be.Customer;
import be.Event;
import be.Ticket;
import gui.model.CustomerModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    private CustomerModel customerModel;

    public SellTicketViewController(Event event) throws IOException {
     this.event = event;
     customerModel = new CustomerModel();
    }

    public void btnSave(ActionEvent actionEvent) {
        int seat = 0;
        int row = 0;

        boolean vip = false;
        boolean food = false;
        boolean drinks = false;
        boolean hasPaid = false;
        boolean isSeated = false;
        if (checkSeated.isSelected()) {
            seat = Integer.parseInt(txtSeat.getText());
            row = Integer.parseInt(txtRow.getText());
        }
        if (checkVIP.isSelected())
            vip = true;
        if(checkFood.isSelected())
            food = true;
        if (checkDrinks.isSelected())
            drinks = true;
        if (checkHasPaid.isSelected())
            hasPaid = true;
        if (checkSeated.isSelected())
            isSeated= true;

        Customer customer = new Customer(txtCustomerEmail.getText(), txtCustomerName.getText());
        customerModel.createCustomer(customer);

        Ticket ticket = new Ticket(customer,seat, row,Integer.parseInt(lblPrice.getText()), hasPaid, vip,drinks,food, isSeated);
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
        //Hvis vi vil gemme og fjerne muligheden for at indtaste seat og rows.
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        price = event.getPriceProperty().get();
        lblPrice.setText(String.valueOf(price));
    }
}
