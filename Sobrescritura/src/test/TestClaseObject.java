package test;

import clases.Empleado;

//Uso de la clase Object
public class TestClaseObject {

    public static void main(String[] args) {
        Empleado empleado = new Empleado("Juan", 5000);
        Empleado empleado1 = new Empleado("Juan", 5000);
        System.out.println(empleado.toString());
        System.out.println(empleado1.toString());

        //Uso de las clases para comparar las referencias de memoria
        if (empleado == empleado1) {
            System.out.println("Tienen la misma referecia en memoria");
        } else {
            System.out.println("Tienen distinta referencia en memoria");
        }
        
        
        
    }
}
