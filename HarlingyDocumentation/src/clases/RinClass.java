package clases;

public class RinClass //implements Comparable<RinClass>
{

    private String nombre;
    private float porcentajeRelativo;
    private float porcentajeAbsoluto;
    private float aerodinamica;

    public Float getAerodinamica() {
        return aerodinamica;
    }

    public void setAerodinamica(float aerodinamica) {
        this.aerodinamica = aerodinamica;
    }

    public RinClass() {
    }

    public RinClass(String nombre, float porcentajeRelativo, float aerodinamica) {
        this.nombre = nombre;
        this.porcentajeRelativo = porcentajeRelativo;
        this.aerodinamica = aerodinamica;
    }

    public RinClass(String nombre, float porcentajeRelativo, float porcentajeAbsoluto, float aerodinamica) {
        this.nombre = nombre;
        this.porcentajeRelativo = porcentajeRelativo;
        this.porcentajeAbsoluto = porcentajeAbsoluto;
        this.aerodinamica = aerodinamica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPorcentajeRelativo() {
        return porcentajeRelativo;
    }

    public void setPorcentajeRelativo(float porcentajeRelativo) {
        this.porcentajeRelativo = porcentajeRelativo;
    }

    public float getPorcentajeAbsoluto() {
        return porcentajeAbsoluto;
    }

    public void setPorcentajeAbsoluto(float porcentajeAbsoluto) {
        this.porcentajeAbsoluto = porcentajeAbsoluto;
    }

    @Override
    public String toString() {
        return "RinClass{" + "nombre=" + nombre + ", porcentajeRelativo=" + porcentajeRelativo + ", porcentajeAbsoluto=" + porcentajeAbsoluto + ", aerodinamica=" + aerodinamica + '}';
    }

}
