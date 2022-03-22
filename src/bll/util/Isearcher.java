package bll.util;

import be.Ticket;

import java.util.List;

public interface Isearcher {
    public List<Ticket> search(List<Ticket> searchBase, String query);

    public boolean compareToCustomerName(Ticket ticket, String query);

    public boolean compareToCustomerEmail(Ticket ticket, String query);
}
