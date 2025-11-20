package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PuntosController {

    @FXML
    private Label lblInfo;

    @FXML
    protected void initialize() {
        lblInfo.setText("Pantalla de consulta de puntos");
    }
}
