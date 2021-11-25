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

    //Declaración de atributos de la clase Reservación
    private int idReservacion;
    private Date fechaEntrada;
    private Date fechaSalida;
    private int idHabitacion;
    private int dias;
    private int costoTotal;
    private int numeroHabitacion;

    //Constructor vacio
    public Reservacion() {
    }

    //Contructor con atributos de la clase
    public Reservacion(Date fechaEntrada, Date fechaSalida, int idHabitacion, int dias, int costo_total) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.idHabitacion = idHabitacion;
        this.dias = dias;
        this.costoTotal = costo_total;
    }

    public Reservacion(int id_reservacion, Date fechaEntrada, Date fechaSalida, int dias, int costoTotal, int numero_habitacion) {
        this.idReservacion = id_reservacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.dias = dias;
        this.costoTotal = costoTotal;
        this.numeroHabitacion = numero_habitacion;
    }

    //Métodos getters y setter de la clase
    public int getIdReservacion() {
        return idReservacion;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
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

    //Método ToString que imprime los datos de la clase
    @Override
    public String toString() {
        return "Reservacion{" + "id_reservacion=" + idReservacion + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", idHabitacion=" + idHabitacion + ", dias=" + dias + ", costoTotal=" + costoTotal + ", numero_habitacion=" + numeroHabitacion + '}';
    }

}
