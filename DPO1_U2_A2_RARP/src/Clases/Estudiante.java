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
        System.out.println("Esto es el constructor de la clase");
    }
    
    public int getEdad(){
        return edad;
    }
    public int calcularEdadDos(Date fecha){
        //System.out.println("fechaActual = " + fecha);
        //Asignación del formato a la fecha actual y de nacimiento
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        Date nacimiento = null;
        try{
            nacimiento = format.parse(this.fechaNacimiento);
        }catch(ParseException ex){
            System.out.println("Error "+ ex);
        }
        
        Calendar fechaN = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        
        fechaN.setTime(nacimiento);
        fechaActual.setTime(fecha);
        
        int año = fechaActual.get(Calendar.YEAR)-fechaN.get(Calendar.YEAR);
        System.out.println("año = " + año);
        int mes = fechaActual.get(Calendar.MONTH)-fechaN.get(Calendar.MONTH);
        System.out.println("mes = " + mes);
        int dia = fechaActual.get(Calendar.DATE)-fechaN.get(Calendar.DATE);
        System.out.println("dia = " + dia);
        if(mes<0 || (mes==0 && dia<0)){
            año--;
            System.out.println("año = " + año);
        }

        edad = año;
        return edad;
    }
    
    public int calcularEdad(Date fecha){
        System.out.println("Esto es la fecha actual desde la clase estudiante: " + fecha);
        DateTimeFormatter fmt =DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNaci = LocalDate.parse(this.fechaNacimiento,fmt);
        LocalDate fechaActual = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(fechaNaci, fechaActual);
        System.out.println("Tu edad es: " + periodo.getYears() + " años "
        + periodo.getMonths() + " meses " + periodo.getDays() + " dias");
        System.out.println(periodo.getMonths() + " meses");
        System.out.println(periodo.getDays() + " dias");
        edad = periodo.getYears();
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    

    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", apellido=" + apellido + 
                ", fechaNacimiento=" + fechaNacimiento + ", matricula=" + matricula + 
                ", promedio=" + promedio + ", telefono=" + telefono + ", direccion=" + direccion + 
                ", edad=" + edad + '}';
    }
    
}
