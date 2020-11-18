package clases;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CuentaBancaria {

    private String nombreCliente;
    private String numeroCuenta;
    private double saldo;
    private int movimientoEntero;
    private Movimiento movimientos[] = new Movimiento[200];

    private CuentaBancaria() {
        movimientoEntero = 0;
    }

    public CuentaBancaria(String nombreCliente, String numeroCuenta, double saldo) {
        if ((nombreCliente.equals("")) || (numeroCuenta.equals(""))) {
            System.out.println("No se puede crear la cuenta, el nombre del usuario o el número de cuenta están vacíos");
        } else if (saldo < 0) {
            System.out.println("Se ha ingresado un saldo negativo, no se puede crear la cuenta");
        } else {
            this.nombreCliente = nombreCliente;
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
            System.out.println("Se ha creado una cuenta");
        }

    }

    public int getMovimientos() {
        return movimientoEntero;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void asignarSaldoCuenta(double saldoIngresado) {
        if (saldoIngresado < 0) {
            System.out.println("Cantidad negativa, no es válida");
        } else {
            this.saldo = this.saldo + saldoIngresado;
        }
        crearMovimientos("Agregar Saldo");
    }

    public void retiroSaldoCuenta(double retiro) {
        if (retiro > this.saldo) {
            System.out.println("El monto a retirar excede al saldo de la cuenta");
        } else {
            this.saldo = this.saldo - retiro;
        }
        crearMovimientos("Retirar Saldo");
    }

    public double consultarSaldo(String nombre, String numeroCuenta) {
        double saldoRetorno = 0;
        if ((this.nombreCliente.equals(nombre)) && (this.numeroCuenta.equals(numeroCuenta))) {
            saldoRetorno = this.saldo;
        } else {
            System.out.println("Los datos no son correctos, verifica tus datos");
        }
        crearMovimientos("Consultar Saldo");
        return saldoRetorno;
    }

    private void crearMovimientos(String motivo) {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy - HH:mm:ss");
        String fechaTexto = formato.format(fecha);
        Movimiento movimiento = new Movimiento(motivo, fechaTexto);
        movimientos[this.movimientoEntero] = movimiento;
        this.movimientoEntero = this.movimientoEntero + 1;
    }

    public void movimientos() {
        for (int i = 0; i < movimientos.length; i++) {
            if (movimientos[i] != null) {
                System.out.println((i+1) + ".- " + movimientos[i].toString());
            }
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "nombreCliente=" + nombreCliente + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }

}
