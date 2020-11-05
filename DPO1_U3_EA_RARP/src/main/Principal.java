//Nombre del paquete donde se encuentra esta clase
package main;
//Impirtación de las clases de otro paqeute

import clases.*;

public class Principal {

    //Creación del método principal main
    public static void main(String[] args) {
        System.out.println("*****************************************************************************************************");
        System.out.println("Uso de clases abstractas");
        Empleado empleado = new Empleado("Jesus", "Ezquivel", "Hernandez", 1500);
        //Ingreso de la fecha de nacimiento del empleado
        empleado.asignarEdad("27/06/1992");
        System.out.println(empleado.toString());

        Estudiante estudiante = new Estudiante("Raúl", 8.5f);
        estudiante.asignarEdad("14/01/1994");
        System.out.println(estudiante.toString());

        System.out.println("*****************************************************************************************************");
        System.out.println("Uso de interfaces");
        IngresarNombre ingresarNombre = new IngresarNombre();
        ingresarNombre.ingresarNombre("Jose");
        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());
        ingresarNombre.ingresarNombreApellidoPaterno("Jose", "Rodriguez");
        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());
        ingresarNombre.ingresarNombreCompleto("Jose", "Rodriguez", "Ramirez");
        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());

//        //Creación del objeto de tipo Persona donde se manda a llamar al segundo constructor ya aplicando sobrecarga
//        Persona personaDos = new Persona("Jesus");
//        //Impresión de pantalla del objeto personaDos
//        System.out.println("personaDos = " + personaDos);
//        //Creación del objeto de tipo Persona donde se manda a llamar al tercer constructor ya aplicando sobrecarga
//        Persona personaTres = new Persona("Jesus", "Esquivel", "Hernandez");
//        //Impresión de pantalla del objeto personaTres
//        System.out.println("personaTres = " + personaTres);
//        //Creación del objeto de tipo Persona donde se manda a llamar al cuarto constructor ya aplicando sobrecarga
//        Persona personaCuatro = new Persona("Jesus", "Esquivel", "Hernandez", 25);
//        //Impresión de pantalla del objeto personaTres
//        System.out.println("personaCuatro = " + personaCuatro);
//        //Creación del objeto de tipo IngresarNombre
//        IngresarNombre ingresarNombre = new IngresarNombre();
//        //Ingreso del nombre en donde se ejecuta el método ya sobrecargado
//        ingresarNombre.agregarNombre("Jose");
//        //Impresión del nombre que se agrego con el método obtenerNombre()
//        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());
//        //Llamado del método con el mismo nombre pero con diferentes pareametros, en este caso el nombre y el apellido paterno
//        ingresarNombre.agregarNombre("Jose", "Hernandez");
//        //Impresión del nombre que se agrego con el método obtenerNombre()
//        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());
//        //Llamado del método con el mismo nombre pero con diferentes pareametros, en este caso el nombre, apellido paterno y apellido materno
//
//        ingresarNombre.agregarNombre("Jose", "Hernandez", "Perez");
//        //Impresión del nombre que se agrego con el método obtenerNombre()
//
//        System.out.println("Nombre: " + ingresarNombre.obtenerNombre());
    }
}
