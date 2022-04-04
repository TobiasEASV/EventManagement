package bll;

import be.Event;
import be.Ticket;
import bll.interfaces.ITicketManager;
import dal.interfaces.IDatabaseFacade;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class TicketManager implements ITicketManager {

    private IDatabaseFacade iDatabaseFacade;

    public TicketManager(IDatabaseFacade iDatabaseFacade) throws IOException {
        this.iDatabaseFacade = iDatabaseFacade;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        ticket.setId(generateID());
        return iDatabaseFacade.createTicket(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return iDatabaseFacade.updateTicket(ticket);
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        iDatabaseFacade.deleteTicket(ticket);
    }

    @Override
    public List<Ticket> getTicketsFromEvent(Event event) {
        return iDatabaseFacade.getTicketsFromEvent(event);
    }

    private String generateID(){
        Random random = new Random();
        int idSize = 10;
        char[] arrayOfCharacter = {'1','2','3','4','5','6','7','8','9','0','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        StringBuilder newValueID = new StringBuilder();

        for (int i = 0; i < idSize; i++) {
            int value = random.nextInt(arrayOfCharacter.length);
            char nextChar = arrayOfCharacter[value];
            newValueID.append(nextChar);
        }

        // see if generate ID is in Database, if not than return new ID
        if(iDatabaseFacade.foundTicketID(newValueID.toString())){
            generateID();
        }
        return newValueID.toString();
    }
}
