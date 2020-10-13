
package test;

import domain.Persona;
import java.util.Scanner;

public class TestArreglosObjetos {
    public static void main(String[] args) {
        Persona personas [] = new Persona[2];
        personas[0]=new Persona("Jose",25);
        personas[1] = new Persona ("Karla",28);
        
        System.out.println("persona [0] = " + personas[0]);
        System.out.println("persona [1] = " + personas[1]);
        
        for (int i = 0; i<personas.length;i++){
            Scanner sc = new Scanner(System.in);
            String nombre;
            int edad;
            System.out.print("Ingresa el nombre de la persona " + i +":");
            nombre = sc.nextLine();
            System.out.print("Ingresa la edad de la persona " + i +":");
            edad = sc.nextInt();
            personas[i]=new Persona(nombre,edad);
            System.out.println("----------------------------------------------------");
        }
        
        for (int i = 0; i<personas.length;i++){
            System.out.println("Persona " + i + ": "+ personas[i]);
        }
    }
}
