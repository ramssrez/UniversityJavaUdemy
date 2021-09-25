package clases;

import java.util.Date;

public class Movimiento {

    //Declaración de atributos del objeto CuentaBancaria
    private String fecha;
    private String movimiento;

    //Constructor para asignar el tipo de movimiento y la fecha
    public Movimiento(String movimiento, String fecha) {
        this.movimiento = movimiento;
        this.fecha = fecha;
    }

    //Métodos getters y setter del atributo fecha
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    //Métodos getter y setter para el atributo movimietno
    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    //Método toString para imprimir los atributos del objeto
    @Override
    public String toString() {
        return "movimiento: " + movimiento + ", fecha: " + fecha;
    }

}
