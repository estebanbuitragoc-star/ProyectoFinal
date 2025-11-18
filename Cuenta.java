package model;

public class Cuenta {

    private String nombre;
    private double saldo;
    private SistemaPuntos sistemaPuntos;
    private double comisionTransferencia = 0.02; // 2% del monto
    private double comisionRetiro = 0.02;        // 2% del monto
    private boolean mesSinCargos = false;        // beneficio por puntos
    private boolean proximoDescuentoTransf = false; // descuento 10% por puntos

    public Cuenta(String nombre) {
        this.nombre = nombre;
        this.saldo = 0;
        this.sistemaPuntos = new SistemaPuntos();
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getSaldo() { return saldo; }
    public SistemaPuntos getSistemaPuntos() { return sistemaPuntos; }

    // Depositar dinero
    public void depositar(double monto) {
        saldo += monto;
    }

    // Retirar dinero con comisión porcentual
    public boolean retirar(double monto) {
        double total = monto + (mesSinCargos ? 0 : monto * comisionRetiro);
        if(saldo >= total) {
            saldo -= total;
            return true;
        } else {
            return false;
        }
    }

    // Transferir dinero a otra cuenta con comisión porcentual
    public boolean transferir(Cuenta destino, double monto) {
        double comision = monto * comisionTransferencia;
        if(proximoDescuentoTransf) {
            comision *= 0.9; // aplica 10% de descuento por puntos
            proximoDescuentoTransf = false; // se consume el beneficio
        }
        double total = monto + comision;

        if(saldo >= total) {
            saldo -= total;
            destino.depositar(monto);
            return true;
        } else {
            return false;
        }
    }

    // Activar o desactivar mes sin cargos
    public void setMesSinCargos(boolean valor) {
        mesSinCargos = valor;
    }

    // Activar descuento en próxima transferencia
    public void setProximoDescuentoTransf(boolean valor) {
        proximoDescuentoTransf = valor;
    }

    // Cambiar porcentaje de comisión de transferencia
    public void setComisionTransferencia(double valor) {
        comisionTransferencia = valor;
    }

    // Cambiar porcentaje de comisión de retiro
    public void setComisionRetiro(double valor) {
        comisionRetiro = valor;
    }
}
