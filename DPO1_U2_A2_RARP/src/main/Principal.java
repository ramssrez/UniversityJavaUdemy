package main;

import Clases.Estudiante;
import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        Date fecha = new Date();
        //Instancia del objeto estudiante
        Estudiante estudiante = new Estudiante();
        
        //LLenado de atributos del objeto estudiante
        estudiante.setName("Raúl");
        estudiante.setApellido("Ramírez");
        estudiante.setMatricula(308122598);
        estudiante.setDireccion("Cerrada Baja California 1");
        estudiante.setPromedio(9.3f);
        estudiante.setTelefono(5555555555L);
        estudiante.setFechaNacimiento("14/01/1994");
        estudiante.calcularEdad(fecha);
        estudiante.calcularEdadDos(fecha);
        
        System.out.println("Estudiante: " +estudiante.toString());
    }
}
