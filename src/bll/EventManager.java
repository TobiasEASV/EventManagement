package bll;

import be.Event;
import be.Ticket;
import dal.DBEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.List;

public class EventManager {

    private DBEvent dbEvent;

    public EventManager() throws IOException {
        dbEvent = new DBEvent();
    }

    public Event createEvent(Event event){
        return dbEvent.createEvent(event);
    }

    public List<Event> getAllEvents(){
        return dbEvent.getAllEvents();
    }


    public void deleteEvent(Event event) {
        dbEvent.deleteEvent(event);
    }


    public Event updateEvent(Event event) {
        return dbEvent.updateEvent(event);
    }
}
