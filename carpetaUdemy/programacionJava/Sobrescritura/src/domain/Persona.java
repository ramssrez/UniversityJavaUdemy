package domain;

import java.io.Serializable;

//Uso del concepto de Java Beans en donde se usa la interface Serizalizable
public class Persona implements Serializable{
    private String nombre;
    private String apellido;
    
    //Para freamwork es necesario de hacer uso de un constructor vacío
    public Persona(){
        
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + '}';
    }
        
}
