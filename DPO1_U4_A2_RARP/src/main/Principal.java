package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        Scanner scan = new Scanner(System.in);
        String areas[] = {"Administración", "Operaciones", "Recursos Humanos"};
        int modulos[] = {1, 2};
        double salario[][] = null;
        //new double[modulos.length][areas.length];

        System.out.println("Ingresa alguna de las opciones para ingresar los salarios de los jefes de cada área");
        while (!salir) {
            System.out.println("1.- Regitrar salarios de los módulos");
            System.out.println("2.- Imprimir salarios de los módulos");
            System.out.println("3.- Salir");
            try {
                System.out.print("Selecciona una de la opciones: ");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        salario = ingresarSalarios(areas, modulos);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        if (salario == null) {
                            System.out.println("No se han ingresado salarios, vuelve a la opción 1");
                        } else {
                            retornarSalarios(areas, modulos, salario);
                        }
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Has seleccionado la opción 3");
                        System.out.println("Gracias por tu visita. Adiós!!!!!");
                        salir = true;
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("ERROR, el número no corresponde al rango de 1 a 7");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.println("Debes de ingresar un número");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                scan.next();
            }

        }

    }

    public static double[][] ingresarSalarios(String areas[], int modulos[]) {
        System.out.println("Has seleccionado la opcion 1");
        System.out.println("Ingresa los salarios de los jefes de cada área");
        System.out.println("****************************************************************************************+*******");
        double salario[][] = new double[modulos.length][areas.length];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1) + ": ");
            for (int j = 0; j < areas.length; j++) {
                System.out.println("Departamento de " + areas[j]);
                System.out.print("Ingresa el salario del jefe: $");
                salario[i][j] = scanner.nextDouble();
            }
            System.out.println("****************************************************************************************+*******");
        }
        return salario;
    }

    public static void retornarSalarios(String areas[], int modulos[], double salario[][]) {
        System.out.println("Has seleccionado la opcion 2");
        System.out.println("La información de los salarios se presenta a continuación");
        System.out.println("****************************************************************************************+*******");
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1) + ": ");
            for (int j = 0; j < areas.length; j++) {
                System.out.println("Departamento de " + areas[j]);
                System.out.println("Jefe encargado gana: $" + salario[i][j]);
            }
            System.out.println("****************************************************************************************+*******");
        }

    }
}
