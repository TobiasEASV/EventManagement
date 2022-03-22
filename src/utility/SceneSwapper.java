package utility;
import gui.controller.EventCoordinatorDashboardController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class SceneSwapper {

    private static FXMLLoader dashboard;



    /**
     * switches the stage to a certain fxml file.
     * @param stage of stage wanted to be shown.
     * @param fxmlClassName the file that wanted to be shown
     */
    public void sceneSwitch(Stage stage, String fxmlClassName){
        try {
            URL url = new File("src/gui/view/" + fxmlClassName).toURI().toURL();
            Parent scene = FXMLLoader.load(url);
            Scene ViewScene = new Scene(scene);
            stage.setTitle("Event Manager");
            Image image = new Image("gui/images/Icons/ticket_2_icon.png");
            stage.getIcons().add(image);
            stage.setScene(ViewScene);
            stage.show();
        }catch (IOException IOex){
            IOex.printStackTrace();
        }
    }

    public void instantiateMainScene(Stage stage, String fxmlFile) throws IOException {
        dashboard = new FXMLLoader(getClass().getResource("../gui/view/" + fxmlFile));
        stage.setScene(new Scene(dashboard.load()));
        stage.setTitle("Event Management");
        Image image = new Image("/gui/images/Icons/ticket_2_icon.png");
        stage.getIcons().add(image);
        stage.show();
    }

    public EventCoordinatorDashboardController getDashboardController(){
        return dashboard.getController();
    }
}