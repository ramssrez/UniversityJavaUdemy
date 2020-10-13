
package test;

import domain.Persona;

public class TestArreglosObjetos {
    public static void main(String[] args) {
        Persona personas [] = new Persona[2];
        personas[0]=new Persona("Jose",25);
        personas[1] = new Persona ("Karla",28);
        
        System.out.println("persona [0] = " + personas[0]);
        System.out.println("persona [1] = " + personas[1]);
    }
}
