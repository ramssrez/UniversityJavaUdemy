package clases;

public class Municipio {

    //Declaración de los atributos del objetos Municipio
    private String nombreMunicipio;
    private int numeroPositivos;
    private int numeroDefunciones;
    private int numeroRecuperados;
    private String semaforo;

    //Constructor del objeto municipio
    public Municipio(String nombreMunicipio, int numeroPositivos, int numeroDefunciones, int numeroRecuperados) {
        this.nombreMunicipio = nombreMunicipio;
        this.numeroPositivos = numeroPositivos;
        this.numeroDefunciones = numeroDefunciones;
        this.numeroRecuperados = numeroRecuperados;
        this.asignarSemaforo();
    }

    //Métodos getter y setter del atributo nombre de municipio
    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    //Métodos getter y setter del atibuto numero de infectados
    public int getNumeroPositivos() {
        return numeroPositivos;
    }

    public void setNumeroPositivos(int numeroPositivos) {
        this.numeroPositivos = numeroPositivos;
    }

    //Métodos getter y setter del atributo del semáforo
    public String getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(String semaforo) {
        this.semaforo = semaforo;
    }

    //Métodos getter y setter del atributo número de defunciones
    public int getNumeroDefunciones() {
        return numeroDefunciones;
    }

    public void setNumeroDefunciones(int numeroDefunciones) {
        this.numeroDefunciones = numeroDefunciones;
    }

    //Métodos getter y setter del atributo número de recuperados
    public int getNumeroRecuperados() {
        return numeroRecuperados;
    }

    public void setNumeroRecuperados(int numeroRecuperados) {
        this.numeroRecuperados = numeroRecuperados;
    }

    private void asignarSemaforo() {
        if ((this.numeroPositivos >= 0) && (this.numeroPositivos <= 25)) {
            this.semaforo = "Verde";
        }
        if ((this.numeroPositivos > 25) && (this.numeroPositivos <= 150)) {
            this.semaforo = "Amarillo";
        }
        if ((this.numeroPositivos > 150) && (this.numeroPositivos <= 275)) {
            this.semaforo = "Naranja";
        }
        if (this.numeroPositivos > 275) {
            this.semaforo = "Rojo";
        }
    }

    //Método toString del objeto Municipio
    @Override
    public String toString() {
        return "Municipio{" + "nombreMunicipio=" + nombreMunicipio + ", numeroPositivos=" + numeroPositivos + ", numeroDefunciones=" + numeroDefunciones + ", numeroRecuperados=" + numeroRecuperados + ", semaforo=" + semaforo + '}';
    }

}
