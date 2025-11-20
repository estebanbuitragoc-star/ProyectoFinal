package app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RangosController {

    @FXML
    private Label lblInfo;

    @FXML
    protected void initialize() {
        lblInfo.setText("Pantalla de rangos");
    }
}
