package gui.controller;

import be.Event;


import gui.model.EventListModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class CreateEventController implements Initializable {

    @FXML
    private ComboBox<String> comboBoxStartTime;
    @FXML
    private ComboBox<String> comboBoxEndTime;
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

    private EventListModel eventListModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private List<String> getTimes() {
        List<String> timeList = new ArrayList<>();
        String time;
        for (int hour = 0; hour < 10; hour++) {
            for (int minutes = 0; minutes < 60; minutes += 15) {
                if (minutes == 0) {
                    time = "0" + hour + ":" + minutes +"0";
                }
                else {
                    time = "0" + hour + ":" + minutes;}
                timeList.add(time);
            }
        }
        for (int hour = 10; hour < 24; hour++) {
            for (int minutes = 0; minutes < 60; minutes += 15) {
                if (minutes == 0) {
                    time = hour + ":" + minutes +"0";
                }
                else {
                time = hour + ":" + minutes;}
                timeList.add(time);
            }
        }
        return timeList;
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
                    dpEndData.getValue(), true);

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
