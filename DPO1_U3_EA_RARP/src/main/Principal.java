//Nombre del paquete donde se encuentra esta clase
package main;
//Impirtación de las clases de otro paqeute

import clases.*;

public class Principal {

    //Creación del método principal main
    public static void main(String[] args) {
        System.out.println("*****************************************************************************************************");
        System.out.println("Uso de clases abstractas");
        //Creación del objeto empleado
        Empleado empleado = new Empleado("Jesus", "Ezquivel", "Hernandez", 1500);
        //Ingreso de la fecha de nacimiento del empleado
        empleado.asignarEdad("27/06/1992");
        //Impresion en pantalla del objeto empleado
        System.out.println(empleado.toString());
        
        //Creación del objeto estudiante
        Estudiante estudiante = new Estudiante("Raúl", 8.5f);
        //Ingreso de la fecha de nacimiento del alumno
       estudiante.asignarEdad("17/01/1994");
        //Impresion en pantalla del objeto alumno
        System.out.println(estudiante.toString());

        System.out.println("*****************************************************************************************************");
        System.out.println("Uso de interfaces");
        //Creación del objeto ingresarNombre
        IngresarNombre ingresarNombre = new IngresarNombre();
        //Uso de los diferentes métodos que se tiene en la clase ingresarNombre
        ingresarNombre.ingresarNombre("Jose");
        //Impresión de pantalla del parametro que ingresamos
        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());
        ingresarNombre.ingresarNombre("Jose", "Rodriguez");
        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());
        ingresarNombre.ingresarNombre("Jose", "Rodriguez", "Ramirez");
        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());

    }
}
