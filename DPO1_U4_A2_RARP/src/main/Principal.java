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
        double salario[][] = new double[modulos.length][areas.length];

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
                        System.out.println("Opción 1");
                        salario = ingresarSalarios(areas, modulos);
                        break;
                    case 2:
                        System.out.println("Opción 2");
                        break;
                    case 3:
                        System.out.println("Salir");
                        salir = true;
                        break;
                    default:
                        System.out.println("Ingresa un valor entre 1 y 3");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes de ingresar un números");
                scan.next();
            }

        }

//        double salario[][] = new double[modulos.length][areas.length];
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Ingresa los valores que se te solicitan ");
//        for (int i = 0; i < modulos.length; i++) {
//            System.out.println("Modulo " + (i + 1) + ": ");
//            for (int j = 0; j < areas.length; j++) {
//                System.out.println("Departamento de " + areas[j]);
//                System.out.print("Ingresa el salario del jefe: $");
//                salario[i][j] = scanner.nextDouble();
//            }
//            System.out.println("****************************************************************************************+*******");
//        }
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1) + ": ");
            for (int j = 0; j < areas.length; j++) {
                System.out.println("Departamento de " + areas[j]);
                System.out.println("Jefe encargado gana: $" + salario[i][j]);
            }
            System.out.println("****************************************************************************************+*******");
        }

    }

    public static double[][] ingresarSalarios(String areas[], int modulos[]) {
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

    public static void retornarSalarios() {

    }
}
