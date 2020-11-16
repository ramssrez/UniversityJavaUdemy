package clases;

public class CuentaBancaria {

    private String nombreCliente;
    private String numeroCuenta;
    private double saldo;

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        if (nombreCliente.isEmpty()) {
            System.out.println("Cadena vacía, se necesita un nombre");
        } else {
            this.nombreCliente = nombreCliente;
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (nombreCliente.isEmpty()) {
            System.out.println("Cadena vacía, se necesita una cuenta valida");
        } else {
            this.numeroCuenta = numeroCuenta;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo<0){
            System.out.println("No se permite valores negativos en la cuenta");
        }else{
             this.saldo = saldo;
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "nombreCliente=" + nombreCliente + ", numeroCuenta=" + numeroCuenta + ", saldo=" + saldo + '}';
    }

}
