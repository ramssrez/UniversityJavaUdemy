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
    private String nombreCliente;
    private int tiempoTrabajado;
    private int comision;
    private int descuentoRealizado;
    private int sueldoTotal;

    public Empleado() {
    }

    public Empleado(Date fecha, String nombreTrabajador, String nombre_Cliente, int tiempoTrabajador, int comision, int descuentoRealizado, int sueldoTotal) {
        this.fecha = fecha;
        this.nombreTrabajador = nombreTrabajador;
        this.nombreCliente = nombre_Cliente;
        this.tiempoTrabajado = tiempoTrabajador;
        this.comision = comision;
        this.descuentoRealizado = descuentoRealizado;
        this.sueldoTotal = sueldoTotal;
    }

    public Empleado(int idComisión, Date fecha, String nombreTrabajador, String nombre_Cliente, int tiempoTrabajador, int comision, int descuentoRealizado, int sueldoTotal) {
        this.idComisión = idComisión;
        this.fecha = fecha;
        this.nombreTrabajador = nombreTrabajador;
        this.nombreCliente = nombre_Cliente;
        this.tiempoTrabajado = tiempoTrabajador;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getTiempoTrabajado() {
        return tiempoTrabajado;
    }

    public void setTiempoTrabajado(int tiempoTrabajado) {
        this.tiempoTrabajado = tiempoTrabajado;
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
        return "Empleado{" + "idComisi\u00f3n=" + idComisión + ", fecha=" + fecha + ", nombreTrabajador=" + nombreTrabajador + ", nombre_Cliente=" + nombreCliente + ", tiempoTrabajador=" + tiempoTrabajado + ", comision=" + comision + ", descuentoRealizado=" + descuentoRealizado + ", sueldoTotal=" + sueldoTotal + '}';
    }

}
