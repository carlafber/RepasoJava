package org.example;

import java.util.ArrayList;

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

    @Override
    public double comisionMantenimiento() {
        return 0;
    }

    @Override
    public double tipoInteresDescubierto() {
        return 0;
    }

    @Override
    public double maximoDescubierto() {
        return 0;
    }
}
