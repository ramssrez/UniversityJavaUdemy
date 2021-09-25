
package test;

import domain.Persona;
import java.util.Scanner;

public class TestArreglosObjetos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroPersonas;
        String nombre;
        int edad;
        System.out.println("Ingresa el numero de personas: ");
        numeroPersonas = sc.nextInt();
        Persona personas [] = new Persona[numeroPersonas];
        personas[0]=new Persona("Jose",25);
        personas[1] = new Persona ("Karla",28);
        
        System.out.println("persona [0] = " + personas[0]);
        System.out.println("persona [1] = " + personas[1]);
        
        for (int i = 0; i<personas.length;i++){
            Scanner scFor = new Scanner(System.in);
            System.out.println("Ingresa el nombre de la persona " + i +":");
            nombre = scFor.nextLine();
            System.out.println("Ingresa la edad de la persona " + i +":");
            edad = scFor.nextInt();
            personas[i]=new Persona(nombre,edad);
            System.out.println("----------------------------------------------------");
        }
        
        for (int i = 0; i<personas.length;i++){
            System.out.println("Persona " + i + ": "+ personas[i]);
        }
    }
}
