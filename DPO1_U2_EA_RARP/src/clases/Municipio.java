package clases;

public class Municipio {

    //Declaración de los atributos del objetos Municipio
    private String nombreMunicipio;
    private int numeroInfectados;
    private String semaforo;

    //Constructor del objeto municipio
    public Municipio(String nombreMunicipio, int numeroInfectados) {
        this.nombreMunicipio = nombreMunicipio;
        this.numeroInfectados = numeroInfectados;
    }

    //Métodos getter y setter del atributo nombre de municipio
    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    //Métodos getter y setter del atibuto numero de infectados
    public int getNumeroInfectados() {
        return numeroInfectados;
    }

    public void setNumeroInfectados(int numeroInfectados) {
        this.numeroInfectados = numeroInfectados;
    }

    //Métodos getter y setter del atributo del semáforo
    public String getSemaforo() {
        return semaforo;
    }

    public void setSemaforo(String semaforo) {
        this.semaforo = semaforo;
    }

    //Método toString del objeto Municipio
    @Override
    public String toString() {
        return "{" + "Nombre Municipio=" + nombreMunicipio + ", Número Infectados=" + numeroInfectados + ", Semaforo=" + semaforo + '}';
    }

}
