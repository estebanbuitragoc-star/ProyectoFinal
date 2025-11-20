package model;

import java.time.LocalDate;

public class TransaccionProgramada extends Transaccion implements Comparable<TransaccionProgramada> {

    private Cuenta destinoCuenta;

    public TransaccionProgramada(TipoTransaccion tipo, double monto, Cuenta destino, LocalDate fechaProgramada) {

        super(tipo, monto,null, fechaProgramada);
        this.destinoCuenta = destino;
    }

    public Cuenta getDestinoCuenta() {
        return destinoCuenta;
    }

    @Override
    public int compareTo(TransaccionProgramada o) {
        return this.getFecha().compareTo(o.getFecha());
    }

    @Override
    public String toString() {
        return getFecha() + " - " + getTipo() + " - " + getMonto() + " → destino: " + destinoCuenta;
    }
}