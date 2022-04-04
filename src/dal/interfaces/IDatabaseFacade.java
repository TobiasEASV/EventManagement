package dal.interfaces;

import be.*;

import java.util.List;

/**
 * Specifies the contract for the data access layer in the application.
 */
public interface IDatabaseFacade {

                /***************************************************/
                /************* Customer responsibility *************/
                /***************************************************/

    /**
     * Returns a customer that is created in the appropriate DAO class
     * @param customer with fields specified in the view except for the ID, which is created in the database.
     * @return Customer
     */
    public Customer createCustomer(Customer customer);

    /**
     * Fetches customer in databse by ID.
     * @param customer
     * @return Customer.
     */
    public Customer getCustomer(Customer customer);

    /**
     * Updates all fields of a customer in the database except ID
     * @param customer
     */
    public void updateCustomer(Customer customer);

    /**
     * Delete a customer from the database by ID.
     * @param customer
     */
    public void deleteCustomer(Customer customer);


                /***************************************************/
                /************** Email responsibility ***************/
                /***************************************************/

    /**
     * @return a hashmap of an email and a password
     */
    public Email getCredentials();


    /**
     * Sets credentials of the email used by the application in the database
     * @param email
     * @param password
     */
    public void setCredentials(String email, String password);

    /**
     * Event responsibility.
     */

    /**
     * Creates an event in the DB
     * @param event
     * @return returns the event created in the BD.
     */
    public Event createEvent(Event event);

    /**
     * @return a list of all events from the database
     */
    public List<Event> getAllEvents();

    /**
     * Detes an event specified by ID
     * @param event
     */
    public void deleteEvent(Event event);

    /**
     * Updates all fields of an event specified by ID
     * @param event
     * @return an updated event
     */
    public Event updateEvent(Event event);

                /***************************************************/
                /************** Ticket responsibility **************/
                /***************************************************/

    /**
     * Inserts a ticket to the database
     * @param ticket
     * @return
     */
    public Ticket createTicket(Ticket ticket);

    /**
     * Updates all ticket fields on a ticket specified by ID
     * @param ticket
     * @return Ticket
     */
    public Ticket updateTicket(Ticket ticket);

    /**
     * Deletes a ticket in the database specified by ID.
     * @param ticket
     */
    public void deleteTicket(Ticket ticket);

    /**
     * Returns a list of tickets with a relation to an event specified by ID
     * @param event
     * @return
     */
    public List<Ticket> getTicketsFromEvent(Event event);

    /**
     * Returns a boolean if a ticket ID is already in the database.
     * This is because the application applies an ID to a ticket.
     * @param id
     * @return
     */
    public boolean foundTicketID(String id);

    /**
     * Check to see if username and password a correct
     * @param userName
     * @param password
     * @return a EventCoodinator if username and password was found in database
     */
    public EventCoordinator checkCredentialForEventCoordinator(String userName, String password);

    public EventCoordinator createEventCoordinator(EventCoordinator eventCoordinator);

    public List<EventCoordinator> getAllEventCoordinators();

    public void deleteEventCoordinator(EventCoordinator eventCoordinator);

    /**
     * Check to see if username and password a correct
     * @param userName
     * @param password
     * @return a Admin if username and password was found in database
     */
    public Admin checkCredentialForAdmin(String userName, String password);
}
