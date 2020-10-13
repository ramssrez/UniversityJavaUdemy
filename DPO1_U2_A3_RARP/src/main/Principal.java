package main;

import clases.Personal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String arg []){
        System.out.println("Bienvenidos al registro de personal");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("1. Registro de Personal");
            System.out.println("2. Cantidad de hombres mayores de 50 años");
            System.out.println("3. Cantidad de mujeres mayores de 50 años");
            System.out.println("4. Cantidad de hombres con alguna comorbilidad");
            System.out.println("5. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        char sexo;
                        int edad;
                        boolean morvido;
                        
                        System.out.println("Has seleccionado la opcion 1");
                        Personal personal1 = new Personal('M',50,true);
                        System.out.println("Ingresa el sexo");
                        sexo = sn.next().charAt(0);
                        System.out.println("Ingresa la edad: ");
                        edad = sn.nextInt();
                        System.out.println("¿Tiene enfermedad?");
                        morvido = sn.nextBoolean();
                        Personal personal2 = new Personal('F',edad,morvido);
                        System.out.println("personal2 = " + personal2);
                        System.out.println("personal1 = " + personal1.toString());
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        break;
                    case 4:
                        System.out.println("Haz seleccionado la opción 4");
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Adiós");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número" + e);
                sn.next();
            }
        }
    }
}

