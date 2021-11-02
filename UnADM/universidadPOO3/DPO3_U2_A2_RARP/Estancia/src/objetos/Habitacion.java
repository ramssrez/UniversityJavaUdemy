/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package objetos;

/**
 *
 * @author ramssrez
 */
public class Habitacion {
    private int idHabitacion;
    private int numeroHabitacion;
    private String status;
    private String tipoHabitacion;
    private int costoHabitacion;

    public Habitacion() {
    }

    public Habitacion(int idHabitacion, int numeroHabitacion, String status, String tipoHabitacion, int costoHabitacion) {
        this.idHabitacion = idHabitacion;
        this.numeroHabitacion = numeroHabitacion;
        this.status = status;
        this.tipoHabitacion = tipoHabitacion;
        this.costoHabitacion = costoHabitacion;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCostoHabitacion() {
        return costoHabitacion;
    }

    public void setCostoHabitacion(int costoHabitacion) {
        this.costoHabitacion = costoHabitacion;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "idHabitacion=" + idHabitacion + ", tipoHabitacion=" + tipoHabitacion + ", numeroHabitacion=" + numeroHabitacion + ", status=" + status + ", costoHabitacion=" + costoHabitacion + '}';
    }
    
}
