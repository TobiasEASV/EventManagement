package bll;

import be.Event;
import be.Ticket;
import dal.TicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketManager {

    private TicketDAO ticketDAO;

    public TicketManager() throws IOException {
        ticketDAO = new TicketDAO();
    }

    public Ticket createTicket(Ticket ticket) {
        return ticketDAO.createTicket(ticket);
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketDAO.updateTicket(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDAO.deleteTicket(ticket);
    }

    public List<Ticket> getTicketsFromEvent(Event event) {
        return ticketDAO.getTicketsFromEvent(event);
    }
    
}
