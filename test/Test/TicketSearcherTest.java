package Test;

import be.Customer;
import be.Event;
import be.Ticket;
import bll.util.TicketSearcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class TicketSearcherTest {

    TicketSearcher ts = new TicketSearcher();
    List <Ticket> searchBase = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Event event = new Event("Test Event", "This is for testing the ticket searcher", "Somewhere", "Simon",
                "place@holder.dk", 20.0, 20.0, null, null, true);
        Customer c1 = new Customer("John@gmail.com", "John Doe", "56984567");
        Customer c2 = new Customer("Sune@gmail.com", "Sune Doe", "56984567");
        Customer c3 = new Customer("Mikkel@gmail.com", "Mikkel Doe", "56984567");
        Customer c4 = new Customer("Mads@gmail.com", "Mads Doe", "56984567");
        boolean isSeated = false;
        boolean isVIP = true;


        searchBase.add(new Ticket(c1, event, 20.0, isVIP, isSeated));
        searchBase.add(new Ticket(c2, event, 20.0, isVIP, isSeated));
        searchBase.add(new Ticket(c3, event, 20.0, isVIP, isSeated));
        searchBase.add(new Ticket(c4, event, 20.0, isVIP, isSeated));
    }

    @AfterEach
    void tearDown() {
        searchBase.clear();
    }

    @Test
    void testSearchPersonInList() {
        int expected = 1;
        int actual = ts.search(searchBase, "Mikkel").size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSearchPersonNotInList4() {
        int expected = 0;
        int actual = ts.search(searchBase, "Mikk6el").size();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSearchPersonAllInList() {
        int expected = 4;
        int actual = ts.search(searchBase, "Doe").size();

        Assertions.assertEquals(expected, actual);
    }
}