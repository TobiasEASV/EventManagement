package gui.controller;

import be.Event;
import be.EventCoordinator;
import gui.model.EventCoordinatorModel;
import gui.model.EventListModel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashboardController implements Initializable {

    @FXML
    private TableView<Event> tvEvents;
    @FXML
    private TableColumn<Event, String> tcEventName;
    @FXML
    private TableView<EventCoordinator> tvEventCoordinator;
    @FXML
    private TableColumn<EventCoordinator, String> tcUserName;

    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;

    private EventListModel eventListModel;
    private EventCoordinatorModel eventCoordinatorModel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Platform.runLater(() -> {


        //Set placeholder for tableview if it is empty
        tvEvents.setPlaceholder(new Label("No events found in Database."));
        tvEvents.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tvEvents.setItems(eventListModel.getEventList());
        tcEventName.setCellValueFactory(event -> event.getValue().getTitleProperty());

        tvEventCoordinator.setPlaceholder(new Label("No EventCoordinator found in Database."));
        tvEventCoordinator.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tvEventCoordinator.setItems(eventCoordinatorModel.getAllEventCoordinators());
        tcUserName.setCellValueFactory(eventCoordinator -> eventCoordinator.getValue().getFullNameProperty());
        });
    }

    public void setEventListModel(EventListModel eventListModel){
        this.eventListModel = eventListModel;
    }

    public void setEventCoordinatorModel(EventCoordinatorModel eventCoordinatorModel) {
        this.eventCoordinatorModel = eventCoordinatorModel;
    }

    @FXML
    private void handleDeleteEvent(ActionEvent actionEvent) {
        eventListModel.deleteEventFromList(getSelectedEvent());
    }

    @FXML
    private void handleCreateUser(ActionEvent actionEvent) {
        eventCoordinatorModel.createEventCoordinator(new EventCoordinator(txtFullName.getText(), txtUserName.getText(), txtPassword.getText()));
        txtFullName.clear();
        txtPassword.clear();
        txtUserName.clear();
    }

    @FXML
    private void handleDeleteUser(ActionEvent actionEvent) {
        eventCoordinatorModel.deleteEventCoordinator(getSelectedEventCoordinator());
    }

    public Event getSelectedEvent(){
        return tvEvents.getSelectionModel().getSelectedItem();
    }

    public EventCoordinator getSelectedEventCoordinator(){
        return tvEventCoordinator.getSelectionModel().getSelectedItem();
    }
}
