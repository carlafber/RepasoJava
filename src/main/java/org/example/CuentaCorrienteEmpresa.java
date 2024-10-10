package org.example;

public class CuentaCorrienteEmpresa extends CuentaCorriente {
    //atributos específicos de la clase
    double tipoInteresDescubierto;
    double maximoDescubierto;
    double comisionFijaDescubierto;

    //constructor para inicializar los atributos (llamando al constructor de la clase padre)
    public CuentaCorrienteEmpresa(Persona titular, double saldo, String iban, String listaEntidades ,double tipoInteresDescubierto, double maximoDescubierto, double comisionFijaDescubierto) {
        super(titular, saldo, iban, listaEntidades);
        this.tipoInteresDescubierto = tipoInteresDescubierto;
        this.maximoDescubierto = maximoDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    //sobrescribe el metodo retirar() de la clase padre y permite retirar una cantidad de dinero de la cuenta, considerando el máximo descubierto
    @Override
    public boolean retirar(double cantidad) {
        if (saldo + maximoDescubierto >= cantidad) { //se verifica si la cantidad a retirar no excede el saldo disponible más el máximo descubierto
            saldo -= cantidad; //se resta la cantidad del saldo
            return true;
        } else {
            return false;
        }
    }

    //se implementa el metodo devolverInfoString() de la interfaz Imprimible y devuelve un String con toda la información de la cuenta de corriente de empresa
    @Override
    public String devolverInfoString() {
        return "Cuenta Corriente Empresa - IBAN: " + iban + ", Titular: " + titular.toString() +
                ", Saldo: " + saldo + ", Máximo Descubierto: " + maximoDescubierto;
    }
}
