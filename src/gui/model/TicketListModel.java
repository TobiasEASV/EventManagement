package gui.model;

import be.Event;
import be.Ticket;
import bll.TicketManager;
import bll.util.Isearcher;
import bll.util.TicketSearcher;
import gui.controller.EventCoordinatorDashboardController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static utility.Scenes.SceneSwapper.getDashboardController;


public class TicketListModel {

    private static TicketListModel single_instance = null;
    private TicketManager ticketManager;
    private ObservableList<Ticket> ticketList;
    private List<Ticket> ticketCache;
    private Isearcher ticketSearcher;
    private EventCoordinatorDashboardController dashboardController;

    private TicketListModel() throws IOException {
        dashboardController = getDashboardController();
        ticketManager = new TicketManager();
        ticketCache = new ArrayList<>();
        ticketList = FXCollections.observableArrayList();
        ticketSearcher = new TicketSearcher();

        ticketCache.addAll(ticketList);
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
