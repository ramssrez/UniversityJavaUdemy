package Clases;

import java.util.Date;

public class Estudiante {
    private String name;
    private String apellido;
    private Date fechaNacimiento;
    private int matricula;
    private float promedio;
    private int telefono;
    private String direccion;

    public Estudiante (){
        System.out.println("ESto es el constructor de la clase");
    }
    
    

    @Override
    public String toString() {
        return "Estudiante{" + "name=" + name + ", apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", matricula=" + matricula + ", promedio=" + promedio + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
}
