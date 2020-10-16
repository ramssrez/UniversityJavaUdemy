package clases;

public class Municipio {
    private String nombreMunicipio;
    private int numeroInfectados;

    public Municipio(String nombreMunicipio, int numeroInfectados) {
        this.nombreMunicipio = nombreMunicipio;
        this.numeroInfectados = numeroInfectados;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
    }

    public int getNumeroInfectados() {
        return numeroInfectados;
    }

    public void setNumeroInfectados(int numeroInfectados) {
        this.numeroInfectados = numeroInfectados;
    }

    @Override
    public String toString() {
        return "Municipio{" + "nombreMunicipio=" + nombreMunicipio + ", numeroInfectados=" + numeroInfectados + '}';
    }
    
}
