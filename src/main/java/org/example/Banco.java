package org.example;

import java.util.ArrayList;

public class Banco{
    private ArrayList<CuentaBancaria> lista_cuentas;

    public Banco() {
        lista_cuentas = new ArrayList<>();
    }

    /*public static boolean abrirCuenta (CuentaBancaria cuenta) {
        lista_cuentas.add(cuenta);
        for(CuentaBancaria cuentaBancaria : lista_cuentas){
            if(cuentaBancaria.equals(cuenta)){
                return true;
            }
        }
        return false;
    }*/

    public boolean abrirCuenta(CuentaBancaria cuenta) {
        return lista_cuentas.add(cuenta);
    }

    public String[] listadoCuentas() {
        String[] lista = new String[lista_cuentas.size()];
        for (int i = 0; i < lista_cuentas.size(); i++) {
            lista[i] = lista_cuentas.get(i).devolverInfoString();
        }
        return lista;
    }

    public CuentaBancaria buscarCuenta(String iban) {
        for (CuentaBancaria cuenta : lista_cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta;
            }
        }
        return null;
    }

    public boolean ingresoCuenta(String iban, double cantidad) {
        CuentaBancaria cuenta = buscarCuenta(iban);
        if (cuenta != null) {
            cuenta.ingresar(cantidad);
            return true;
        }
        return false;
    }

    public boolean retiradaCuenta(String iban, double cantidad) {
        CuentaBancaria cuenta = buscarCuenta(iban);
        if (cuenta != null) {
            return cuenta.retirar(cantidad);
        }
        return false;
    }

    public double obtenerSaldo(String iban) {
        CuentaBancaria cuenta = buscarCuenta(iban);
        return (cuenta != null) ? cuenta.getSaldo() : -1;
    }

    public String informacionCuenta(String iban) {
        for (CuentaBancaria cuenta : lista_cuentas) {
            if (cuenta.getIban().equals(iban)) {
                return cuenta.devolverInfoString();  // Devolver la información de la cuenta si se encuentra
            }
        }
        return null;  // Si no se encuentra ninguna cuenta con ese IBAN, devuelve null
    }

}
