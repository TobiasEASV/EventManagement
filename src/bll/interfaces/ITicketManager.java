package bll.interfaces;

import be.Event;
import be.Ticket;

import java.util.List;

public interface ITicketManager {

    public Ticket createTicket(Ticket ticket);

    public Ticket updateTicket(Ticket ticket);

    public void deleteTicket(Ticket ticket);

    public List<Ticket> getTicketsFromEvent(Event event);
}
