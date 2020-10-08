package main;

import Clases.Estudiante;
import java.util.Calendar;
import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        estudiante.toString();
        estudiante.setName("Raúl");
        estudiante.setApellido("Ramírez");
        estudiante.setMatricula(308122598);
        estudiante.setDireccion("Cerrada Baja California 1");
        estudiante.setPromedio(9.3f);
        estudiante.setTelefono(5555555555L);
        
        Date fecha = new Date();
        //Calendar fechaDos = new Calendar() ;
        
        System.out.println("El día es: " + fecha.getDay());
        System.out.println("El tiempo es: " + fecha.getTime());
        System.out.println("El mes es: " + fecha.getMonth());
        System.out.println("La fecha es: " + fecha);
        System.out.println("Estudiante: " +estudiante.toString());
        
    }
}
