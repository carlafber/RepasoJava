package org.example;

public abstract class CuentaBancaria implements Imprimible {
    //atributos de la clase
    Persona titular; //objeto de tipo Persona que representa al titular de la cuenta
    double saldo;
    String iban;

    //constructor para inicializar los atributos
    public CuentaBancaria(Persona titular, double saldo, String iban) {
        this.titular = titular;
        this.saldo = saldo;
        this.iban = iban;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    //metodo para ingresar dinero en la cuenta
    public void ingresar(double cantidad) {
        saldo += cantidad; //va incrementando el saldo de la cuenta según la cantidad especificada
    }

    //metodo para retirar dinero de la cuenta
    public boolean retirar(double cantidad) {
        if (saldo >= cantidad) { //verifica si hay saldo suficiente
            saldo -= cantidad; //si lo hay, resta la cantidad solicitada y devuelve true
            return true;
        } else { //si no hay suficiente saldo, devuelve false
            return false;
        }
    }

    //se implementa el metodo devolverInfoString() de la interfaz Imprimible y deberá devolver la información completa de la cuenta en forma de String
    public abstract String devolverInfoString();

}
