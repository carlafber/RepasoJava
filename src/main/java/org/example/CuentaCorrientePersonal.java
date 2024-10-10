package org.example;

public class CuentaCorrientePersonal extends CuentaCorriente {
    //atributo específico de la clase
    double comisionMantenimiento;

    //constructor para inicializar los atributos (llamando al constructor de la clase padre)
    public CuentaCorrientePersonal(Persona titular, double saldo, String iban, String listaEntidades, double comisionMantenimiento) {
        super(titular, saldo, iban, listaEntidades);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    //se implementa el metodo devolverInfoString() de la interfaz Imprimible y devuelve un String con toda la información de la cuenta de corriente personal
    @Override
    public String devolverInfoString() {
        return "Cuenta Corriente Personal - IBAN: " + iban + ", Titular: " + titular.toString() +
                ", Saldo: " + saldo + ", Comisión Mantenimiento: " + comisionMantenimiento;
    }
}
