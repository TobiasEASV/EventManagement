package utility.Scenes;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class LoadScene<T> implements IILoadScene {

    private static FXMLLoader LOADER;

    public T getController() {
        return this.LOADER.getController();
    }

    public void setFXMLLoader(FXMLLoader fxmlLoader){
        this.LOADER = fxmlLoader;
    }

    public FXMLLoader getFXMLLoader(){
        return this.LOADER;
    }
}

interface IILoadScene {
    void loadNewScene(Stage stage) throws IOException;

}
