package test;

import java.util.Arrays;

public class TestArreglos {

    public static void main(String[] args) {
        int edades[] = new int[3];
        //Declaraicion = Intancia dentro del corchete se pone el número de elementos
        System.out.println("edades = " + Arrays.toString(edades));//Método toString para el objeto Array

        //Asignación de valores a los arreglos
        edades[0] = 10;
        //Acceder al valor del arreglo
        System.out.println("edades = " + edades[0]);

        //Error en tiempo de ejecución
        //edades[3]=5;
        for (int i = 0; i < edades.length; i++) {
            System.out.println("Edades elemento " + i + ": " + edades[i]);
        }

        //Creación de una matriz para ejempleficarlo en Java}
        int edadesMatriz[][] = new int[3][2];
        System.out.println("edadesMatriz = " + edadesMatriz);
        edadesMatriz[0][0] = 5;
        edadesMatriz[0][1] = 3;
        edadesMatriz[1][0] = 7;
        edadesMatriz[1][1] = 8;

        System.out.println("edadesMatriz 0-0 = " + edadesMatriz[0][0]);
        System.out.println("edadesMatriz 0-1 = " + edadesMatriz[0][1]);

        for (int renglon = 0; renglon < edadesMatriz.length; renglon++) {
            for (int columna = 0; columna < edadesMatriz[renglon].length; columna++) {
                System.out.println("Edades Matriz: " + renglon + "-" + columna + ": " + edadesMatriz[renglon][columna]);

            }
        }

    }

}
