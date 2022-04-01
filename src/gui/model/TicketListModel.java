package gui.model;

import be.Event;
import be.Ticket;
import bll.interfaces.ITicketManager;
import bll.util.Isearcher;
import bll.util.TicketSearcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;


public class TicketListModel {

    private static TicketListModel single_instance = null;
    private ITicketManager ticketManager;
    private ObservableList<Ticket> ticketList;
    private List<Ticket> ticketCache;
    private Isearcher ticketSearcher;

    public TicketListModel(ITicketManager ticketManager) {
        this.ticketManager = ticketManager;
        ticketCache = new ArrayList<>();
        ticketList = FXCollections.observableArrayList();
        ticketSearcher = new TicketSearcher();

        ticketCache.addAll(ticketList);
    }

    public ObservableList<Ticket> getTicketList(){
        return ticketList;
    }

    public void addTicketToList(Ticket ticket){
        ticketList.add(ticketManager.createTicket(ticket));
    }

    public void deleteTicketFromList(Ticket ticket){
        ticketList.remove(ticket);
        ticketManager.deleteTicket(ticket);
    }

    public void updateTicket(Ticket ticket){
        ticketManager.updateTicket(ticket);
    }

    public void updateTicketList(Event event){
        ticketList.clear();
        ticketCache.clear();
        ticketList.addAll(ticketManager.getTicketsFromEvent(event)); // do this
        ticketCache.addAll(ticketList);
    }

    public void searchTicket(String query){
        if (query.isBlank() || query.isEmpty()) {
            ticketList.clear();
            ticketList.addAll(ticketCache);
        } else {
            ticketList.clear();
            ticketList.addAll(ticketSearcher.search(ticketCache, query));
        }

    }
}
