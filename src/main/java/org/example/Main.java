package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion;
        System.out.println("MENÚ:\n  1. Abrir una nueva cuenta\n  2. Ver un listado de las cuentas disponibles." +
                "\n  3. Obtener los datos de una cuenta concreta.\n  4. Realizar un ingreso en una cuenta." +
                "\n  5. Retirar efectivo de una cuenta.\n  6. Consultar el saldo actual de una cuenta." +
                "\n  ---------------------------------------------\n  0. SALIR  ");
        System.out.println("Seleccione una opción:");
    }
}