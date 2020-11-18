package main;

import clases.CuentaBancaria;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaCuentaBancaria {

    public static CuentaBancaria cuentaBancaria = null;

    public static void main(String[] args) {
        //Declaración de varaibles para hacer uso del menú
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        //Uso de la clase Scanner para recibir valores de la consola
        Scanner scan = new Scanner(System.in);
        //Impresión de una pequeña introducción para hacer uso del sistema
        //Comienzo del ciclo repetitivo while para el menú
        while (!salir) {
            //Impresión de las opciones del menú
            System.out.println("\n1.- Dar de alta datos del cliente");
            System.out.println("2.- Realizar Abono");
            System.out.println("3.- Realizar Retiro");
            System.out.println("4.- Consultar Saldo");
            System.out.println("5.- Consultar movimientos");
            System.out.println("6.- Salir");
            //Uso de la sentecia try/catch para que solo ingrese un número
            try {
                System.out.print("Selecciona una de la opciones: ");
                opcion = scan.nextInt();
                scan.nextLine();
                //Uso de la sentencia switch para las opciones del menú
                switch (opcion) {

                    //Caso 1 en donde se realiza la reserva de un asiento
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Asignación de la variable local para poder crear los objetos de tipo Reserva                       
                        //cuentaBancaria = crearCuenta();
                        cuentaBancaria = new CuentaBancaria("Jose", "1234", 15000.0);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 donde se realiza la cancelación de la reserva de nuestro programa
                    case 2:                            
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        validarOpciones(opcion);
                        //Llamado del métodoq que se encarga de realizar la cancelación de la reserva, con parámetros de entrada como el arreglo bidimencional de tipo asiento
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3. donde se realiza la consulta de la reserva realizada en la opción uno, un función del número de asiento
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        validarOpciones(opcion);
                        //Llamado del método que realiza la consulta de aseintos de nuestro sistema de reservas
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 4 donde da por terminado el programa y sale del menú, además de imprimir los lugares del avión ocupado y las reservas solicitadas
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        validarOpciones(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 5 donde da por terminado el programa y sale del menú, además de imprimir los lugares del avión ocupado y las reservas solicitadas
                    case 5:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //cuentaBancaria.movimientos()
                        validarOpciones(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;

                    //Caso 6 donde da por terminado el programa y salida del menú
                    case 6:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("\nGracias por tu visita. Adiós!!!!!\n");
                        //Asignación para que salga del menú y de por finalizada la ejecución del programa
                        salir = true;
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso default que manda un error en caso de que no se cumpla con las cuatra primeras opciones
                    default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("ERROR, el número no corresponde al rango de 1 a 6");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                }
            } catch (InputMismatchException e) {
                //Excepción en caso de que se ingrese una letra o un caracter que no sea igual al esperado
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.println("Debes de ingresar un número");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                scan.next();
            }

        }
    }

    public static CuentaBancaria crearCuenta() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String numeroCuenta;
        double saldoInicial;
        CuentaBancaria cuenta = null;

        System.out.print("Ingresa el nombre del usuario: ");
        nombre = scanner.nextLine();
        System.out.print("Ingresa el número de cuenta: ");
        numeroCuenta = scanner.nextLine();
        System.out.print("Ingresa el monto inicial: ");
        saldoInicial = scanner.nextDouble();

        if ((nombre.equals("")) || (numeroCuenta.equals(""))) {
            System.out.println("No se puede crear la cuenta, el nombre del usuario o el número de cuenta están vacíos");
        } else if (saldoInicial < 0) {
            System.out.println("Se ha ingresado un saldo negativo, no se puede crear la cuenta");
        } else {
            cuenta = new CuentaBancaria(nombre, numeroCuenta, saldoInicial);
        }
        return cuenta;
    }

    public static void realizarAbono() {
        Scanner scanner = new Scanner(System.in);
        double saldoIngresado;
        System.out.println("Tu saldo actual es: " + cuentaBancaria.getSaldo());
        System.out.print("Ingresa el monto a ingresar: ");
        saldoIngresado = scanner.nextDouble();
        cuentaBancaria.asignarSaldoCuenta(saldoIngresado);
        System.out.println("Tu saldo actualizado es: " + cuentaBancaria.getSaldo());
    }
    
    public static void realizarRetiro(){
        Scanner scanner = new Scanner(System.in);
        double saldoRetirar;
        System.out.println("Ingresa el monto a retirar: ");
        saldoRetirar = scanner.nextDouble();
        cuentaBancaria.retiroSaldoCuenta(saldoRetirar);
    }
    
    public static void consultarSaldo(){
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String numeroCuenta;
        double saldo;

        System.out.print("Ingresa el nombre del usuario: ");
        nombre = scanner.nextLine();
        System.out.print("Ingresa el número de cuenta: ");
        numeroCuenta = scanner.nextLine();
        saldo = cuentaBancaria.consultarSaldo(nombre, numeroCuenta);
        System.out.println("Tu saldo es " + saldo);
        
    }
    
    public static void validarOpciones(int opcion){
        if(cuentaBancaria == null){
            System.out.println("No se ha registrado una cuenta");
        }else if(opcion == 2){
            realizarAbono();
        }else if(opcion == 3){
            realizarRetiro();
        }else if(opcion == 4){
            consultarSaldo();
        }else if(opcion == 5){
            System.out.println("Ver movimientos");
            cuentaBancaria.movimientos();
                    
        }
    }
}
