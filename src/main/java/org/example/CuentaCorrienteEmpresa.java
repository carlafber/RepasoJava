package org.example;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    double tipoInteresDescubierto;
    double maximoDescubierto;

    public CuentaCorrienteEmpresa(Persona titular, int saldo, String iban, double tipoInteresDescubierto, double maximoDescubierto) {
        super(titular, saldo, iban);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubierto = maximoDescubierto;
    }


    @Override
    public double comisionMantenimiento() {
        return 0;
    }

    @Override
    public double tipoInteresDescubierto() {
        return tipoInteresDescubierto;
    }

    @Override
    public double maximoDescubierto() {
        return maximoDescubierto;
    }

    @Override
    public double tipoInteres() {
        return 0;
    }
}
