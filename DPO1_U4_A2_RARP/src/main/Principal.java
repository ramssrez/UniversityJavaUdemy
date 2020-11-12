package main;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        String areas[] = {"Administración", "Operaciones", "Recursos Humanos"};
        int modulos[] = {1, 2};
        double salario[][] = new double[modulos.length][areas.length];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa los valores que se te solicitan ");
        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1) + ": ");
            for (int j = 0; j < areas.length; j++) {
                System.out.println("Departamento de " + areas[j]);
                System.out.print("Ingresa el salario del jefe: $");
                salario[i][j] = scanner.nextDouble();
            }
            System.out.println("****************************************************************************************+*******");
        }

        for (int i = 0; i < modulos.length; i++) {
            System.out.println("Modulo " + (i + 1) + ": ");
            for (int j = 0; j < areas.length; j++) {
                System.out.println("Departamento de " + areas[j]);
                System.out.println("Jefe encargado gana: $1500" + salario[i][j]);
            }
            System.out.println("****************************************************************************************+*******");
        }

    }
}
