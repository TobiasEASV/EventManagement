package gui.controller;

import be.Event;
import bll.EventManager;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.SceneSwapper;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateEventConstoller implements Initializable {

    @FXML
    private GridPane PerentGridPane;
    @FXML
    private DatePicker dpStartData;
    @FXML
    private DatePicker dpEndData;
    @FXML
    private TextField txDrinkPrice;
    @FXML
    private TextField txTitle;
    @FXML
    private TextField txDescription;
    @FXML
    private TextField txLocation;
    @FXML
    private TextField txArtists;
    @FXML
    private TextField txContactEmail;
    @FXML
    private TextField txTicktePrice;
    @FXML
    private TextField txVIPPrice;
    @FXML
    private TextField txFoodPrice;

    private Event event;
    private EventManager eventManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            eventManager = new EventManager();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleButtonOK(ActionEvent actionEvent) {
        double ticketPrice = 0.0;
        double VIPPrice = 0.0;
        double foodPrice = 0.0;
        double drinkPrice = 0.0;
        if(txVIPPrice.getText().equals("0") || txVIPPrice.getText().isEmpty()){

        }
        System.out.println(dpStartData.getValue());
        event = new Event(
                txTitle.getText(),
                txDescription.getText(),
                txLocation.getText(),
                txArtists.getText(),
                txContactEmail.getText(),
                Double.parseDouble(txTicktePrice.getText()),
                Double.parseDouble(txVIPPrice.getText()),
                Double.parseDouble(txFoodPrice.getText()),
                Double.parseDouble(txDrinkPrice.getText()),
                dpStartData.getValue(),
                dpEndData.getValue());
        EventCoordinatorDashboardController dashboardController = new SceneSwapper().getDashboardController();
        dashboardController.updateComboBoxChooseEvent(event);
        //dashboardController.updateComboBoxChooseEvent(eventManager.createEvent(event));

    }

    public void handleButtonCansel(ActionEvent actionEvent) {
        Stage stage = (Stage) PerentGridPane.getScene().getWindow();
        stage.close();
    }
}
