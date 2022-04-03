package gui.controller;

import be.Event;
import gui.model.EventListModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
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

            dpStartData.setValue(eventToEdit.getStartDateProperty().getValue());
            dpEndData.setValue(eventToEdit.getEndDateProperty().getValue());
        });

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

            eventToEdit.setTitle(txTitle.getText());
            eventToEdit.setDescription(txtAreaDescription.getText());
            eventToEdit.setLocation(txLocation.getText());
            eventToEdit.setArtists(txArtists.getText());
            eventToEdit.setContactEmail(txContactEmail.getText());
            eventToEdit.setPrice(Double.parseDouble(txTicktePrice.getText()));
            eventToEdit.setVipPrice(Double.parseDouble(txVIPPrice.getText()));
            eventToEdit.setStartDate(dpStartData.getValue());
            eventToEdit.setEndDate(dpEndData.getValue());

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
