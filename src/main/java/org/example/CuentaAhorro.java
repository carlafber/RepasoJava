package org.example;

import java.util.*;

public class CuentaAhorro extends CuentaBancaria {
    double tipoInteres;

    public CuentaAhorro(Persona titular, int saldo, String iban, double tipoInteres) {
        super(titular, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    @Override
    public double tipoInteres() {
        return tipoInteres;
    }

    @Override
    public ArrayList<String> listaEntidades() {
        return null;
    }

}
