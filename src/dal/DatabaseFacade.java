package dal;

import be.*;
import dal.interfaces.*;

import java.util.List;

public class DatabaseFacade implements IDatabaseFacade {

    private final IDBTicketDAO DBTicketDAO;
    private final IDBEventDAO DBEventDAO;
    private final IDBCustomerDAO DBCustomerDAO;
    private final IDBEmailDAO DBEmailDAO;
    private final IDBEventCoordinatorDAO DBEventCoordinatorDAO;
    private final IDBAdminDAO DBAdminDAO;

    public DatabaseFacade(IDBTicketDAO DBTicketDAO, IDBEventDAO DBEventDAO, IDBCustomerDAO DBCustomerDAO, IDBEmailDAO DBEmailDAO, IDBEventCoordinatorDAO DBEventCoordinatorDAO, IDBAdminDAO DBAdminDAO){
        this.DBTicketDAO = DBTicketDAO;
        this.DBEventDAO = DBEventDAO;
        this.DBCustomerDAO = DBCustomerDAO;
        this.DBEmailDAO = DBEmailDAO;
        this.DBEventCoordinatorDAO = DBEventCoordinatorDAO;
        this.DBAdminDAO = DBAdminDAO;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return DBTicketDAO.createTicket(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return DBTicketDAO.updateTicket(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        DBTicketDAO.deleteTicket(ticket);
    }

    @Override
    public List<Ticket> getTicketsFromEvent(Event event) {
        return DBTicketDAO.getTicketsFromEvent(event);
    }

    @Override
    public boolean foundTicketID(String id) {
        return DBTicketDAO.foundTicketID(id);
    }

    @Override
    public EventCoordinator checkCredentialForEventCoordinator(String userName, String password) {
        return DBEventCoordinatorDAO.checkCredential(userName, password);
    }

    @Override
    public EventCoordinator createEventCoordinator(EventCoordinator eventCoordinator) {
        return DBEventCoordinatorDAO.createEventCoordinator(eventCoordinator);
    }

    @Override
    public Admin checkCredentialForAdmin(String userName, String password) {
        return DBAdminDAO.checkCredential(userName, password);
    }

    @Override
    public List<EventCoordinator> getAllEventCoordinators() {
        return DBEventCoordinatorDAO.getAllEventCoordinators();
    }

    @Override
    public void deleteEventCoordinator(EventCoordinator eventCoordinator) {
        DBEventCoordinatorDAO.deleteEventCoordinator(eventCoordinator);
    }

    @Override
    public Event createEvent(Event event) {
        return DBEventDAO.createEvent(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return DBEventDAO.getAllEvents();
    }

    @Override
    public void deleteEvent(Event event) {
        DBEventDAO.deleteEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return DBEventDAO.updateEvent(event);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return DBCustomerDAO.createCustomer(customer);
    }

    @Override
    public Customer getCustomer(Customer customer) {
        return DBCustomerDAO.getCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        DBCustomerDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        DBCustomerDAO.deleteCustomer(customer);
    }

    @Override
    public Email getCredentials() {
        return DBEmailDAO.getCredentials();
    }

    @Override
    public void setCredentials(String email, String password) {
        DBEmailDAO.setCredentials(email, password);
    }
}