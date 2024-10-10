package org.example;

import java.util.*;

public class CuentaAhorro extends CuentaBancaria {
    double tipoInteres;

    public CuentaAhorro(Persona titular, double saldo, String iban, double tipoInteres) {
        super(titular, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String devolverInfoString() {
        return "Cuenta Ahorro - IBAN: " + iban + ", Titular: " + titular.toString() +
                ", Saldo: " + saldo + ", Interés Anual: " + tipoInteres;
    }
}
