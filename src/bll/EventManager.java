package bll;

import be.Event;
import dal.DBEventDAO;

import java.io.IOException;
import java.util.List;

public class EventManager {

    private DBEventDAO dbEventDAO;

    public EventManager() throws IOException {
        dbEventDAO = new DBEventDAO();
    }

    public Event createEvent(Event event){
        return dbEventDAO.createEvent(event);
    }

    public List<Event> getAllEvents(){
        return dbEventDAO.getAllEvents();
    }


    public void deleteEvent(Event event) {
        dbEventDAO.deleteEvent(event);
    }


    public Event updateEvent(Event event) {
        return dbEventDAO.updateEvent(event);
    }
}
