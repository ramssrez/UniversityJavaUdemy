package clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Empleado extends Persona {

    //Declaración de atributos del objeto empleado
    private int edad;
    private double sueldo;

    //Constructor del objeto Empleado con argumentos
    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, double sueldo) {
        super(nombre, apellidoPaterno, apellidoMaterno);
        this.sueldo = sueldo;
    }

    //Metodos getter y setter del atributo Sueldo
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    //Aplicación del método abstracto de la clase Persona
    @Override
    public void asignarEdad(String fechaNacimiento) {
        //Instancia de la clase Date para obtener la fecha actual
        Date fecha = new Date();
        //Asignamos el formato de la fecha que deseamos utilizar
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Pareseo del String de la fecha de nacimiento que ingreso en forma de String
        LocalDate fechaNaci = LocalDate.parse(fechaNacimiento, dateFormater);
        //Declaramos el objeto zonaActual, ya que lo necesitamos para ubicar el lugar en donde nos encontramos
        ZoneId zonaActual = ZoneId.systemDefault();
        //Parseo del objeto fecha de tipo Dare a objeto de tipo LocalDate 
        LocalDate fechaActual = fecha.toInstant().atZone(zonaActual).toLocalDate();
        //Declaración del objeto perido donde se compara las fecha de nacimiento con la actual
        Period periodo = Period.between(fechaNaci, fechaActual);
        //Asiganción de la edad que se obtuvo con el procedimiento anterior
        this.edad = periodo.getYears();
    }

    //Sobreescitura  del metodo toString par presentar los paramentros del objeto empleado
    @Override
    public String toString() {
        return super.toString() + ", edad: " + edad + " años" + ", sueldo: $" + sueldo;
    }

}
