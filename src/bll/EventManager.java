package bll;

import be.Event;
import bll.interfaces.IEventManager;
import dal.DBEventDAO;
import dal.IDatabaseFacade;

import java.io.IOException;
import java.util.List;

public class EventManager implements IEventManager {

    private IDatabaseFacade iDatabaseFacade;

    public EventManager(IDatabaseFacade iDatabaseFacade){
        this.iDatabaseFacade = iDatabaseFacade;
    }

    public Event createEvent(Event event){
        return iDatabaseFacade.createEvent(event);
    }

    public List<Event> getAllEvents(){
        return iDatabaseFacade.getAllEvents();
    }


    public void deleteEvent(Event event) {
        iDatabaseFacade.deleteEvent(event);
    }

    public Event updateEvent(Event event) {
        return iDatabaseFacade.updateEvent(event);
    }
}
