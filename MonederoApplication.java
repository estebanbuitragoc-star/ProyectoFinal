package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MonederoApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // Carga la pantalla de menú principal
        FXMLLoader loader = new FXMLLoader(getClass().getResource("resources/menu.fxml"));

        Scene scene = new Scene(loader.load());
        stage.setTitle("Monedero Virtual");
        stage.setScene(scene);
        stage.show();
    }
}
