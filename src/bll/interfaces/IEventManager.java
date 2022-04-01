package bll.interfaces;

import be.Event;

import java.util.List;

public interface IEventManager {

    public Event createEvent(Event event);

    public List<Event> getAllEvents();

    public void deleteEvent(Event event);

    public Event updateEvent(Event event);
}
