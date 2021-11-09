/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package objetos;

import java.sql.Date;

/**
 *
 * @author ramssrez
 */
public class Empleado {

    private int idComisión;
    private Date fecha;
    private String nombreTrabajador;
    private String nombre_Cliente;
    private int tiempoTrabajador;
    private int comision;
    private int descuentoRealizado;
    private int sueldoTotal;

    public Empleado() {
    }

    public Empleado(Date fecha, String nombreTrabajador, String nombre_Cliente, int tiempoTrabajador, int comision, int descuentoRealizado, int sueldoTotal) {
        this.fecha = fecha;
        this.nombreTrabajador = nombreTrabajador;
        this.nombre_Cliente = nombre_Cliente;
        this.tiempoTrabajador = tiempoTrabajador;
        this.comision = comision;
        this.descuentoRealizado = descuentoRealizado;
        this.sueldoTotal = sueldoTotal;
    }

    public int getIdComisión() {
        return idComisión;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getNombre_Cliente() {
        return nombre_Cliente;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        this.nombre_Cliente = nombre_Cliente;
    }

    public int getTiempoTrabajador() {
        return tiempoTrabajador;
    }

    public void setTiempoTrabajador(int tiempoTrabajador) {
        this.tiempoTrabajador = tiempoTrabajador;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getDescuentoRealizado() {
        return descuentoRealizado;
    }

    public void setDescuentoRealizado(int descuentoRealizado) {
        this.descuentoRealizado = descuentoRealizado;
    }

    public int getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(int sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idComisi\u00f3n=" + idComisión + ", fecha=" + fecha + ", nombreTrabajador=" + nombreTrabajador + ", nombre_Cliente=" + nombre_Cliente + ", tiempoTrabajador=" + tiempoTrabajador + ", comision=" + comision + ", descuentoRealizado=" + descuentoRealizado + ", sueldoTotal=" + sueldoTotal + '}';
    }

}
