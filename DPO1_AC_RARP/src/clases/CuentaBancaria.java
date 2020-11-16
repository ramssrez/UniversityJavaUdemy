package clases;

public class CuentaBancaria {

    private String nombreCliente;
    private String numeroCuenta;
    private Double saldo;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente.isEmpty()) {
            System.out.println("Cadena Vacía");
        } else {
            this.nombreCliente = nombreCliente;
        }
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

    @Override
    public String toString() {
        return "CuentaBancaria{" + "nombreCliente=" + nombreCliente + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }

}
