package dal;

import be.Customer;
import be.Event;
import be.Ticket;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;

public class DatabaseFacade implements IDatabaseFacade {

    private final IDBTicketDAO DBTicketDAO;
    private final IDBEventDAO DBEventDAO;
    private final IDBCustomerDAO DBCustomerDAO;
    private final IDBEmailDAO DBEmailDAO;
    private final Connection connection;

    public DatabaseFacade(IDBTicketDAO DBTicketDAO, IDBEventDAO DBEventDAO, IDBCustomerDAO DBCustomerDAO, IDBEmailDAO DBEmailDAO, Connection connection){
        this.DBTicketDAO = DBTicketDAO;
        this.DBEventDAO = DBEventDAO;
        this.DBCustomerDAO = DBCustomerDAO;
        this.DBEmailDAO = DBEmailDAO;
        this.connection = connection;
    }



    @Override
    public Customer createCustomer(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(Customer customer) {
        return null;
    }

    @Override
    public void updateCustomer(Customer customer) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public HashMap<String, String> getCredentials() {
        return null;
    }

    @Override
    public void setCredentials(String email, String password) {

    }

    @Override
    public Event createEvent(Event event) {
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return null;
    }

    @Override
    public void deleteEvent(Event event) {

    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return null;
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return null;
    }

    @Override
    public void deleteTicket(Ticket ticket) {

    }

    @Override
    public List<Ticket> getTicketsFromEvent(Event event) {
        return null;
    }

    @Override
    public boolean foundTicketID(String id) {
        return false;
    }
}
