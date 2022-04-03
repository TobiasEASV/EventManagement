package utility.Scenes;

import gui.controller.AdminDashboardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import utility.Scenes.interfaces.ILoadScene;

import java.io.File;
import java.io.IOException;

public class AdminDashboardScene implements ILoadScene<AdminDashboardController> {

    private final Image image = new Image("gui/images/Icons/ticket_2_icon.png");
    private static FXMLLoader loader;

    @Override
    public void loadNewScene(Stage stage) throws IOException {
        loader = (new FXMLLoader(new File("src/gui/view/AdminDashboardView.fxml").toURI().toURL()));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Event Manager - Admin Dashboard");
        stage.getIcons().add(image);
        stage.show();

    }

    @Override
    public AdminDashboardController getController() {
        return loader.getController();
    }
}
