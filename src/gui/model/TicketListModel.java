package gui.model;

import be.Ticket;
import bll.TicketManager;
import bll.util.Isearcher;
import bll.util.TicketSearcher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TicketListModel {

    private static TicketListModel single_instance = null;
    private TicketManager ticketManager;
    private ObservableList<Ticket> ticketList;
    private List<Ticket> ticketCache = new ArrayList<>();
    private Isearcher ticketSearcher;

    private TicketListModel() throws IOException {
        ticketManager = new TicketManager();
        ticketList = FXCollections.observableArrayList(ticketManager.getAllTicketToObservable().stream().map(ticket -> new Ticket()).toList());
        ticketCache.addAll(ticketList);
        ticketSearcher = new TicketSearcher();
    }

    public static TicketListModel getInstance() throws IOException {
        if (single_instance == null)
            single_instance = new TicketListModel();

        return single_instance;
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

    public void searchTicket(String query){
        ticketList.clear();
        if (query.isBlank()) {
            ticketList.addAll(ticketCache);
        } else {
            ticketList.addAll(ticketSearcher.search(ticketList, query));
        }

    }
}
