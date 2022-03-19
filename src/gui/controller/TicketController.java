package gui.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class TicketController {
    @FXML
    private GridPane ticket;

    public TicketController(){

    }

    public GridPane getTicketPane(){
        return ticket;
    }

    public void setTicketData(){
        //TODO skal tage be.ticket, og sætte ticket (dette gridpane) variablen's labels til ticketens data.
    }
}


