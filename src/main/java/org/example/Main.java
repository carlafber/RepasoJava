package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Banco banco = new Banco(); // Crear instancia de Banco
        int opcion = -1;

        try {
            do {
                System.out.println("\nMENÚ:\n  1. Abrir una nueva cuenta\n  2. Ver un listado de las cuentas disponibles." +
                        "\n  3. Obtener los datos de una cuenta concreta.\n  4. Realizar un ingreso en una cuenta." +
                        "\n  5. Retirar efectivo de una cuenta.\n  6. Consultar el saldo actual de una cuenta." +
                        "\n  ---------------------------------------------\n  0. SALIR  ");
                System.out.print("Seleccione una opción: ");
                opcion = in.nextInt();
                in.nextLine(); // Limpiar buffer del scanner

                switch (opcion) {
                    case 1:
                        System.out.println("Para abrir una nueva cuenta, introduzca los siguientes datos:");
                        System.out.print("Nombre: ");
                        String nombre = in.nextLine();
                        System.out.print("Apellidos: ");
                        String apellidos = in.nextLine();
                        System.out.print("DNI: ");
                        String dni = in.nextLine();
                        Persona titular = new Persona(nombre, apellidos, dni);
                        System.out.print("Saldo inicial de la cuenta: ");
                        double saldo = in.nextDouble();
                        in.nextLine();
                        System.out.print("IBAN de la cuenta (formato ESnnnnnnnnnnnnnnnnnnnn): ");
                        String iban = in.nextLine();
                        System.out.print("Tipo de cuenta.\n1: Cuenta de ahorro\n2: Cuenta corriente personal\n3: Cuenta corriente de empresa\nSeleccione una opción: ");
                        int tipo = in.nextInt();
                        in.nextLine();

                        switch (tipo) {
                            case 1:
                                System.out.print("Para crear una cuenta de ahorro, introduzca el tipo de interés de remuneración: ");
                                double tipo_interes = in.nextDouble();
                                CuentaBancaria cuentaAhorro = new CuentaAhorro(titular, saldo, iban, tipo_interes);
                                if (banco.abrirCuenta(cuentaAhorro)) {
                                    System.out.println("Cuenta de ahorro abierta correctamente.");
                                } else {
                                    System.out.println("Error al abrir la cuenta.");
                                }
                                break;
                            case 2:
                                System.out.print("Para crear una cuenta corriente personal, introduzca la comisión de mantenimiento anual: ");
                                double comision = in.nextDouble();
                                CuentaBancaria cuentaPersonal = new CuentaCorrientePersonal(titular, saldo, iban, comision);
                                if (banco.abrirCuenta(cuentaPersonal)) {
                                    System.out.println("Cuenta corriente personal abierta correctamente.");
                                } else {
                                    System.out.println("Error al abrir la cuenta.");
                                }
                                break;
                            case 3:
                                System.out.print("Para crear una cuenta corriente de empresa, introduzca el máximo descubierto permitido: ");
                                double maximo_descubierto = in.nextDouble();
                                System.out.print("Tipo de interés por descubierto: ");
                                double tipoInteres_descubierto = in.nextDouble();
                                System.out.print("Comisión fija por descubierto: ");
                                double comision_fija_descubierto = in.nextDouble();
                                CuentaBancaria cuentaEmpresa = new CuentaCorrienteEmpresa(titular, saldo, iban, tipoInteres_descubierto, maximo_descubierto, comision_fija_descubierto);
                                if (banco.abrirCuenta(cuentaEmpresa)) {
                                    System.out.println("Cuenta corriente de empresa abierta correctamente.");
                                } else {
                                    System.out.println("Error al abrir la cuenta.");
                                }
                                break;
                            default:
                                System.out.println("Tipo de cuenta no válido.");
                        }
                        break;

                    case 2:
                        System.out.println("Listado de cuentas disponibles:");
                        String[] cuentas = banco.listadoCuentas();
                        for (String cuenta : cuentas) {
                            System.out.println(cuenta);
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese el IBAN de la cuenta que desea consultar: ");
                        String iban_consulta = in.nextLine();
                        String info_cuenta = banco.informacionCuenta(iban_consulta);
                        if (info_cuenta != null) {
                            System.out.println("Datos de la cuenta:\n" + info_cuenta);
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese el IBAN de la cuenta para realizar el ingreso: ");
                        String iban_ingreso = in.nextLine();
                        System.out.print("Ingrese la cantidad a ingresar: ");
                        double cantidad_ingreso = in.nextDouble();
                        if (banco.ingresoCuenta(iban_ingreso, cantidad_ingreso)) {
                            System.out.println("Ingreso realizado con éxito.");
                        } else {
                            System.out.println("Error al realizar el ingreso.");
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese el IBAN de la cuenta para retirar efectivo: ");
                        String iban_retiro = in.nextLine();
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidad_retiro = in.nextDouble();
                        if (banco.retiradaCuenta(iban_retiro, cantidad_retiro)) {
                            System.out.println("Retiro realizado con éxito.");
                        } else {
                            System.out.println("Error al realizar el retiro.");
                        }
                        break;

                    case 6:
                        System.out.print("Ingrese el IBAN de la cuenta para consultar el saldo: ");
                        String iban_saldo = in.nextLine();
                        double saldo_cuenta = banco.obtenerSaldo(iban_saldo);
                        if (saldo_cuenta != -1) {
                            System.out.println("El saldo actual de la cuenta es: " + saldo_cuenta + "€");
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                        break;

                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
