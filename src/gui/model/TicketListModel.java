package gui.model;

import be.Ticket;
import bll.TicketManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;


public class TicketListModel {

    private static TicketListModel single_instance = null;
    private TicketManager ticketManager;
    private ObservableList<Ticket> ticketList;

    private TicketListModel() throws IOException {
        ticketManager = new TicketManager();
        //ticketList = ticketManager.getAllTicketToObservable();
        //mock
        ticketList = FXCollections.observableArrayList();
        ticketList.add(new Ticket());
        ticketList.add(new Ticket());
        ticketList.add(new Ticket());
        ticketList.add(new Ticket());

    }

    public static TicketListModel getInstance() throws IOException {
        if (single_instance == null)
            single_instance = new TicketListModel();

        return single_instance;
    }

    public ObservableList<Ticket> getAllTickets(){
        return ticketList;
    }
}
