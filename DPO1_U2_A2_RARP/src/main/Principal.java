package main;

import Clases.Estudiante;
import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        //Instancia de la fecha actual
        Date fecha = new Date();
        //Instancia del objeto estudiante
        Estudiante estudiante = new Estudiante();
        
        //LLenado de atributos del objeto estudiante
        estudiante.setNombre("Raúl");
        estudiante.setApellido("Ramírez");
        estudiante.setMatricula(308122598);
        estudiante.setDireccion("Cerrada Baja California 1");
        estudiante.setPromedio(9.3f);
        estudiante.setTelefono(5555555555L);
        estudiante.setFechaNacimiento("15/10/2015");
        estudiante.calcularEdad(fecha);
        estudiante.calcularEdadDos(fecha);
        
        //Impresión de todos los parametros del objeto Estudiante
        System.out.println("Estudiante: " +estudiante.toString());
    }
}
