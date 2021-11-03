/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package objetos;

import java.sql.Date;

/**
 *
 * @author ramssrez
 */
public class Reservacion {

    private Date fechaEntrada;
    private Date fechaSalida;
    private int idHabitacion;

    public Reservacion() {
    }

    public Reservacion(Date fechaEntrada, Date fechaSalida, int idHabitacion) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    @Override
    public String toString() {
        return "Reservacion{" + "fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", idHabitacion=" + idHabitacion + '}';
    }

}