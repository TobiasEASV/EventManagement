import gui.controller.EventCoordinatorDashboardController;
import javafx.application.Application;
import javafx.stage.Stage;
import utility.Scenes.DashboardScene;
import utility.Scenes.ILoadScene;
import utility.Scenes.LoadScene;

import java.io.IOException;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
       ILoadScene<EventCoordinatorDashboardController> dashboardScene =  new DashboardScene();
        dashboardScene.loadNewScene(primaryStage);

        //new SceneSwapper().instantiateMainScene(primaryStage,"");

        /**
        mainController = new FXMLLoader((getClass().getResource("gui/view/EventCoordinatorDashboardView.fxml")));
        primaryStage.setTitle("Event Management");
        primaryStage.setScene(new Scene(mainController.load()));
        Image image = new Image("/gui/images/Icons/ticket_2_icon.png");
        primaryStage.getIcons().add(image);
        primaryStage.show();
         **/
    }

    public static void main(String[] args) {
        launch(args);
    }
}
