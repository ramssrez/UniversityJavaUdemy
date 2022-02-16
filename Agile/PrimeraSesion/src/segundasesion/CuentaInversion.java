package segundasesion;

public class CuentaInversion extends CuentaBancaria{
    private double inversion;
    public CuentaInversion(double balance, double inversio) {
        super(balance);
        this.inversion = inversio;
    }

    public void agplicarCorrte(){
        agregarFondos(getBalance()*inversion);
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("Estado de cuenta de inversión.....");
        System.out.println("Balance : " + getBalance());
        System.out.println("Inversión obtenida: " + inversion);
    }
}
