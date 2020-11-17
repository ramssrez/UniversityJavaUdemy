package clases;

public class CuentaBancaria {

    private String nombreCliente;
    private String numeroCuenta;
    private double saldo;
    private int[] numeroMovimientos;
    private int movimietno;

    private CuentaBancaria() {
        numeroMovimientos = new int[200];
        movimietno = 0;
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

    public void asignarSaldoCuenta(double saldo) {
        if (saldo < 0) {
            System.out.println("Cantidad negativa, no es válida");
        } else {
            this.saldo = this.saldo + saldo;
        }
        this.movimietno = this.movimietno + 1;
    }

    public void retiroSaldoCuenta(double retiro) {
        if (retiro > this.saldo) {
            System.out.println("El monto a retirar excede al saldo de la cuenta");
        } else {
            this.saldo = this.saldo - retiro;
        }
        this.movimietno = this.movimietno + 1;
    }

    public double consultarSaldo(String nombre, String numeroCuenta) {
        double saldoRetorno = 0;
        if ((this.nombreCliente.equals(nombre)) && (this.numeroCuenta.equals(numeroCuenta))) {
            saldoRetorno = this.saldo;
        } else {
            System.out.println("Los datos no son correctos, verifica tus datos");
        }
        this.movimietno = this.movimietno + 1;
        return saldoRetorno;
    }

    public void movimientos() {
        numeroMovimientos[this.movimietno] = this.movimietno;
        for (int i = 0; i < numeroMovimientos.length; i++) {
            System.out.println("Los movimientos han sido: " + numeroMovimientos[i]);
        }

    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "nombreCliente=" + nombreCliente + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }

}
