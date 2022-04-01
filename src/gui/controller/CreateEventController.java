package gui.controller;

import be.Event;
import bll.EventManager;


import gui.model.EventListModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.Scenes.DashboardScene;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CreateEventController implements Initializable {

    @FXML
    private TextArea txtAreaDescription;
    @FXML
    private GridPane parentGridPane;
    @FXML
    private DatePicker dpStartData;
    @FXML
    private DatePicker dpEndData;
    @FXML
    private TextField txTitle;
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

    private EventCoordinatorDashboardController dashboardController;
    private EventListModel eventListModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setController(EventCoordinatorDashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    public void setEventListModel(EventListModel eventListModel) {
        this.eventListModel = eventListModel;
    }

    public void handleButtonOK(ActionEvent actionEvent) {
        if(!txTitle.getText().isBlank() && !txtAreaDescription.getText().isBlank() && !txLocation.getText().isBlank()
                && !txArtists.getText().isBlank() && !txContactEmail.getText().isBlank() && !(dpStartData.getValue() == null) && !(dpEndData.getValue() == null)){

            String ticketPrice = "0", VIPPrice = "0";
            if (!txTicktePrice.getText().isEmpty())
                ticketPrice = txTicktePrice.getText();
            if (!txVIPPrice.getText().isEmpty())
                VIPPrice = txVIPPrice.getText();


            Event event = new Event(
                    txTitle.getText(),
                    txtAreaDescription.getText(),
                    txLocation.getText(),
                    txArtists.getText(),
                    txContactEmail.getText(),
                    Double.parseDouble(ticketPrice),
                    Double.parseDouble(VIPPrice),
                    dpStartData.getValue(),
                    dpEndData.getValue());

            eventListModel.createEvent(event);
            EXITScene();

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error: Something went wrong");
            alert.setHeaderText("BLBLBLBLBLBLBLBLB");
            alert.show();
        }
    }

    public void handleButtonCancel(ActionEvent actionEvent) {
        EXITScene();
    }

    public void EXITScene(){
        Stage stage = (Stage) parentGridPane.getScene().getWindow();
        stage.close();
    }
}
