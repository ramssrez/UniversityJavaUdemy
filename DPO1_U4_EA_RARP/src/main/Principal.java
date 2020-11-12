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
        while (!salir) {
            //Impresión de las opciones del menú
            System.out.println("1.- Reservar");
            System.out.println("2.- Cancelar Reserva");
            System.out.println("3.- Consular");
            System.out.println("4.- Salir");
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
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 donde se verifica si ya hay información de los salarios y en caso afirmativo imprimir los salarios de las diferetes áreas
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Sentencia if/else que verifica si el arreglo contiene datos

                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;

                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3 donde da por terminado el programa y sale del menú
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Has seleccionado la opción 4");
                        System.out.println("Gracias por tu visita. Adiós!!!!!");
                        salir = true;
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso default que manda un error en caso de que no se cumpla con las tres primeras opciones
                    default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("ERROR, el número no corresponde al rango de 1 a 4");
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
}
