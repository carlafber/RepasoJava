package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Banco banco = new Banco(); //se crea una instancia de la clase banco, para ghestionar las cuentas bancarias
        int opcion = -1; //se inicializa la opción a -1 para que no coincida con ninguna de las opciones disponibles

        try {
            do {
                System.out.println("\nMENÚ:\n  1. Abrir una nueva cuenta\n  2. Ver un listado de las cuentas disponibles." +
                        "\n  3. Obtener los datos de una cuenta concreta.\n  4. Realizar un ingreso en una cuenta." +
                        "\n  5. Retirar efectivo de una cuenta.\n  6. Consultar el saldo actual de una cuenta." +
                        "\n  ---------------------------------------------\n  0. SALIR  "); //se muestra el menú
                System.out.print("Seleccione una opción: "); //y el usuario introduce su opcion
                opcion = in.nextInt(); //se limpia el buffer
                in.nextLine();

                switch (opcion) { //switch para realizar la acción según la opción seleccionada
                    case 1: //abrir una nueva cuenta
                        System.out.println("Para abrir una nueva cuenta, introduzca los siguientes datos:");
                        System.out.print("Nombre: ");
                        String nombre = in.nextLine(); //se lee el nombre del titular de la cuenta
                        System.out.print("Apellidos: ");
                        String apellidos = in.nextLine(); //se leen los apellidos del titular de la cuenta
                        System.out.print("DNI: ");
                        String dni = in.nextLine(); //se lee el dni del titular de la cuenta
                        Persona titular = new Persona(nombre, apellidos, dni); //se crea un objeto 'Persona' con los datos introducidos
                        System.out.print("Saldo inicial de la cuenta: ");
                        double saldo = in.nextDouble(); //se lee el saldo inicial de la cuenta
                        in.nextLine(); //se limpia el buffer para que no salte directamente a la siguiente entrada ('tipo de cuenta')
                        System.out.print("IBAN de la cuenta (formato ESnnnnnnnnnnnnnnnnnnnn): ");
                        String iban = in.nextLine(); //se lee el número de cuenta
                        System.out.print("Tipo de cuenta.\n1: Cuenta de ahorro\n2: Cuenta corriente personal\n3: Cuenta corriente de empresa\nSeleccione una opción: ");
                        int tipo = in.nextInt(); //se lee el tipo de cuenta que desea el usuario
                        in.nextLine();

                        switch (tipo) { //para elegir el tipo de cuenta que se va a crear
                            case 1: //cuenta de ahorro
                                System.out.print("Para crear una cuenta de ahorro, introduzca el tipo de interés de remuneración: ");
                                double tipo_interes = in.nextDouble(); //se lee el tipo de interés
                                CuentaBancaria cuentaAhorro = new CuentaAhorro(titular, saldo, iban, tipo_interes); //se crea una cuenta de ahorro
                                if (banco.abrirCuenta(cuentaAhorro)) { //se intenta abrir la cuenta en el banco
                                    System.out.println("Cuenta de ahorro abierta correctamente.");
                                } else {
                                    System.out.println("Error al abrir la cuenta.");
                                }
                                break;
                            case 2: //cuenta corriente personal
                                System.out.print("Para crear una cuenta corriente personal, introduzca la comisión de mantenimiento anual: ");
                                double comision = in.nextDouble(); //se lee la comisión
                                in.nextLine();
                                System.out.print("Introduzca las lista_entidades autorizadas (separadas por comas): ");
                                String lista_entidades = in.nextLine();  //se lee la lista de entidades autorizadas
                                CuentaBancaria cuentaPersonal = new CuentaCorrientePersonal(titular, saldo, iban, lista_entidades, comision);  //se crea una cuenta corriente personal
                                if (banco.abrirCuenta(cuentaPersonal)) {
                                    System.out.println("Cuenta corriente personal abierta correctamente.");
                                } else {
                                    System.out.println("Error al abrir la cuenta.");
                                }
                                break;
                            case 3: //cuenta corriente de empresa
                                System.out.print("Para crear una cuenta corriente de empresa, introduzca el máximo descubierto permitido: ");
                                double maximo_descubierto = in.nextDouble();
                                System.out.print("Tipo de interés por descubierto: ");
                                double tipoInteres_descubierto = in.nextDouble();
                                System.out.print("Comisión fija por descubierto: ");
                                double comision_fija_descubierto = in.nextDouble();
                                in.nextLine();
                                System.out.print("Introduzca las lista_entidades autorizadas (separadas por comas): ");
                                String lista_entidades_empresa = in.nextLine();  //se lee la lista de entidades autorizadas
                                //se crea la cuenta corriente de empresa
                                CuentaBancaria cuentaEmpresa = new CuentaCorrienteEmpresa(titular, saldo, iban, lista_entidades_empresa, tipoInteres_descubierto, maximo_descubierto, comision_fija_descubierto);
                                if (banco.abrirCuenta(cuentaEmpresa)) {
                                    System.out.println("Cuenta corriente de empresa abierta correctamente.");
                                } else {
                                    System.out.println("Error al abrir la cuenta.");
                                }
                                break;
                            default: //si se proporciona un número diferente de los especificados, avisa del error
                                System.out.println("Tipo de cuenta no válido.");
                        }
                        break;

                    case 2: //ver listado de todas las cuentas
                        System.out.println("Listado de cuentas disponibles:");
                        String[] cuentas = banco.listadoCuentas(); //obtener el listado de las cuentas
                        for (String cuenta : cuentas) {
                            System.out.println(cuenta); //imprimir las cuentas
                        }
                        break;

                    case 3: //obtener los datos de una cuenta concreta
                        System.out.print("Ingrese el IBAN de la cuenta que desea consultar: ");
                        String iban_consulta = in.nextLine();
                        String info_cuenta = banco.informacionCuenta(iban_consulta); //se obtiene la información de la cuenta
                        if (info_cuenta != null) {
                            System.out.println("Datos de la cuenta:\n" + info_cuenta); //se muestra la información
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                        break;

                    case 4: //realizar un ingreso en una cuenta
                        System.out.print("Ingrese el IBAN de la cuenta para realizar el ingreso: ");
                        String iban_ingreso = in.nextLine();
                        System.out.print("Ingrese la cantidad a ingresar: ");
                        double cantidad_ingreso = in.nextDouble();
                        if (banco.ingresoCuenta(iban_ingreso, cantidad_ingreso)) { //realizar el ingreso
                            System.out.println("Ingreso realizado con éxito.");
                        } else {
                            System.out.println("Error al realizar el ingreso.");
                        }
                        break;

                    case 5: //retirar efectivo de una cuenta
                        System.out.print("Ingrese el IBAN de la cuenta para retirar efectivo: ");
                        String iban_retiro = in.nextLine();
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double cantidad_retiro = in.nextDouble();
                        if (banco.retiradaCuenta(iban_retiro, cantidad_retiro)) { //realizar el retiro
                            System.out.println("Retiro realizado con éxito.");
                        } else {
                            System.out.println("Error al realizar el retiro.");
                        }
                        break;

                    case 6: //consultar el saldo de una cuenta
                        System.out.print("Ingrese el IBAN de la cuenta para consultar el saldo: ");
                        String iban_saldo = in.nextLine();
                        double saldo_cuenta = banco.obtenerSaldo(iban_saldo); //obtener el saldo
                        if (saldo_cuenta != -1) {
                            System.out.println("El saldo actual de la cuenta es: " + saldo_cuenta + "€");
                        } else {
                            System.out.println("Cuenta no encontrada.");
                        }
                        break;

                    case 0: //salir
                        System.out.println("Saliendo del programa...");
                        break;

                    default: //en caso de opción no válida
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 0); //se sigue ejecutando el menú hasta que el usuario seleccione salir (opción 0)
        } catch (Exception e) { //se maneja cualquier excepción que ocurra durante la ejecución
            System.out.println("Error: " + e.getMessage());
        }
    }
}