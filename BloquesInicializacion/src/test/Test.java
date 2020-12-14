package test;

import domain.Persona;

public class Test {

    public static void main(String[] args) {
        Persona persona1 = new Persona();
        System.out.println("persona1 = " + persona1);
        System.out.println("");
        Persona persona2 = new Persona();
        System.out.println("persona2 = " + persona2);
        
        
        //El siguiente bloque es para hacer uso de ForEach para Java
        //Para nuestro caso, es el uso de los arreglos y como recorrerlos
        int edades[] = {5,8,9,4,3,1,6,4};
        Persona personas[] = {persona1,persona2, new Persona(), new Persona()};
        //Uso anterior para recorrer un arreglo
        for (int i = 0; i < edades.length; i++) {
            System.out.println("i = " + edades[i]);
        }
        //Se declara el tipo de dato y despues el arreglo a recorrer
        //ya no se cuenta con el acceso de los indices del arreglo
        for (int edad : edades) {
            System.out.println("edad = " + edad);
        }
        
        for (Persona persona:personas){
            System.out.println("persona = " + persona);
        }
    }
}
