package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Empleado extends Persona {

    private int edad;
    private double sueldo;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, double sueldo) {
        super(nombre, apellidoPaterno, apellidoMaterno);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public void generarEdad(String fechaNacimiento) {
        Date fecha = new Date();
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNaci = LocalDate.parse(fechaNacimiento, dateFormater);
        ZoneId zonaActual = ZoneId.systemDefault();
        LocalDate fechaActual = fecha.toInstant().atZone(zonaActual).toLocalDate();
        Period periodo = Period.between(fechaNaci, fechaActual);
        System.out.println("Edad del empleado: " + periodo.getYears() + " años ");
        this.edad = periodo.getYears();
    }

    
    
//    
//    @Override
//    public String toString() {
//        return "Empleado{" + "edad=" + this.edad + " " + super.toString() + '}';
//    }

    @Override
    public String toString() {
        return "Empleado{" + "edad=" + edad + ", sueldo=" + sueldo + " "+super.toString()+ '}';
    }

}
