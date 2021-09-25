package clases;

public class Asiento {

    //Atributos del objeto asiento
    private final int idAsiento;
    private int numeroAsiento;
    private char fila;
    private boolean ocupado;
    private static int contadorAsientos;

    //Constructor del objetos asiento, creando el id del aseitno y ser único
    public Asiento(char fila,int numeroAsiento, boolean ocupado) {
        this.idAsiento = ++Asiento.contadorAsientos;
        this.numeroAsiento = numeroAsiento;
        this.fila = fila;
        this.ocupado = ocupado;
    }

    //Método getter del asiento 
    public int getIdAsiento() {
        return idAsiento;
    }

    //Métodos getters y setter para el atributo número de asiento
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    //Métodos getter y setter para el atiburo fila
    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    //Metodos getter y setter para el atributo ocupado
    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
   
    //Método toString() para poder visualizar los atributos de los objetos
    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", numeroAsiento=" + numeroAsiento + ", fila=" + fila + ", ocupado=" + ocupado + '}';
    }


}
