package dal;

import be.Customer;
import be.Event;
import be.Ticket;

import java.util.HashMap;
import java.util.List;

public interface IDatabaseFacade {

    /**
     *Customer responsible.
     */
    public Customer createCustomer(Customer customer);

    public Customer getCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);


    /**
     * Email responsible
     */
    public HashMap<String,String> getCredentials();

    public void setCredentials(String email, String password);

    /**
     * Event responsible
     */
    public Event createEvent(Event event);

    public List<Event> getAllEvents();

    public void deleteEvent(Event event);

    public Event updateEvent(Event event);

    /**
     *Ticket responsible.
     */
    public Ticket createTicket(Ticket ticket);

    public Ticket updateTicket(Ticket ticket);

    public void deleteTicket(Ticket ticket);

    public List<Ticket> getTicketsFromEvent(Event event);

    public boolean foundTicketID(String id);
}
