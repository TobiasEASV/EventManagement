package utility.Scenes.interfaces;

import javafx.stage.Stage;

import java.io.IOException;

public interface ILoadScene<T> {

    void loadNewScene(Stage stage) throws IOException;

    T getController();


}

