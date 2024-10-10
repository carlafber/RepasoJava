package org.example;


public abstract class CuentaCorriente extends CuentaBancaria {
    String listaEntidades;

    public CuentaCorriente(Persona titular, double saldo, String iban, String listaEntidades) {
        super(titular, saldo, iban);
        this.listaEntidades = listaEntidades;
    }


    @Override
    public abstract String devolverInfoString();
}
