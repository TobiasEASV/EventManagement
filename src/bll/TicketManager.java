package bll;

import be.Ticket;
import dal.TicketDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class TicketManager {

    private TicketDAO ticketDAO;

    public TicketManager() throws IOException {
        ticketDAO = new TicketDAO();
    }

    public void createTicket(Ticket ticket) {
        ticketDAO.createTicket(ticket);
    }

    public void updateTicket(Ticket ticket) {
        //ticketDAO.updateTicket(ticket);
    }

    public void deleteTicket(Ticket ticket) {
        ticketDAO.deleteTicket(ticket);
    }

    public ObservableList<Ticket> getAllTicketToObservable() {
        ObservableList<Ticket> observableTickets = FXCollections.observableArrayList();
        observableTickets.addAll(ticketDAO.getAllTickets());

        for (Ticket t : observableTickets)
        {

        }
        return observableTickets;
    }

}
