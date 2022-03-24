package gui.controller;

import be.Event;
import be.Ticket;
import gui.model.EventListModel;
import gui.model.CustomerModel;
import gui.model.PrintModel;
import gui.model.TicketListModel;
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
    private TableView<Ticket> tvTickets;

    @FXML
    private TableColumn<Ticket, String> tcName;
    @FXML
    private TableColumn<Ticket, Double> tcTicketPrice;
    @FXML
    private TableColumn<Ticket, String> tcPaymentStatus;
    @FXML
    private TableColumn<Ticket, String> tcEmail;

    @FXML
    private TextField textFieldSearch;
    @FXML
    private TextField txtAlternativeEmail;

    @FXML
    private ComboBox<PrintService> comboBoxChoosePrinter;
    @FXML
    private ComboBox<Event> comboBoxChooseEvent;

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
    private Label lblTicketPrice;
    @FXML
    private Label lblTicketType;

    @FXML
    private GridPane ticketPane;

    private CustomerModel customerModel;

    //Array that holds printservices available on the PC.
    private PrintService[] printServices;

    private TicketListModel ticketListModel;

    //gui.model.PrintModel for printing tickets (a singleton)
    private PrintModel printModel;
    private EmailClient email;
    private Ticket ticket;
    private EventListModel eventListModel;
    private SceneSwapper sceneSwapper;

    private final String TICKET_FILE = "src/gui/utility/temp/tempTicket.png";

    public EventCoordinatorDashboardController() throws IOException {
        customerModel = new CustomerModel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //Model for handling the combobox with events in the view
            sceneSwapper = new SceneSwapper();
            //Utility class for switching scenes in javaFX
            eventListModel = new EventListModel();
            email = new EmailClient();
            //Ticket BE entity
            ticket = new Ticket();
            ticketListModel = TicketListModel.getInstance();
        } catch (IOException IOe) {
            IOe.printStackTrace();
        }

        //instantiate the singleton PrintModel
        printModel = PrintModel.getInstance();

        comboBoxChooseEvent.getItems().addAll(eventListModel.getEventList());

        //Get print services
        printServices = PrintServiceLookup.lookupPrintServices(null, null);
        //Add print services to choose printer drop-down
        comboBoxChoosePrinter.getItems().setAll(printServices);


        // Search functionality in the list view
        textFieldSearch.textProperty().addListener((observableValue, oldValue, newValue) -> {
                ticketListModel.searchTicket(newValue);
        });

        //Set placeholder for tableview if it is empty
        tvTickets.setPlaceholder(new Label("No tickets found for this event."));
        tvTickets.setItems(ticketListModel.getTicketList());
        tcName.setCellValueFactory(addTicket -> addTicket.getValue().getCustomer().getNameProperty());
        tcTicketPrice.setCellValueFactory(addTicket -> addTicket.getValue().getPriceProperty().asObject());
        tcPaymentStatus.setCellValueFactory(addTicket -> addTicket.getValue().getPaymentStatusProperty());
        tcEmail.setCellValueFactory(addTicket -> addTicket.getValue().getCustomer().getEmailProperty());

        tvTickets.getSelectionModel().selectedItemProperty().addListener((observable, oldTicket, newTicket) -> {
            if(newTicket != null)
                updateTicketLabels(newTicket);
            }
        );


    }


    public void updateComboBoxChooseEvent(Event event){
        comboBoxChooseEvent.getItems().add(event);
    }

    public void handleSellTicketButton(ActionEvent actionEvent) throws IOException {
        sceneSwapper.instantiateSellTicketScene();
    }

    public void handleRefundTicketButton(ActionEvent actionEvent) {
        customerModel.deleteCustomer(tvTickets.getSelectionModel().getSelectedItem().getCustomer());
    }

    public void handlePrintTicketButton(ActionEvent actionEvent) {
        //Generate image of the ticket
        generateTicket();
        // Send print request to the print model with the selected printer
        printModel.print((PrintService) comboBoxChoosePrinter.getSelectionModel().getSelectedItem(), TICKET_FILE);
    }

    public void handleMailTicketButton(ActionEvent actionEvent) throws IOException {
        generateTicket();

        email.sendEmail(ticket.getCustomer().getEmailProperty().get(), "Your Ticket", "Congratulations on your ticket", TICKET_FILE);
    }

    public void handleEditEventButton(ActionEvent actionEvent) throws IOException {
        sceneSwapper.instantiateEditEventScene();
        eventListModel.removeEvent(comboBoxChooseEvent.getSelectionModel().getSelectedItem());

    }

    public void handleNewEventButton(ActionEvent actionEvent) throws IOException {
        sceneSwapper.instantiateCreateEventScene();
    }


    public void handleLogoutButton(ActionEvent actionEvent) {
        System.exit(1);
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

    public Event getSelectedEvent(){
        return comboBoxChooseEvent.getSelectionModel().getSelectedItem();
    }

    public void handleChooseEvent(ActionEvent actionEvent) {
        if (getSelectedEvent() != null){
            ticketListModel.updateTicketList(getSelectedEvent());
            updateEventLabels(getSelectedEvent());
        }
    }

    private void updateEventLabels(Event event) {
        lblEventTitle.setText(event.getTitleProperty().get());
        lblEventLocation.setText(event.getLocationProperty().get());
        lblEventDescription.setText(event.getDescriptionProperty().get());
        lblEventArtists.setText(event.getArtistsProperty().get());
        lblEventStartDate.setText(String.valueOf(event.getStartDateProperty().get()));
        lblEventEndDate.setText(String.valueOf(event.getEndDateProperty().get()));
        lblEventPrice.setText(String.valueOf(event.getPriceProperty().get()));
        lblEventContactEmail.setText(event.getContactEmailProperty().get());
        setCheckBoxesOnEvent(event);
    }

    private void setCheckBoxesOnEvent(Event event) {
        checkBoxTicketTypeVIP.setSelected(event.getVipPriceProperty().get() != 0);
        checkBoxTicketTypeDrinksIncl.setSelected(event.getDrinkPriceProperty().get() != 0);
        checkBoxTicketTypeFoodIncl.setSelected(event.getFoodPriceProperty().get() != 0);
    }

    private void updateTicketLabels(Ticket ticket) {
        String ticketType = "Standard";

        if (ticket.getDrinksProperty().get()) ticketType = "Drinks Incl";
        if (ticket.getFoodProperty().get()) ticketType = "Food Incl";
        if (ticket.getVipProperty().get()) ticketType = "VIP";


        lblTicketTitle.setText(ticket.getEvent().getTitleProperty().get());
        lblCustomerName.setText(ticket.getCustomer().getNameProperty().get());
        lblCustomerEmail.setText(ticket.getCustomer().getEmailProperty().get());
        lblTicketPrice.setText(String.valueOf(ticket.getPriceProperty().get()));
        lblTicketType.setText(ticketType);
        lblTicketLocation.setText(ticket.getEvent().getLocationProperty().get());
        lblTicketStartDate.setText(String.valueOf(ticket.getEvent().getStartDateProperty().get()));
        lblTicketEndDate.setText(String.valueOf(ticket.getEvent().getEndDateProperty().get()));
        lblTicketRowNumber.setText(ticket.getRowProperty().get());
        lblTicketSeatNumber.setText(ticket.getSeatProperty().get());
        lblTicketContactEmail.setText(ticket.getEvent().getContactEmailProperty().get());
        lblTicketDescription.setText(ticket.getEvent().getDescriptionProperty().get());
    }

    public void handleDeleteEventButton(ActionEvent actionEvent) {
        eventListModel.deleteEventFromList(getSelectedEvent());
        comboBoxChooseEvent.getItems().clear();
        comboBoxChooseEvent.getItems().addAll(eventListModel.getEventList());
    }
}
