package bll;

import be.Event;
import dal.DBEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class EventManager {

    private DBEvent dbEvent;

    public EventManager() throws IOException {
        dbEvent = new DBEvent();
    }

    public Event createEvent(Event event){
        return dbEvent.createEvent(event);
    }

}
