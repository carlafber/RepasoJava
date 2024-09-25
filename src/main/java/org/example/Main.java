package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = -1;
        try {
            do {
                System.out.println("MENÚ:\n  1. Abrir una nueva cuenta\n  2. Ver un listado de las cuentas disponibles." +
                        "\n  3. Obtener los datos de una cuenta concreta.\n  4. Realizar un ingreso en una cuenta." +
                        "\n  5. Retirar efectivo de una cuenta.\n  6. Consultar el saldo actual de una cuenta." +
                        "\n  ---------------------------------------------\n  0. SALIR  ");
                System.out.print("Seleccione una opción: ");
                opcion = in.nextInt();
                in.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println("Para abrir una nueva cuenta, introduzca los siguientes datos:");
                        System.out.print("Nombre: ");
                        String nombre = in.nextLine();
                        System.out.print("Apellidos: ");
                        String apellidos = in.nextLine();
                        System.out.print("DNI: ");
                        String dni = in.nextLine();
                        Persona persona = new Persona(nombre, apellidos, dni);
                        System.out.print("Saldo inicial de la cuenta: ");
                        double saldo = in.nextDouble();
                        System.out.print("IBAN de la cuenta (formato ESnnnnnnnnnnnnnnnnnnnn, donde n es un dígito del 0 al 9): ");
                        String iban = in.nextLine();
                        System.out.print("Tipo de cuenta. 1: cuenta de ahorro. 2: cuenta corriente personal. 3: cuenta corriente de empresa.");
                        int tipo = in.nextInt();
                        switch (tipo) {
                            case 1:
                                System.out.print("Para crear una cuenta de ahorro, introduzca el tipo de interés de remuneración:");
                                double tipo_interes = in.nextDouble();
                                CuentaBancaria cuentaBancaria = new CuentaAhorro(persona, saldo, iban, tipo_interes);
                                break;
                            case 2:
                                System.out.print("Para crear una cuenta corriente personal");
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        break;
                }

            } while (opcion != 0);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}