package clases;

public class IngresarNombre {

    //Atributo de la clase IngresarNombre
    private String nombre;

    //Método que obtiene el atributo el nombre
    public String obtenerNombre() {
        return nombre;
    }

    //Primer método con sobrecarga en donde se asigna un nombre
    public void agregarNombre(String nombre) {
        this.nombre = nombre;
    }

    //Segundo nombre con sobrecarga en donde se le asigna nombre y apellido paterno
    public void agregarNombre(String nombre, String apellidoPaterno) {
        this.nombre = nombre + " " + apellidoPaterno;
    }

    //Tercer nombre con sobrecarga en donde se le asigna el nombre, apellido paterno y apellido materno, además de sobrecarga del operador +
    public void agregarNombre(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

}
