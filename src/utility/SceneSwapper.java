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


    private final Image image = new Image("gui/images/Icons/ticket_2_icon.png");
    private final String sceneTitle = "Event Manager";



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
            stage.setTitle(sceneTitle);
            stage.getIcons().add(image);
            stage.setScene(ViewScene);
            stage.show();
        }catch (IOException IOex){
            IOex.printStackTrace();
        }
    }

    public void defScene(Stage stage, String fxmlFile) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/view/" + fxmlFile));
        stage.setScene(new Scene(loader.load()));
        stage.show();
    }

    public void instantiateCreateEventScene() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../gui/view/CreateEventView.fxml"));
        stage.setScene(new Scene(loader.load()));
        stage.setTitle(sceneTitle + " - New Event");
        stage.getIcons().add(image);
        stage.show();
    }

    public void instantiateMainScene(Stage stage, String fxmlFile) throws IOException {
        dashboard = new FXMLLoader(getClass().getResource("../gui/view/" + fxmlFile));
        stage.setScene(new Scene(dashboard.load()));
        stage.setTitle(sceneTitle);
        stage.getIcons().add(image);
        stage.show();
    }

    public static EventCoordinatorDashboardController getDashboardController(){
        return dashboard.getController();
    }
}