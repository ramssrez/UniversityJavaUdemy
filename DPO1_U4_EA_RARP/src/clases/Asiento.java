package clases;

public class Asiento {

    private final int idAsiento;
    private int numeroAsiento;
    private char fila;
    private boolean ocupado;
    private static int contadorAsientos;

    public Asiento(char fila,int numeroAsiento, boolean ocupado) {
        this.idAsiento = ++Asiento.contadorAsientos;
        this.numeroAsiento = numeroAsiento;
        this.fila = fila;
        this.ocupado = ocupado;
    }

    public int getIdAsiento() {
        return idAsiento;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public static int getContadorAsientos() {
        return contadorAsientos;
    }      

    @Override
    public String toString() {
        return "Asiento{" + "idAsiento=" + idAsiento + ", numeroAsiento=" + numeroAsiento + ", fila=" + fila + ", ocupado=" + ocupado + '}';
    }


}
