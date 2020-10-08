package main;

import Clases.Estudiante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Principal {
    public static void main(String[] args) {
        Date fecha = new Date();
        DateFormat date = new SimpleDateFormat("dd/MM/YYYY");
        Estudiante estudiante = new Estudiante();
        
        estudiante.setName("Raúl");
        estudiante.setApellido("Ramírez");
        estudiante.setMatricula(308122598);
        estudiante.setDireccion("Cerrada Baja California 1");
        estudiante.setPromedio(9.3f);
        estudiante.setTelefono(5555555555L);
        estudiante.calcularEdad(fecha);
        
        //Calendar fechaDos = new Calendar() ;
        DateTimeFormatter fmt =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse("27/06/1992",fmt);
        LocalDate ahora = LocalDate.now();
        
        Period periodo = Period.between(fechaNacimiento, ahora);
        System.out.println("Tu edad es: " + periodo.getYears() + "años");
        System.out.println(periodo.getMonths() + " meses");
        System.out.println(periodo.getDays() + " dias");
        
        estudiante.setFechaNacimiento(fecha);
        System.out.println("La fecha es: " + fecha);
        System.out.println("Estudiante: " +estudiante.toString());
        System.out.println("date = " + date.format(fecha));
    }
}
