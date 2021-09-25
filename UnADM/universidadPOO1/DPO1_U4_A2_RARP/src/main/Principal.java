package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //Declaración de varaibles para hacer uso del menú
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        //Uso de la clase Scanner para recibir valores de la consola
        Scanner scan = new Scanner(System.in);
        //Creación de arreglo donde contiene el nombre de las áreas
        String areas[] = {"Administración", "Operaciones", "Recursos Humanos"};
        //Arreglo que contiene el número de modulos
        int modulos[] = {1, 2};
        //Declaración del arerglo muldimensional para guardar los salarios
        double[][] salarios = null;
        System.out.println("Ingresa alguna de las opciones para ingresar los salarios de los jefes de cada área");
        //Inicio de ciclo while para realizar el menú
        while (!salir) {
            //Impresión de las opciones del menú
            System.out.println("1.- Regitrar salarios de los módulos");
            System.out.println("2.- Imprimir salarios de los módulos");
            System.out.println("3.- Salir");
            //Uso de la sentecia try/catch para que solo ingrese un número
            try {
                System.out.print("Selecciona una de la opciones: ");
                opcion = scan.nextInt();
                //Uso de la sentencia switch para las opciones del menú
                switch (opcion) {
                    //Caso 1 en donde se realiza el llenado de los salarios
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Asignación de ciclo bidimencional de arreglos con un método que se manda a llamar
                        salarios = ingresarSalarios(areas, modulos);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                     //Caso 2 donde se verifica si ya hay información de los salarios y en caso afirmativo imprimir los salarios de las diferetes áreas
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Sentencia if/else que verifica si el arreglo contiene datos
                        if (salarios == null) {
                            System.out.println("No se han ingresado salarios, vuelve a la opción 1");
                        } else {
                            retornarSalarios(areas, modulos, salarios);
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3 donde da por terminado el programa y sale del menú
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Has seleccionado la opción 3");
                        System.out.println("Gracias por tu visita. Adiós!!!!!");
                        salir = true;
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso default que manda un error en caso de que no se cumpla con las tres primeras opciones
                    default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("ERROR, el número no corresponde al rango de 1 a 3");
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

    //Método que realiza el llenado del areglo bidimensional
    public static double[][] ingresarSalarios(String areas[], int modulos[]) {
        System.out.println("Has seleccionado la opcion 1");
        System.out.println("Ingresa los salarios de los jefes de cada área");
        System.out.println("****************************************************************************************+*******");
        double[][] salarios = new double[modulos.length][areas.length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1) + ": ");
            for (int j = 0; j < areas.length; j++) {
                System.out.println("Departamento de " + areas[j]);
                System.out.print("Ingresa el salario del jefe: $");
                salarios[i][j] = scanner.nextDouble();
            }
            System.out.println("****************************************************************************************+*******");
        }
        return salarios;
    }

    //Método que realiza la impresión del arreglo biimensional
    public static void retornarSalarios(String areas[], int modulos[], double[][] salarios) {
        System.out.println("Has seleccionado la opcion 2");
        System.out.println("La información de los salarios se presenta a continuación");
        System.out.println("****************************************************************************************+*******");
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1));
            for (int j = 0; j < areas.length; j++) {
                System.out.println("Departamento de " + areas[j]);
                System.out.println("Jefe encargado gana: $" + salarios[i][j]);
            }
            System.out.println("****************************************************************************************+*******");
        }

    }
}
