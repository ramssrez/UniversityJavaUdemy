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
        int edades[] = {5, 8, 9, 4, 3, 1, 6, 4};
        Persona personas[] = {persona1, persona2, new Persona(), new Persona()};
        //Uso anterior para recorrer un arreglo
        for (int i = 0; i < edades.length; i++) {
            System.out.println("i = " + edades[i]);
        }
        //Se declara el tipo de dato y despues el arreglo a recorrer
        //ya no se cuenta con el acceso de los indices del arreglo
        for (int edad : edades) {
            System.out.println("edad = " + edad);
        }

        for (Persona persona : personas) {
            System.out.println("persona = " + persona);
        }

        //El siguiente codigo es para el uso de Unboxing y Autoboxing
        //Clases envolventes de tipo primitivos
        /*
        int - Integer
        long - Long
        float- Float
        double - Double
        boolen - Boolean
        byte - Byte
        char - Character
        short - Short
    //Las ventajas que presenta es que contienen métodos que podemos utilizar
         */
        int entero = 10;
        System.out.println("entero = " + entero);
        //Esta conversión se le conoce como Autoboxing
        Integer enterodos = 10;
        System.out.println("enterodos = " + enterodos.doubleValue());
        
        //Por otra parte la opción de Unboxing es lo inverso a lo anterior, 
        //Estrayendo el valor anterior
        entero = enterodos;
        System.out.println("entero = " + entero);
        
    }
}
