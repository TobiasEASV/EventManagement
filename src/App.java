import bll.*;
import bll.util.PDFConverter;
import dal.*;
import gui.controller.EventCoordinatorDashboardController;
import gui.controller.LoginController;
import gui.model.*;
import javafx.application.Application;
import javafx.stage.Stage;
import utility.EmailClient;
import utility.Scenes.EventCoordinatorDashboardScene;
import utility.Scenes.LogInScene;
import utility.Scenes.interfaces.ILoadScene;


import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        boolean willIUseTheLogin = false;

        if(willIUseTheLogin){
            ILoadScene<LoginController> loginScene =  new LogInScene();
            loginScene.loadNewScene(primaryStage);
            LoginController loginController = loginScene.getController();

            DBConnecting dbConnecting = new DBConnecting();
            DBCustomerDAO dbCustomerDAO = new DBCustomerDAO(dbConnecting);
            DBEmailDAO dbEmailDAO = new DBEmailDAO(dbConnecting);
            DBEventDAO dbEventDAO = new DBEventDAO(dbConnecting);
            DBTicketDAO dbTicketDAO = new DBTicketDAO(dbConnecting);
            DBEventCoordinatorDAO dbEventCoordinatorDAO = new DBEventCoordinatorDAO(dbConnecting);
            DBAdminDAO dbadminDAO = new DBAdminDAO(dbConnecting);

            loginController.setCustomerModel(new CustomerModel(new CustomerManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            loginController.setEmailClient(new EmailClient(new EmailManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            loginController.setEventListModel(new EventListModel(new EventManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            loginController.setTicketListModel(new TicketListModel(new TicketManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            loginController.setEventCoordinatorModel(new EventCoordinatorModel(new EventCoordinatorManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            loginController.setAdminModel(new AdminModel(new AdminManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            loginController.setPrimaryStage(primaryStage);
            loginController.setPdfConverter(new PDFConverter());
            loginController.setPrintModel(new PrintModel());
        }else {
            ILoadScene<EventCoordinatorDashboardController> EventCoordinatorDashboard =  new EventCoordinatorDashboardScene();
            EventCoordinatorDashboard.loadNewScene(primaryStage);
            EventCoordinatorDashboardController eventCoordinatorDashboardController = EventCoordinatorDashboard.getController();

            DBConnecting dbConnecting = new DBConnecting();
            DBCustomerDAO dbCustomerDAO = new DBCustomerDAO(dbConnecting);
            DBEmailDAO dbEmailDAO = new DBEmailDAO(dbConnecting);
            DBEventDAO dbEventDAO = new DBEventDAO(dbConnecting);
            DBTicketDAO dbTicketDAO = new DBTicketDAO(dbConnecting);
            DBEventCoordinatorDAO dbEventCoordinatorDAO = new DBEventCoordinatorDAO(dbConnecting);
            DBAdminDAO dbadminDAO = new DBAdminDAO(dbConnecting);

            eventCoordinatorDashboardController.setCustomerModel(new CustomerModel(new CustomerManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            eventCoordinatorDashboardController.setEmailClient(new EmailClient(new EmailManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            eventCoordinatorDashboardController.setEventListModel(new EventListModel(new EventManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            eventCoordinatorDashboardController.setTicketListModel(new TicketListModel(new TicketManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            eventCoordinatorDashboardController.setEventCoordinatorModel(new EventCoordinatorModel(new EventCoordinatorManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO, dbEventCoordinatorDAO, dbadminDAO))));
            eventCoordinatorDashboardController.setPrintModel(new PrintModel());
            eventCoordinatorDashboardController.setPdfConverter(new PDFConverter());
            eventCoordinatorDashboardController.setController(eventCoordinatorDashboardController);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
