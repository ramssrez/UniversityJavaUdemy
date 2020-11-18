package clases;

import java.util.Date;

public class Movimiento {

    private String fecha;
    private String movimiento;

    public Movimiento(String movimiento, String fecha){
        this.movimiento = movimiento;
        this.fecha =  fecha;
    }
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
        return "movimiento: " + movimiento  + ", fecha: " + fecha;
    }

    
}
