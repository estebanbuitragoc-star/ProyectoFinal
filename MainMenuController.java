package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Cuenta;
import model.SistemaPuntos;
import model.TipoTransaccion;

public class MainMenuController {

    @FXML private TextField montoField;
    @FXML private TextArea outputArea;
    private Cuenta cuenta;

    public MainMenuController() {
        cuenta = new Cuenta("AnaCuenta");
    }

    @FXML
    private void handleDepositar(ActionEvent event) {
        try {
            double monto = Double.parseDouble(montoField.getText());
            cuenta.depositar(monto);
            cuenta.getSistemaPuntos().agregarPuntos(TipoTransaccion.DEPOSITO, monto);
            outputArea.appendText("Depósito realizado: " + monto + "\n");
            montoField.clear();
        } catch (NumberFormatException e) {
            outputArea.appendText("Ingrese un monto válido.\n");
        }
    }

    @FXML
    private void handleRetirar(ActionEvent event) {
        try {
            double monto = Double.parseDouble(montoField.getText());
            if(cuenta.retirar(monto)) {
                cuenta.getSistemaPuntos().agregarPuntos(TipoTransaccion.RETIRO, monto);
                outputArea.appendText("Retiro realizado: " + monto + "\n");
            } else {
                outputArea.appendText("Saldo insuficiente.\n");
            }
            montoField.clear();
        } catch (NumberFormatException e) {
            outputArea.appendText("Ingrese un monto válido.\n");
        }
    }

    @FXML
    private void handleTransferir(ActionEvent event) {
        try {
            double monto = Double.parseDouble(montoField.getText());
            Cuenta destino = new Cuenta("Gastos");
            if(cuenta.transferir(destino, monto)) {
                cuenta.getSistemaPuntos().agregarPuntos(TipoTransaccion.TRANSFERENCIA, monto);
                outputArea.appendText("Transferencia realizada: " + monto + " a " + destino.getNombre() + "\n");
            } else {
                outputArea.appendText("Saldo insuficiente.\n");
            }
            montoField.clear();
        } catch (NumberFormatException e) {
            outputArea.appendText("Ingrese un monto válido.\n");
        }
    }

    @FXML
    private void handleConsultarSaldo(ActionEvent event) {
        outputArea.appendText("Saldo actual: " + cuenta.getSaldo() + "\n");
    }

    @FXML
    private void handleConsultarPuntos(ActionEvent event) {
        outputArea.appendText("Puntos: " + cuenta.getSistemaPuntos().getPuntos() +
                              " | Rango: " + cuenta.getSistemaPuntos().getRango() + "\n");
    }
}
