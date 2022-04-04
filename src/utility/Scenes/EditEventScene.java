package utility.Scenes;


import gui.controller.EditEventController;
import gui.controller.EventCoordinatorDashboardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utility.Scenes.interfaces.ILoadScene;

import java.io.File;
import java.io.IOException;

public class EditEventScene implements ILoadScene<EditEventController> {

    private final Image image = new Image("gui/images/Icons/ticket_2_icon.png");
    private static FXMLLoader loader;
    private EventCoordinatorDashboardController dashboardController;

    @Override
    public void loadNewScene(Stage stage) throws IOException {
        loader = (new FXMLLoader(new File("src/gui/view/EditEventView.fxml").toURI().toURL()));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Event Manager");
        stage.getIcons().add(image);
        stage.showAndWait();
    }

    @Override
    public EditEventController getController() {
        return loader.getController();
    }
}
