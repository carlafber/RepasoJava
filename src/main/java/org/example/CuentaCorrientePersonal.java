package org.example;

import java.util.ArrayList;

public class CuentaCorrientePersonal extends CuentaCorriente {
    double comisionMantenimiento;

    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, double comisionMantenimiento) {
        super(titular, saldo, iban);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public String devolverInfoString() {
        return "Cuenta Corriente Personal - IBAN: " + iban + ", Titular: " + titular.toString() +
                ", Saldo: " + saldo + ", Comisión Mantenimiento: " + comisionMantenimiento +
                ", Entidades Autorizadas: " + listaEntidadestoString();
    }
}
