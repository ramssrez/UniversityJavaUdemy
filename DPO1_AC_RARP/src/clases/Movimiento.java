package clases;

import java.util.Date;

public class Movimiento {

    private int numeroMovimiento;
    private Date fecha;
    private String movimiento;

    public int getNumeroMovimiento() {
        return numeroMovimiento;
    }

    public void setNumeroMovimiento(int numeroMovimiento) {
        this.numeroMovimiento = numeroMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "numeroMovimiento=" + numeroMovimiento + ", fecha=" + fecha + ", movimiento=" + movimiento + '}';
    }

    
}
