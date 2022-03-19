import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader((getClass().getResource("gui/view/EventCoordinatorDashboardView.fxml")));
        primaryStage.setTitle("Event Management");
        primaryStage.setScene(new Scene(loader.load()));
        Image image = new Image("/gui/images/Icons/ticket_2_icon.png");
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }
}
