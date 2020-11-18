package main;

import clases.CuentaBancaria;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaCuentaBancaria {

    //Declaración de varibale global de tipo CuentaBancaria
    public static CuentaBancaria cuentaBancaria = null;

    //Inicio de la función principal main
    public static void main(String[] args) {
        //Declaración de varaibles para hacer uso del menú
        boolean salir = false;
        //Guardaremos la opcion del usuario
        int opcion;
        //Uso de la clase Scanner para recibir valores de la consola
        Scanner scan = new Scanner(System.in);
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

                    //Caso 1 en donde se realiza la creación de una nueva cuenta bancaria
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Asignación de la variable global con el llamado de un método que se encarga de crear una cuenta
                        //cuentaBancaria = crearCuenta();
                        cuentaBancaria = new CuentaBancaria("Jose", "1234", 15000.0);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 donde se realiza el abono de saldo a la cuenta
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que se encarga de validar si ya se encuentra el objeto de tipo CuentaBancaria creado
                        validarOpciones(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3. donde se realiza el retiro de saldo de la cuenta
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que se encarga de validar si ya se encuentra el objeto de tipo CuentaBancaria creado
                        validarOpciones(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 4 donde se realiza la consulta de saldo, ingresando las credenciales que son el nombre del ususario y numero de cuenta
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que se encarga de validar si ya se encuentra el objeto de tipo CuentaBancaria creado
                        validarOpciones(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 5 donde se consulta de los movimientos que se ha realizado en la cuenta
                    case 5:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que se encarga de validar si ya se encuentra el objeto de tipo CuentaBancaria creado
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

    //Método que se encarga de la creación de una cuenta bancaria
    public static CuentaBancaria crearCuenta() {
        //Declaración de variables locales del método
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String numeroCuenta;
        double saldoInicial;
        CuentaBancaria cuenta = null;
        //Solicitud de datos para poder crear la cuenta
        System.out.print("Ingresa el nombre del usuario: ");
        nombre = scanner.nextLine();
        System.out.print("Ingresa el número de cuenta: ");
        numeroCuenta = scanner.nextLine();
        System.out.print("Ingresa el monto inicial: ");
        saldoInicial = scanner.nextDouble();

        //Validación para el caso de que el usuario haya ingresado cadenas vacías o saldos negativos
        if ((nombre.equals("")) || (numeroCuenta.equals(""))) {
            System.out.println("No se puede crear la cuenta, el nombre del usuario o el número de cuenta están vacíos");
        } else if (saldoInicial < 0) {
            System.out.println("Se ha ingresado un saldo negativo, no se puede crear la cuenta");
        } else {
            //Creación del objeto CuentaBancaria en caso de que este correctos los parametros de entrada
            cuenta = new CuentaBancaria(nombre, numeroCuenta, saldoInicial);
        }
        //Regreso del parámetro de tipo CuentaBancaria
        return cuenta;
    }

    //Método que realiza el abono de saldo a la cuenta.
    public static void realizarAbono() {
        //Declaración de variables locales
        Scanner scanner = new Scanner(System.in);
        double saldoIngresado;
        //Impresión del saldo actual
        System.out.println("Tu saldo actual es: " + cuentaBancaria.getSaldo());
        //Solicitud del saldo a ingresar
        System.out.print("Ingresa el monto a ingresar: ");
        saldoIngresado = scanner.nextDouble();
        //llamado del método que se encarga de asignar saldo a la cuenta
        cuentaBancaria.asignarSaldoCuenta(saldoIngresado);
        //Impresión del saldo actualizado
        System.out.println("Tu saldo actualizado es: " + cuentaBancaria.getSaldo());
    }

    //Método que se encarga de realizar el retiro de saldo de la cuenta bancaria
    public static void realizarRetiro() {
        //Declaración de variables locales
        Scanner scanner = new Scanner(System.in);
        double saldoRetirar;
        //Solicitud del saldo a retirar
        System.out.println("Ingresa el monto a retirar: ");
        saldoRetirar = scanner.nextDouble();
        //Llamado del método que se encarga de realizar el retiro de saldo
        cuentaBancaria.retiroSaldoCuenta(saldoRetirar);
    }

    //Método que se encarga de consultar saldo
    public static void consultarSaldo() {
        //Declaracón de variables locales
        Scanner scanner = new Scanner(System.in);
        String nombre;
        String numeroCuenta;
        double saldo;

        //Solicitud de los datos para poder realizar la consulta de saldo
        System.out.print("Ingresa el nombre del usuario: ");
        nombre = scanner.nextLine();
        System.out.print("Ingresa el número de cuenta: ");
        numeroCuenta = scanner.nextLine();
        //Llmado al método que se encarga de consultar saldo de la cuenta
        saldo = cuentaBancaria.consultarSaldo(nombre, numeroCuenta);
        //Impresion del saldo que se ha obtenido del método
        System.out.println("Tu saldo es " + saldo);

    }

    //Validación para observar si la variable global de tipo CuentaBancaria tenga valores
    public static void validarOpciones(int opcion) {
        //Sentencia para el caso que sea nulo la varaible global
        if (cuentaBancaria == null) {
            System.out.println("No se ha registrado una cuenta");
        } else if (opcion == 2) {
            //Sentencia que manda a llamar un método para realizar un abono a la cuenta
            realizarAbono();
        } else if (opcion == 3) {
            //Sentencia que manda a llamar un método que realza un retiro de la cuenta
            realizarRetiro();
        } else if (opcion == 4) {
            //Sentencia que manda a llamar un método que realiza la consulta de saldo de la cuenta
            consultarSaldo();
        } else if (opcion == 5) {
            //Sentencia que se encarga de imprimir los movimienos que se ha realizado en la cuenta
            cuentaBancaria.movimientos();
        }
    }
}
