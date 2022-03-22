import javafx.application.Application;
import gui.controller.EventCoordinatorDashboardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static FXMLLoader mainController;

    public App() {
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainController = new FXMLLoader((getClass().getResource("gui/view/EventCoordinatorDashboardView.fxml")));
        primaryStage.setTitle("Event Management");
        primaryStage.setScene(new Scene(mainController.load()));
        Image image = new Image("/gui/images/Icons/ticket_2_icon.png");
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }

    public EventCoordinatorDashboardController getController() {
        return mainController.getController();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
