package utility.Scenes;

import gui.controller.EventCoordinatorDashboardController;
import gui.controller.LoginController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utility.Scenes.interfaces.ILoadScene;

import java.io.File;
import java.io.IOException;

public class LogInScene implements ILoadScene<LoginController> {


    private final Image image = new Image("gui/images/Icons/ticket_2_icon.png");
    private static FXMLLoader loader;

    @Override
    public void loadNewScene(Stage stage) throws IOException {
        loader = new FXMLLoader(new File("src/gui/view/LoginView.fxml").toURI().toURL());
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Event Manager - Welcome");
        stage.getIcons().add(image);
        stage.show();
    }

    @Override
    public LoginController getController() {
        return loader.getController();
    }
}
