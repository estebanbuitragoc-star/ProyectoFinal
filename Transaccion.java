
package model;

import java.time.LocalDate;

public class Transaccion {
    private TipoTransaccion tipo;
    private double monto;
    private LocalDate fecha;  // fecha de la transacción
    private String destino;   // opcional, solo para transferencias

    // Constructor normal
    public Transaccion(TipoTransaccion tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
        this.fecha = LocalDate.now();
        this.destino = null;
    }

    // Constructor para transferencias o transacciones programadas
    public Transaccion(TipoTransaccion tipo, double monto, String destino, LocalDate fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.destino = destino;
        this.fecha = fecha;
    }

    public TipoTransaccion getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }
    public String getDestino() { return destino; }

    @Override
    public String toString() {
        if(destino != null)
            return fecha + " - " + tipo + " - " + monto + " a " + destino;
        else
            return fecha + " - " + tipo + " - " + monto;
    }
}