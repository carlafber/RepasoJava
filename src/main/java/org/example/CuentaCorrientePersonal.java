package org.example;


public class CuentaCorrientePersonal extends CuentaCorriente {
    double comisionMantenimiento;

    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, String listaEntidades, double comisionMantenimiento) {
        super(titular, saldo, iban, listaEntidades);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public String devolverInfoString() {
        return "Cuenta Corriente Personal - IBAN: " + iban + ", Titular: " + titular.toString() +
                ", Saldo: " + saldo + ", Comisión Mantenimiento: " + comisionMantenimiento;
    }
}
