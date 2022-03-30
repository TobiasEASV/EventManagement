package utility.Scenes;

import javafx.stage.Stage;

import java.io.IOException;

public interface ILoadScene<T> {

    public Stage stage = new Stage();

    public void load() throws IOException;

    public <T> void getController();
}
