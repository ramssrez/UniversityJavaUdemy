package clases;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Estudiante extends Persona {

    private int edad;
    private float calificacion;

    //Constructor del objeto Empleado con argumentos
    public Estudiante(String nombre, float calificacion) {
        super(nombre);
        this.calificacion = calificacion;
    }

    //Metodos getter y setter del atributo Calificacion
    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    //Aplicación del método abstracto de la clase Persona
    @Override
    public void asignarEdad(String fechaNacimiento) {
        //Instancia de la fecha actual
        Date fecha = new Date();
        //Asignación del formato a la fecha actual y de nacimiento en formato dd/MM/yyyy
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //intancia de la fecha de nacimiento para que entre a la sentencia try catch
        Date nacimiento = null;
        /*
         Usamos la sentencia try/catch por el parseo que puede presentar el código al momento
         de pasar un objeto String a un objeto DateFormat
         */
        try {
            nacimiento = format.parse(fechaNacimiento);
        } catch (ParseException ex) {
            System.out.println("Error  el ingresar la fecha" + ex.getMessage());
        }

        //Intancia de la clase Calendar para utilizar el calendario actual
        //para la fecha de nacimiento que parseamos anteriormente y la fecha
        //actual que se envió por medio de la clase principal
        Calendar fechaN = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();

       //Sentencia try/catch en donde se realiza la asignación de la fecha de nacimiento y la fecha actual con los objetos Calendar
       //en caso de ser erroneo se manda un mensaje en consola
        try {
            fechaN.setTime(nacimiento);
            fechaActual.setTime(fecha);
        } catch (NullPointerException e) {
            System.out.println("Error a la asignación del objeto Calendar: " + e.getMessage());
        }

        //Resta del año, mes y dias de la fecha actual con la fecha de nacimiento
        int año = fechaActual.get(Calendar.YEAR) - fechaN.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH) - fechaN.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE) - fechaN.get(Calendar.DATE);
        //Sentencia para el caso que la fecha de compleños sea cerca a la fecha actual
        if (mes < 0 || (mes == 0 && dia < 0)) {
            año--;
        }
        this.edad = año;
    }

    //Sobreescitura  del metodo toString par presentar los paramentros del objeto estudiante.
    @Override
    public String toString() {
        return super.toString() + ", edad: " + this.edad + " años" + ", promedio: " + this.calificacion;
    }

}
