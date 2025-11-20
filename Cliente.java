package model;
import java.util.*;

public class Cliente {
    private String nombre;
    private List<Cuenta> cuentas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta c) {
        cuentas.add(c);
    }

    public Cuenta getCuenta(int indice) {
        if(indice >= 0 && indice < cuentas.size()) return cuentas.get(indice);
        return null;
    }

    public List<Cuenta> getCuentas() { return cuentas; }
    public String getNombre() { return nombre; }
}