package clases;

import interfaces.INombres;

//Uso de la interface que previamente hemos declarado
public class IngresarNombre implements INombres{

    //Atributo de la clase IngresarNombre
    private String nombre;

    //Método que obtiene el atributo el nombre
    public String obtenerNombre() {
        return nombre;
    }
    
    //Uso de la interface donde se ingresa el nombre de una persona
    @Override
    public void ingresarNombre(String nombre) {
        this.nombre = nombre;
    }

    //Uso de la interface donde se asigna el nombre y el apellido paterno de una persona
    @Override
    public void ingresarNombre(String nombre, String apellidoPaterno) {
        this.nombre = nombre + " " + apellidoPaterno;
    }

    //Ingreso de la interface donde se asigna el nombre completo de una persona
    @Override
    public void ingresarNombre(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

    
}
