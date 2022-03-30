package utility.Scenes;

import gui.controller.EditEventController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import java.io.IOException;

public class EditEventScene implements ILoadScene<EditEventController>{

    private final Image image = new Image("gui/images/Icons/ticket_2_icon.png");

    @Override
    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/view/EditEventView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Event Manager - Edit Event");
        stage.getIcons().add(image);
        stage.show();
    }

    @Override
    public <T> void getController() {

    }

}
