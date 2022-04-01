package dal;

import be.Event;
import be.Ticket;

import java.util.List;

public interface IDBTicketDAO {

    public Ticket createTicket(Ticket ticket);

    public Ticket updateTicket(Ticket ticket);

    public void deleteTicket(Ticket ticket);

    public List<Ticket> getTicketsFromEvent(Event event);

    public boolean foundTicketID(String id);
}
