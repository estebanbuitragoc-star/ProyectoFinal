package model;
import java.time.LocalDate;

public class TransaccionProgramada implements Comparable<TransaccionProgramada> {
    private TipoTransaccion tipo;
    private double monto;
    private Cuenta destino; 
    private LocalDate fecha;

    public TransaccionProgramada(TipoTransaccion tipo, double monto, Cuenta destino, LocalDate fecha) {
        this.tipo = tipo;
        this.monto = monto;
        this.destino = destino;
        this.fecha = fecha;
    }

    public TipoTransaccion getTipo() { return tipo; }
    public double getMonto() { return monto; }
    public Cuenta getDestino() { return destino; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public int compareTo(TransaccionProgramada o) {
        return this.fecha.compareTo(o.fecha);
    }
}