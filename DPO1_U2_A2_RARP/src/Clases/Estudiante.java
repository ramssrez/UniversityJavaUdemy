package Clases;

import java.text.DateFormat;
import java.util.Date;

public class Estudiante {
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int matricula;
    private float promedio;
    private long telefono;
    private String direccion;
    private int edad;
    private Date fechaActual;
    private DateFormat fechaNacimientoDos;

    public Estudiante (){
        System.out.println("Esto es el constructor de la clase");
    }
    
    public int getEdad(){
        return edad;
    }
    
    public int calcularEdad(Date fecha){
        System.out.println("Esto es la fecha actual desde la clase estudiante: " + fecha);
        edad = 25;
        return edad;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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
    
    public void setFechaActual (Date fechaActual){
        this.fechaActual = fechaActual;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "name=" + nombre + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", matricula=" + matricula + ", promedio=" + promedio + ", telefono=" + telefono + ", direccion=" + direccion + ", edad=" + edad + '}';
    }

    public void setFechaNacimiento(DateFormat date) {
        
        this.fechaNacimientoDos = date;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
