package gui.model;

import be.Event;
import be.Ticket;
import bll.EventManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventListModel {

    private ObservableList<Event> eventList = FXCollections.observableArrayList();
    private EventManager eventManager;


    public EventListModel() throws IOException {
        eventManager = new EventManager();

        eventList.addAll(eventManager.getAllEvents());
    }

    public ObservableList<Event> getEventList(){
        return eventList;
    }

    public void deleteEventFromList(Event event){
        eventManager.deleteEvent(event);
        eventList.remove(event);
    }
    public void setEventInactive(Event event)
    {
        eventManager.updateEvent(event);

    }


}
