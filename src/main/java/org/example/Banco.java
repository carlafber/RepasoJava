package org.example;

import java.util.ArrayList;

public class Banco {
    ArrayList<CuentaBancaria> lista_cuentas = new ArrayList<>();
    public static boolean abrirCuenta (CuentaBancaria cuenta) {
        lista_cuentas.add(cuenta);
        for(CuentaBancaria cuentaBancaria : lista_cuentas);
        return false;
    }
}
