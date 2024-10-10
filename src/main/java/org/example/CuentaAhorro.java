package org.example;

public class CuentaAhorro extends CuentaBancaria {
    //atributo específico de la clase
    double tipoInteres;

    //constructor para inicializar los atributos (llamando al constructor de la clase padre)
    public CuentaAhorro(Persona titular, double saldo, String iban, double tipoInteres) {
        super(titular, saldo, iban);
        this.tipoInteres = tipoInteres;
    }

    //se implementa el metodo devolverInfoString() de la interfaz Imprimible y devuelve un String con toda la información de la cuenta de ahorro
    @Override
    public String devolverInfoString() {
        return "Cuenta Ahorro - IBAN: " + iban + ", Titular: " + titular.toString() +
                ", Saldo: " + saldo + ", Interés Anual: " + tipoInteres;
    }
}