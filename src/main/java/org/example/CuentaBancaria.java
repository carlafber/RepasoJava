package org.example;

import java.util.ArrayList;

public abstract class CuentaBancaria {
    Persona titular;
    int saldo;
    String iban;

    /*public CuentaBancaria() {
        super();
    }

    public CuentaBancaria(Persona titular, int saldo, String iban) {
        super(titular, saldo, iban);
    }*/

    public CuentaBancaria(Persona titular, int saldo, String iban) {
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

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
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
    public abstract double comisionMantenimiento();
    public abstract double tipoInteresDescubierto();
    public abstract double maximoDescubierto();
}
