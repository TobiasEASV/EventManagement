package gui.controller;

import be.Event;
import bll.EventManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static utility.SceneSwapper.getDashboardController;

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
    private TextField txDrinkPrice;
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
    private TextField txFoodPrice;

    private EventManager eventManager;

    private Event eventToEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            eventManager = new EventManager();
            EventCoordinatorDashboardController dashboardController = getDashboardController();
            eventToEdit = dashboardController.getSelectedEvent();
            txTitle.setText(eventToEdit.getTitleProperty().get());
            txtAreaDescription.setText(eventToEdit.getDescriptionProperty().get());
            txLocation.setText(eventToEdit.getLocationProperty().get());
            txArtists.setText(eventToEdit.getArtistsProperty().get());
            txContactEmail.setText(eventToEdit.getContactEmailProperty().get());
            txTicktePrice.setText(String.valueOf(eventToEdit.getPriceProperty().get()));
            txVIPPrice.setText(String.valueOf(eventToEdit.getVipPriceProperty().get()));
            txFoodPrice.setText(String.valueOf(eventToEdit.getFoodPriceProperty().get()));
            txDrinkPrice.setText(String.valueOf(eventToEdit.getDrinkPriceProperty().get()));

            dpStartData.setValue(eventToEdit.getStartDateProperty().getValue());
            dpEndData.setValue(eventToEdit.getEndDateProperty().getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleButtonOK(ActionEvent actionEvent) {
        EventCoordinatorDashboardController dashboardController = getDashboardController();
        if(!txTitle.getText().isBlank() && !txtAreaDescription.getText().isBlank() && !txLocation.getText().isBlank()
                && !txArtists.getText().isBlank() && !txContactEmail.getText().isBlank() && !(dpStartData.getValue() == null) && !(dpEndData.getValue() == null)){

            eventToEdit.setTitle(txTitle.getText());
            eventToEdit.setDescription(txtAreaDescription.getText());
            eventToEdit.setLocation(txLocation.getText());
            eventToEdit.setArtists(txArtists.getText());
            eventToEdit.setContactEmail(txContactEmail.getText());
            eventToEdit.setPrice(Double.parseDouble(txTicktePrice.getText()));
            eventToEdit.setVipPrice(Double.parseDouble(txVIPPrice.getText()));
            eventToEdit.setFoodPrice(Double.parseDouble(txFoodPrice.getText()));
            eventToEdit.setDrinkPrice(Double.parseDouble(txDrinkPrice.getText()));
            eventToEdit.setStartDate(dpStartData.getValue());
                    eventToEdit.setEndDate(dpEndData.getValue());

            eventManager.updateEvent(eventToEdit);
            dashboardController.updateComboBoxView();
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
