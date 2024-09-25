package org.example;

import java.util.ArrayList;

public abstract class CuentaBancaria {
    Persona titular;
    double saldo;
    String iban;

    public CuentaBancaria(Persona titular, double saldo, String iban) {
        super();
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public abstract double tipoInteres();
    public abstract ArrayList<String> listaEntidades();

}
