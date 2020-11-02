package clases;

public class IngresarNombre {

    private String nombre;

    public String obtenerNombre() {
        return nombre;
    }

    public void agregarNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarNombre(String nombre, String apellidoPaterno) {
        this.nombre = nombre + " " + apellidoPaterno;
    }

    public void agregarNombre(String nombre, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }

}
