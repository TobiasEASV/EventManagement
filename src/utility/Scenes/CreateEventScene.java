package utility.Scenes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class CreateEventScene extends LoadScene<CreateEventScene>{
    private final Image image = new Image("gui/images/Icons/ticket_2_icon.png");

    @Override
    public void loadNewScene(Stage stage) throws IOException {
        setFXMLLoader(new FXMLLoader(new File("src/gui/view/CreateEventView.fxml").toURI().toURL()));
        stage.setScene(new Scene(getFXMLLoader().load()));
        stage.setTitle("Event Manager - New Event");
        stage.getIcons().add(image);
        stage.show();
    }
}
