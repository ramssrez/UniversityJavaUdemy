package Clases;
//Clases externas que se necesitan para el optimo trabajo de la clase
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Estudiante {
    //Atirbutos de la clase estudiante
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private int matricula;
    private float promedio;
    private long telefono;
    private String direccion;
    private int edad;
    
    //Constructor vacío de la clase Estudiante
    public Estudiante (){
        
    }
    
    public int getEdad(){
        return edad;
    }
       
    //Método que calcula la edad del alumno en base a la fecha actual y la fecha de nacimiento 
    //Es otro método para su realización con otras clases que nos brinda Java, mucho mas precisa
    public int calcularEdad(Date fecha){
        //Asignamos el formato de la fecha que deseamos utilizar
        DateTimeFormatter dateFormater =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Pareseo del String de la fecha de nacimiento en el formato que hemos seleccionado en la sentencia anterior
        LocalDate fechaNaci = LocalDate.parse(this.fechaNacimiento,dateFormater);
        //Declaramos el objeto zonaActual, ya que lo necesitamos para ubicar el lugar en donde nos encontramos
        ZoneId zonaActual = ZoneId.systemDefault();
        //Parseo del objeto fecha de tipo Dare a objeto de tipo LocalDate 
        LocalDate fechaActual = fecha.toInstant().atZone(zonaActual).toLocalDate();
        //Declaración del objeto perido donde se compara las fecha de nacimiento con la actual
        Period periodo = Period.between(fechaNaci, fechaActual);
        //Impresión de la edad en años, meses y dias
        System.out.println("Edad del estudiante: " + periodo.getYears() + " años "
        + periodo.getMonths() + " meses " + periodo.getDays() + " dias");
        //Asiganción de la edad que se obtuvo hace un momento
        this.edad = periodo.getYears();
        return edad;
    }
    
     //Método que calcula la edad del alumno en base de su fecha registrada y la fecha actual
    public int calcularEdadDos(Date fecha){
        //Asignación del formato a la fecha actual y de nacimiento en formato dd/MM/yyyy
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //intancia de la fecha de nacimiento para que entre a la sentencia try catch
        Date nacimiento = null;
        /*
         Usamos la sentencia try/catch por el parseo que puede presentar el código al momento
         de pasar un objeto String a un objeto DateFormat
        */
        try{
            nacimiento = format.parse(this.fechaNacimiento);
        }catch(ParseException ex){
            System.out.println("Error "+ ex);
        }
        
        //Intancia de la clase Calendar para utilizar el calendario actual
        //para la fecha de nacimiento que parseamos anteriormente y la fecha
        //actual que se envió por medio de la clase principal
        Calendar fechaN = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        
        //Asignación de la fecha de nacimiento y la fecha actual con los objetos Calendar
        fechaN.setTime(nacimiento);
        fechaActual.setTime(fecha);
        
        //Resta del año, mes y dias de la fecha actual con la fecha de nacimiento
        int año = fechaActual.get(Calendar.YEAR)-fechaN.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH)-fechaN.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE)-fechaN.get(Calendar.DATE);
        //Sentencia para el caso que la fecha de compleños sea cerca a la fecha actual
        if(mes<0 || (mes==0 && dia<0)){
            año--;
        }
        System.out.println("Tu edad es: " + año + " años " + mes + " meses " + dia + " dias");
        edad = año;
        return edad;
    }
    
    //Metodos getters y setters para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Metodos getters y setters para el apellido
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Metodos getters y setters para la fecha de nacimiento
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //Metodos getters y setters para la matricula del estudiante
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    //Metodos getters y setters para el promedio
    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    //Metodos getters y setters para la dirección
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //Metodos getters y setters para el telefono
    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    
    //Sobreescitura  del metodo toString par presentar los paramentros del objeto estudiante.
    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + 
                ", fechaNacimiento=" + fechaNacimiento + ", matricula=" + matricula + 
                ", \npromedio=" + promedio + ", telefono=" + telefono + ", direccion=" + direccion + 
                ", edad=" + edad + '}';
    }
    
}
