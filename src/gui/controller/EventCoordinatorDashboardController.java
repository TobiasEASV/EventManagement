package gui.controller;

import be.Event;
import be.Ticket;
import gui.model.EventListModel;
import gui.model.PrintModel;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import utility.EmailClient;
import utility.SceneSwapper;

import javax.imageio.ImageIO;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EventCoordinatorDashboardController implements Initializable {


    @FXML
    private GridPane parentGridPane;

    @FXML
    private TableColumn tcName;
    @FXML
    private TableColumn tcTicketPrice;
    @FXML
    private TableColumn tcPaymentStatus;

    @FXML
    private TextField textFieldSearch;
    @FXML
    private TextField txtAlternativeEmail;

    @FXML
    private ComboBox comboBoxChoosePrinter;
    @FXML
    private ComboBox comboBoxChooseEvent;

    @FXML
    private CheckBox checkBoxTicketTypeStandard;
    @FXML
    private CheckBox checkBoxTicketTypeVIP;
    @FXML
    private CheckBox checkBoxTicketTypeFoodIncl;
    @FXML
    private CheckBox checkBoxTicketTypeDrinksIncl;

    @FXML
    private Label lblEventTitle;
    @FXML
    private Label lblEventLocation;
    @FXML
    private Label lblEventDescription;
    @FXML
    private Label lblEventArtists;
    @FXML
    private Label lblEventStartDate;
    @FXML
    private Label lblEventEndDate;
    @FXML
    private Label lblEventPrice;
    @FXML
    private Label lblEventContactEmail;

    // Ticket preview labels
    @FXML
    private Label lblTicketRowNumber;
    @FXML
    private Label lblTicketSeatNumber;
    @FXML
    private Label lblCustomerName;
    @FXML
    private Label lblCustomerEmail;
    @FXML
    private Label lblTicketTitle;
    @FXML
    private Label lblTicketSubtitle;
    @FXML
    private Label lblTicketDescription;
    @FXML
    private Label lblTicketLocation;
    @FXML
    private Label lblTicketContactEmail;
    @FXML
    private Label lblTicketStartDate;
    @FXML
    private Label lblTicketEndDate;

    @FXML
    private GridPane ticketPane;

    //Array that holds printservices available on the PC.
    private PrintService[] printServices;

    //gui.model.PrintModel for printing tickets (a singleton)
    PrintModel printModel;
    EmailClient email;
    Ticket ticket;
    EventListModel eventListModel;
    SceneSwapper sceneSwapper;

    private final String TICKET_FILE = "src/gui/utility/temp/tempTicket.png";


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //instantiate the singleton PrintModel
        printModel = PrintModel.getInstance();

        try {
            email = new EmailClient();
        } catch (IOException IOe) {
            IOe.printStackTrace();
        }
        ticket = new Ticket();
        eventListModel = new EventListModel();
        sceneSwapper = new SceneSwapper();
        //comboBoxChooseEvent.getItems().add(new Event(null,null,null,null,null,0,0, 0,0,null,null));

        //Get print services
        printServices = PrintServiceLookup.lookupPrintServices(null, null);
        //Add print services to choose printer drop-down
        comboBoxChoosePrinter.getItems().setAll(printServices);

    }

    public void updateComboBoxChooseEvent(Event event){
        comboBoxChooseEvent.getItems().add(event);
    }

    public void handleSellTicketButton(ActionEvent actionEvent) {
    }

    public void handleRefundTicketButton(ActionEvent actionEvent) {
    }

    public void handlePrintTicketButton(ActionEvent actionEvent) {
        //Generate image of the ticket
        generateTicket();
        // Send print request to the print model with the selected printer
        printModel.print((PrintService) comboBoxChoosePrinter.getSelectionModel().getSelectedItem(), TICKET_FILE);
    }

    public void handleMailTicketButton(ActionEvent actionEvent) throws IOException {
        generateTicket();

        email.sendEmail(ticket.getCustomerEmailProperty().get(), "Your Ticket", "Congratulations on your ticket", TICKET_FILE);
    }

    public void handleEditEventButton(ActionEvent actionEvent) {
    }

    public void handleNewEventButton(ActionEvent actionEvent) throws IOException {
        sceneSwapper.instantiateCreateEventScene();
    }


    public void handleLogoutButton(ActionEvent actionEvent) {
    }

    public void handleUserSettingsButton(ActionEvent actionEvent) {
    }

    public void generateTicket(){
        WritableImage image = ticketPane.snapshot(new SnapshotParameters(),null);
        File file = new File("src/gui/utility/temp/tempTicket.png");
        try{
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "PNG", file);
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
