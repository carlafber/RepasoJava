package org.example;

public abstract class CuentaCorriente extends CuentaBancaria {
    //atributo específico de la clase
    String listaEntidades;

    //constructor para inicializar los atributos (llamando al constructor de la clase padre)
    public CuentaCorriente(Persona titular, double saldo, String iban, String listaEntidades) {
        super(titular, saldo, iban);
        this.listaEntidades = listaEntidades;
    }

    //se implementa el metodo devolverInfoString() de la interfaz Imprimible y deberá devolver la información completa de la cuenta en forma de String
    @Override
    public abstract String devolverInfoString();
}
