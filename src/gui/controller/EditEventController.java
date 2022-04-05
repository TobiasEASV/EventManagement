package gui.controller;

import be.Event;
import gui.model.EventListModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditEventController implements Initializable {

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

    @FXML
    private ComboBox<String> comboboxStartTime;
    @FXML
    private ComboBox<String> comboboxEndTime;

    private EventListModel eventListModel;
    private EventCoordinatorDashboardController dashboardController;
    private Event eventToEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {
            eventToEdit = dashboardController.getSelectedEvent();

            txTitle.setText(eventToEdit.getTitleProperty().get());
            txtAreaDescription.setText(eventToEdit.getDescriptionProperty().get());
            txLocation.setText(eventToEdit.getLocationProperty().get());
            txArtists.setText(eventToEdit.getArtistsProperty().get());
            txContactEmail.setText(eventToEdit.getContactEmailProperty().get());
            txTicktePrice.setText(String.valueOf(eventToEdit.getPriceProperty().get()));
            txVIPPrice.setText(String.valueOf(eventToEdit.getVipPriceProperty().get()));
            dpStartData.setValue(eventToEdit.getStartDateProperty().getValue().toLocalDate());
            dpEndData.setValue(eventToEdit.getEndDateProperty().getValue().toLocalDate());
            comboboxStartTime.setValue(eventToEdit.getStartDateProperty().getValue().toLocalTime().toString());
            comboboxEndTime.setValue(eventToEdit.getEndDateProperty().getValue().toLocalTime().toString());

            comboboxStartTime.getItems().addAll(getTimes());
            comboboxEndTime.getItems().addAll(getTimes());
        });

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

    public void setController(EventCoordinatorDashboardController dashboardController) {
        this.dashboardController = dashboardController;
    }

    public void setEventListModel(EventListModel eventListModel){
        this.eventListModel = eventListModel;
    }

    public void handleButtonOK(ActionEvent actionEvent) {
        if(!txTitle.getText().isBlank() && !txtAreaDescription.getText().isBlank() && !txLocation.getText().isBlank()
                && !txArtists.getText().isBlank() && !txContactEmail.getText().isBlank() && !(dpStartData.getValue() == null) && !(dpEndData.getValue() == null)){

            LocalTime startClock = LocalTime.parse(comboboxStartTime.getSelectionModel().getSelectedItem());
            LocalTime endClock = LocalTime.parse(comboboxEndTime.getSelectionModel().getSelectedItem());
            LocalDateTime startTime = LocalDateTime.of(dpStartData.getValue(),startClock);
            LocalDateTime endTime = LocalDateTime.of(dpEndData.getValue(),endClock);

            eventToEdit.setTitle(txTitle.getText());
            eventToEdit.setDescription(txtAreaDescription.getText());
            eventToEdit.setLocation(txLocation.getText());
            eventToEdit.setArtists(txArtists.getText());
            eventToEdit.setContactEmail(txContactEmail.getText());
            eventToEdit.setPrice(Double.parseDouble(txTicktePrice.getText()));
            eventToEdit.setVipPrice(Double.parseDouble(txVIPPrice.getText()));
            eventToEdit.setStartDate(startTime);
            eventToEdit.setEndDate(endTime);
            eventListModel.updateEvent(eventToEdit);
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
