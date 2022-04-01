import bll.CustomerManager;
import bll.EmailManager;
import bll.EventManager;
import bll.TicketManager;
import dal.*;
import gui.controller.EventCoordinatorDashboardController;
import gui.model.CustomerModel;
import gui.model.EventListModel;
import gui.model.TicketListModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utility.EmailClient;
import utility.Scenes.DashboardScene;
import utility.Scenes.ILoadScene;


import java.io.File;
import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        ILoadScene<EventCoordinatorDashboardController> dashboardScene =  new DashboardScene();
        dashboardScene.loadNewScene(primaryStage);
        EventCoordinatorDashboardController dashboardSceneController = dashboardScene.getController();

        DBConnecting dbConnecting = new DBConnecting();
        DBCustomerDAO dbCustomerDAO = new DBCustomerDAO(dbConnecting);
        DBEmailDAO dbEmailDAO = new DBEmailDAO(dbConnecting);
        DBEventDAO dbEventDAO = new DBEventDAO(dbConnecting);
        DBTicketDAO dbTicketDAO = new DBTicketDAO(dbConnecting);

        dashboardSceneController.setCustomerModel(new CustomerModel(new CustomerManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO))));
        dashboardSceneController.setEmailClient(new EmailClient(new EmailManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO))));
        dashboardSceneController.setEventListModel(new EventListModel(new EventManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO))));
        dashboardSceneController.setTicketListModel(new TicketListModel(new TicketManager(new DatabaseFacade(dbTicketDAO,dbEventDAO,dbCustomerDAO, dbEmailDAO))));

        dashboardSceneController.setController(dashboardSceneController);


    }

    public static void main(String[] args) {
        launch(args);
    }
}
