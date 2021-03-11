/*
 *Código elaborado por: Raúl Ramírez Pérez
 */
package objetos;

import java.util.Date;

public class Empleado {

    private int idEmpleado;
    private int numEmpleado;
    private String nombreEmpleado;
    private String apellidosEmpleado;
    private String fechaNacimientoEmpleado;
    private String curpEmpleado;
    private String rfcEmpleado;
    private int sueldoEmpleado;
    private String puestoEmpleado;
    private Date FechaIngresoEmpleado;

    public Empleado() {
    }

    public Empleado(int numEmpleado, String nombreEmpleado, String apellidosEmpleado, String fechaNacimientoEmpleado, String curpEmpleado, String rfcEmpleado, int sueldoEmpleado, String puestoEmpleado, Date FechaIngresoEmpleado) {
        this.numEmpleado = numEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidosEmpleado = apellidosEmpleado;
        this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
        this.curpEmpleado = curpEmpleado;
        this.rfcEmpleado = rfcEmpleado;
        this.sueldoEmpleado = sueldoEmpleado;
        this.puestoEmpleado = puestoEmpleado;
        this.FechaIngresoEmpleado = FechaIngresoEmpleado;
    }

    public Empleado(int idEmpleado, int numEmpleado, String nombreEmpleado, String apellidosEmpleado, String fechaNacimientoEmpleado, String curpEmpleado, String rfcEmpleado, int sueldoEmpleado, String puestoEmpleado, Date FechaIngresoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.numEmpleado = numEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidosEmpleado = apellidosEmpleado;
        this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
        this.curpEmpleado = curpEmpleado;
        this.rfcEmpleado = rfcEmpleado;
        this.sueldoEmpleado = sueldoEmpleado;
        this.puestoEmpleado = puestoEmpleado;
        this.FechaIngresoEmpleado = FechaIngresoEmpleado;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidosEmpleado() {
        return apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public String getFechaNacimientoEmpleado() {
        return fechaNacimientoEmpleado;
    }

    public void setFechaNacimientoEmpleado(String fechaNacimientoEmpleado) {
        this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
    }

    public String getCurpEmpleado() {
        return curpEmpleado;
    }

    public void setCurpEmpleado(String curpEmpleado) {
        this.curpEmpleado = curpEmpleado;
    }

    public String getRfcEmpleado() {
        return rfcEmpleado;
    }

    public void setRfcEmpleado(String rfcEmpleado) {
        this.rfcEmpleado = rfcEmpleado;
    }

    public int getSueldoEmpleado() {
        return sueldoEmpleado;
    }

    public void setSueldoEmpleado(int sueldoEmpleado) {
        this.sueldoEmpleado = sueldoEmpleado;
    }

    public String getPuestoEmpleado() {
        return puestoEmpleado;
    }

    public void setPuestoEmpleado(String puestoEmpleado) {
        this.puestoEmpleado = puestoEmpleado;
    }

    public Date getFechaIngresoEmpleado() {
        return FechaIngresoEmpleado;
    }

    public void setFechaIngresoEmpleado(Date FechaIngresoEmpleado) {
        this.FechaIngresoEmpleado = FechaIngresoEmpleado;
    }
    
    
}
