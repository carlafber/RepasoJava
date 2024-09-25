package org.example;

import java.util.*;

public abstract class CuentaCorriente extends CuentaBancaria {
    ArrayList<String> listaEntidades;

    public CuentaCorriente(Persona titular, double saldo, String iban) {
        super(titular, saldo, iban);
    }

    @Override
    public ArrayList<String> listaEntidades() {
        return listaEntidades;
    }

    /*public abstract double comisionMantenimiento();
    public abstract double tipoInteresDescubierto();
    public abstract double maximoDescubierto();
    public abstract double comisionFijaDescubierto();*/
}
