import gui.controller.EventCoordinatorDashboardController;
import javafx.application.Application;
import javafx.stage.Stage;
import utility.Scenes.DashboardScene;
import utility.Scenes.ILoadScene;


import java.io.IOException;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
       ILoadScene<EventCoordinatorDashboardController> dashboardScene =  new DashboardScene();
        dashboardScene.loadNewScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
