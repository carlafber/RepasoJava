package org.example;

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

    /*@Override
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
    }*/

    @Override
    public double tipoInteres() {
        return 0;
    }
}
