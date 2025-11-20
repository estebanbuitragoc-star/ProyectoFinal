package app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button btnTransacciones, btnPuntos, btnRangos, btnBeneficios;

    @FXML
    protected void abrirTransacciones() throws IOException {
        abrirPantalla("/co/edu/uniquindio/poo/monedero/transacciones.fxml");
    }

    @FXML
    protected void abrirPuntos() throws IOException {
        abrirPantalla("/co/edu/uniquindio/poo/monedero/puntos.fxml");
    }

    @FXML
    protected void abrirRangos() throws IOException {
        abrirPantalla("/co/edu/uniquindio/poo/monedero/rangos.fxml");
    }

    @FXML
    protected void abrirBeneficios() throws IOException {
        abrirPantalla("/co/edu/uniquindio/poo/monedero/beneficios.fxml");
    }

    private void abrirPantalla(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) btnTransacciones.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
