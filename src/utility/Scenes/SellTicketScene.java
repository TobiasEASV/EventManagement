package utility.Scenes;

import gui.controller.SellTicketViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SellTicketScene extends LoadScene<SellTicketViewController> {

    private final Image image = new Image("gui/images/Icons/ticket_2_icon.png");

    @Override
    public void loadNewScene(Stage stage) throws IOException {
        setFXMLLoader(new FXMLLoader(new File("src/gui/view/SellTicketView.fxml").toURI().toURL()));
        stage.setScene(new Scene(getFXMLLoader().load()));
        stage.setTitle("Event Manager");
        stage.getIcons().add(image);
        stage.show();
    }
}
