package org.example;

import java.util.ArrayList;

public class Banco{
    private ArrayList<CuentaBancaria> lista_cuentas; //para almacenar las cuentas existentes

    //constructor para inicializar la lista de cuentas
    public Banco() {
        lista_cuentas = new ArrayList<>();
    }

    //metodo para agregar una nueva cuenta bancaria a la lista
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        return lista_cuentas.add(cuenta); //devuelve true si la cuenta se agregó correctamente, false si hubo un problema
    }

    //metodo para devolver un array de String con la información de todas las cuentas
    public String[] listadoCuentas() {
        String[] lista = new String[lista_cuentas.size()]; //se crea un array de tamaño igual al número de cuentas en la lista
        for (int i = 0; i < lista_cuentas.size(); i++) { //se recorre la lista de cuentas y se extrae la información de cada una
            lista[i] = lista_cuentas.get(i).devolverInfoString();
        }
        return lista;
    }

    //metodo para buscar una cuenta en la lista a través de su IBAN
    public CuentaBancaria buscarCuenta(String iban) {
        for (CuentaBancaria cuenta : lista_cuentas) { //se recorren todas las cuentas de la lista
            if (cuenta.getIban().equals(iban)) { //si el IBAN coincide, se devuelve la cuenta
                return cuenta;
            }
        }
        return null;
    }

    //metodo para realizar un ingreso en una cuenta a través de su IBAN
    public boolean ingresoCuenta(String iban, double cantidad) {
        CuentaBancaria cuenta = buscarCuenta(iban); //se busca la cuenta correspondiente al IBAN introducido
        if (cuenta != null) { //si se encuentra
            cuenta.ingresar(cantidad); //se realiza el ingreso
            return true; //devuelve true si se ha realizado correctamente
        }
        return false;
    }

    //metodo para retirar dinero de una cuenta a través de su IBAN
    public boolean retiradaCuenta(String iban, double cantidad) {
        CuentaBancaria cuenta = buscarCuenta(iban); //se busca la cuenta correspondiente al IBAN introducido
        if (cuenta != null) { //si se encuentra
            return cuenta.retirar(cantidad); //se intenta retirar el dinero y devuelve el resultado (true o false)
        }
        return false;
    }

    //metodo para obtener el saldo actual de una cuenta a través de su IBAN
    public double obtenerSaldo(String iban) {
        CuentaBancaria cuenta = buscarCuenta(iban); //se busca la cuenta correspondiente al IBAN introducido
        return (cuenta != null) ? cuenta.getSaldo() : -1; //si la cuenta existe, devuelve el saldo; si no, devuelve -1
    }

    //metodo que devuelve la información completa de una cuenta a través de su IBAN
    public String informacionCuenta(String iban) {
        for (CuentaBancaria cuenta : lista_cuentas) { //se recorre la lista de cuentas
            if (cuenta.getIban().equals(iban)) { //si se encuentra la cuenta con ese IBAN
                return cuenta.devolverInfoString();  //se devuelve la información de la cuenta si se encuentra
            }
        }
        return null;  //si no se encuentra ninguna cuenta con ese IBAN, devuelve null
    }

}
