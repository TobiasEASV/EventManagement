import javafx.application.Application;
import javafx.stage.Stage;
import utility.Scenes.SceneSwapper;

import java.io.IOException;

public class App extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        new SceneSwapper().instantiateMainScene(primaryStage, "EventCoordinatorDashboardView.fxml");

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
