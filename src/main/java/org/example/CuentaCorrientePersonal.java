package org.example;

public class CuentaCorrientePersonal extends CuentaCorriente {
    double comisionMantenimiento;

    public CuentaCorrientePersonal(Persona titular, int saldo, String iban, double comisionMantenimiento) {
        super(titular, saldo, iban);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public double comisionMantenimiento() {
        return comisionMantenimiento;
    }

    @Override
    public double tipoInteresDescubierto() {
        return 0;
    }

    @Override
    public double maximoDescubierto() {
        return 0;
    }

    @Override
    public double tipoInteres() {
        return 0;
    }
}
