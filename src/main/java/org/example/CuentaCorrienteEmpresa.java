package org.example;

import java.util.ArrayList;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    double tipoInteresDescubierto;
    double maximoDescubierto;
    double comisionFijaDescubierto;

    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, double tipoInteresDescubierto, double maximoDescubierto, double comisionFijaDescubierto) {
        super(titular, saldo, iban);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubierto = maximoDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    @Override
    public boolean retirar(double cantidad) {
        if (saldo + maximoDescubierto >= cantidad) {
            saldo -= cantidad;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String devolverInfoString() {
        return "Cuenta Corriente Empresa - IBAN: " + iban + ", Titular: " + titular.toString() +
                ", Saldo: " + saldo + ", Máximo Descubierto: " + maximoDescubierto +
                ", Entidades Autorizadas: " + listaEntidadestoString();
    }
}
