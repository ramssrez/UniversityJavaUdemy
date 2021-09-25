package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        int numeros[] = {1, 4, 2, 3};
        /*
        Primer ejemplo de la sentencia Try/catch, en la cual se tiene un tipo de Excepción
        de tipo ArrayIndexOutOfBoundsException, esta excepción es lanzada para indicar que se ha accedido
        a un vector con un índice que no existe, ya sea mayor al tamaño del vector o negativo, en nuestro caso 
        queremos entrar al indice 10 de nuestro vector, pero solo tiene cuatro elementos.
         */
        try {
            System.out.println(numeros[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }

        /*
        Segundo ejemplo de la sentencia Try/catch, en la cual se tiene un tipo de Excepción
        de tipo InputMismatchException, esta excepción es lanzada por el Scanner para indicar 
        que lo que se ingreso de la consola, no coincide con lo que necesitamos, en nuestro caso declaramos la variable como entero e 
        ingresamos una letra o String, de esta manera tronaría nuestro programa, pero con la excepción se mandaría un mensaje de que se debe 
        ingresar npumeros
         */
        int opcion;
        Scanner sn = new Scanner(System.in);
        try {
            System.out.print("Ingresa un número no una letra: ");
            opcion = sn.nextInt();
        } catch (InputMismatchException e) {
            //InputMismatchException e
            System.out.println("Debes insertar un número " + e.getMessage());
        }

    }

}
