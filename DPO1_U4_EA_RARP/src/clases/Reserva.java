package clases;

public class Reserva {
    private String nombre;
    private String apellido;
    private int numeroAsiento;

    public Reserva(String nombre, String apellido, int numeroAsiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroAsiento = numeroAsiento;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
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
        return "Reserva{" + "nombre=" + nombre + ", apellido=" + apellido + ", numeroAsiento=" + numeroAsiento + '}';
    }
    
}
