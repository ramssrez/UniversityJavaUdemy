package test;

import java.util.Arrays;

public class TestArreglos {
    public static void main(String[] args) {
        int edades[] = new int[3];
        //Declaraicion = Intancia dentro del corchete se pone el número de elementos
        System.out.println("edades = " + Arrays.toString(edades));//Método toString para el objeto Array
        
        //Asignación de valores a los arreglos
        edades[0]=10;
        //Acceder al valor del arreglo
        System.out.println("edades = " + edades[0]);
    }
    
}
