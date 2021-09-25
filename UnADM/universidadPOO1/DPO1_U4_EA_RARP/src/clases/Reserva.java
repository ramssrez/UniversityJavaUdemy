package clases;

public class Reserva {
    //Atributos del objeto reserva
    private String nombre;
    private String apellido;
    private int numeroAsiento;

    //Constructor del objeto reserva
    public Reserva(String nombre, String apellido, int numeroAsiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroAsiento = numeroAsiento;
    }

    //Métodos getter y setter del atributo número de asiento
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    //Métodos getter y setters del atributo nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Métodos getter y setter del atributo apellido
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    //Método toString() para poder visualizar los atributos del objeto
    @Override
    public String toString() {
        return  nombre  + " " +  apellido + ", asiento: " + numeroAsiento;
    }
    
}
