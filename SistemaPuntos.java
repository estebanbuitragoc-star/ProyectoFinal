
package model;

public class SistemaPuntos {
    private int puntos;

    public SistemaPuntos() {
        puntos = 0;
    }

    public SistemaPuntos(int puntosIniciales) {
        this.puntos = puntosIniciales;
    }

    // Agregar puntos según tipo de transacción
    public void agregarPuntos(TipoTransaccion tipo, double monto) {
        int pts = 0;
        if(tipo == TipoTransaccion.DEPOSITO) pts = (int)(monto / 100) * 1;
        else if(tipo == TipoTransaccion.RETIRO) pts = (int)(monto / 100) * 2;
        else if(tipo == TipoTransaccion.TRANSFERENCIA) pts = (int)(monto / 100) * 3;

        puntos += pts;

        // Alertas
        if(puntos >= 100 && puntos < 500) System.out.println("Alerta: tienes más de 100 puntos!");
        else if(puntos >= 500 && puntos < 1000) System.out.println("Alerta: tienes más de 500 puntos!");
        else if(puntos >= 1000) System.out.println("Alerta: ¡más de 1000 puntos acumulados!");
    }

    public int getPuntos() {
        return puntos;
    }

    public String getRango() {
        if(puntos <= 500) return "Bronce";
        else if(puntos <= 1000) return "Plata";
        else if(puntos <= 5000) return "Oro";
        else return "Platino";
    }

    // Canjear puntos por beneficios
    public void canjearBeneficio(int pts, Cuenta cuenta) {
    if(puntos < pts) {
        System.out.println("No tienes suficientes puntos para canjear.");
        return;
    }

    // 100 puntos o más → descuento próxima transferencia
    if(pts == 100 && puntos >= 100) {
        cuenta.setProximoDescuentoTransf(true);
        System.out.println("Beneficio aplicado: 10% de descuento en la próxima transferencia.");
    } 
    // 500 puntos o más → mes sin cargos
    else if(pts == 500 && puntos >= 500) {
        cuenta.setMesSinCargos(true);
        System.out.println("Beneficio aplicado: un mes sin cargos por retiros.");
    } 
    // 1000 puntos o más → bono de saldo
    else if(pts == 1000 && puntos >= 1000) {
        cuenta.depositar(50);
        System.out.println("Beneficio aplicado: bono de saldo de 50 unidades.");
    } 
    else {
        System.out.println("Beneficio no válido para esa cantidad de puntos.");
        return;
    }

    // Restar los puntos usados
    puntos -= pts;
    System.out.println("Puntos restantes: " + puntos);
}

}
