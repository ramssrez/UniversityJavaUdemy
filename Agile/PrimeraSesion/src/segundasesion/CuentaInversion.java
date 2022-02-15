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
}
