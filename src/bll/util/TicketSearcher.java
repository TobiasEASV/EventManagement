package bll.util;

import be.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketSearcher implements Isearcher{

    private List<Ticket> searchResult = new ArrayList<>();

    @Override
    public List<Ticket> search(List<Ticket> searchBase, String query) {
        searchResult.clear();

        for (Ticket ticket: searchBase) {
            if(compareToCustomerName(ticket, query) || compareToCustomerEmail(ticket, query))
            {
                searchResult.add(ticket);
            }
        }
        return searchResult;
    }

    /**
     * If isTitleOn is true, it checks if the ticket's customer name field contains the query and returns true if so.
     * @param ticket a Ticket object
     * @param query a search query
     * @return
     */
    @Override
    public boolean compareToCustomerName(Ticket ticket, String query) {
       return ticket.getCustomerNameProperty().get().toLowerCase().contains(query.toLowerCase());
    }

    /**
     * compares ticket customer emails to the query
     * @param ticket a Ticket object
     * @param query a search query
     * @return
     */
    @Override
    public boolean compareToCustomerEmail(Ticket ticket, String query) {
        return ticket.getCustomerEmailProperty().get().toLowerCase().contains(query.toLowerCase());
    }
}
