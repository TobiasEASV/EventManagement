package gui.model;

import be.Event;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class EventListModel {

    private ObservableList<Event> eventList = FXCollections.observableArrayList();


    public ObservableList<Event> getEventList(){
        return eventList;
    }
}
