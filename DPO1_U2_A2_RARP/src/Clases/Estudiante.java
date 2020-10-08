package Clases;

import java.util.Date;

public class Estudiante {
    private String name;
    private String apellido;
    private Date fechaNacimiento;
    private int matricula;
    private float promedio;
    private long telefono;
    private String direccion;

    public Estudiante (){
        System.out.println("Esto es el constructor de la clase");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    
    
    

    @Override
    public String toString() {
        return "Estudiante{" + "name=" + name + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", matricula=" + matricula + ", promedio=" + promedio + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
}
