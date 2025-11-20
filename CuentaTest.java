package test;
import model.Cuenta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CuentaTest {

    @Test
    public void testDepositar() {
        Cuenta cuenta = new Cuenta("Esteban", 100.0);
        cuenta.depositar(50.0);
        assertEquals(150.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testRetirarConComision() {
        Cuenta cuenta = new Cuenta("Esteban", 200.0);
        cuenta.retirar(70.0); // comisión del 2%
        // total descontado = 70 + 1.4 = 71.4 → saldo final = 128.6
        assertEquals(128.6, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testRetirarMesSinCargos() {
        Cuenta cuenta = new Cuenta("Esteban", 200.0);
        cuenta.setMesSinCargos(true); // no aplica comisión
        cuenta.retirar(70.0);
        assertEquals(130.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testRetirarSaldoInsuficiente() {
        Cuenta cuenta = new Cuenta("Esteban", 50.0);
        boolean resultado = cuenta.retirar(100.0);
        assertFalse(resultado);
        assertEquals(50.0, cuenta.getSaldo(), 0.001);
    }

    @Test
    public void testTransferirConComision() {
        Cuenta origen = new Cuenta("Origen", 200.0);
        Cuenta destino = new Cuenta("Destino", 50.0);
        origen.transferir(destino, 100.0); // comisión 2% = 2 → saldo final = 98
        assertEquals(98.0, origen.getSaldo(), 0.001);
        assertEquals(150.0, destino.getSaldo(), 0.001);
    }

    @Test
    public void testTransferirConDescuentoPuntos() {
        Cuenta origen = new Cuenta("Origen", 200.0);
        Cuenta destino = new Cuenta("Destino", 50.0);
        origen.setProximoDescuentoTransf(true); // aplica 10% de descuento en comisión
        origen.transferir(destino, 100.0);
        // comisión original 2% = 2 → con 10% de descuento = 1.8 → total descontado = 101.8
        assertEquals(98.2, origen.getSaldo(), 0.001);
        assertEquals(150.0, destino.getSaldo(), 0.001);
    }
}