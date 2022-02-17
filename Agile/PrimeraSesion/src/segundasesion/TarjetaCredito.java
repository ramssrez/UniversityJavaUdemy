package segundasesion;

public class TarjetaCredito implements ProductoFinanciero {
    private double lineaCredito;
    private double saldo;

    public TarjetaCredito(double lineaCredito) {
        this.lineaCredito = lineaCredito;
        this.saldo = 0;
    }

    public double getLineaCredito() {
        return lineaCredito;
    }

    public double getSaldo() {
        return saldo;
    }
    public void pagarTarjeta(double importe){
        saldo +=importe;
    }
    public void cargarTarjeta(double importe){
        if(saldo-importe <lineaCredito*-1){
            System.out.println("Linea de credito insuficiente");
        }else{
            saldo-=importe;
        }
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("******************************************************************************");
        System.out.println("Estado de cuenta de tarjeta de cheques.....");
        System.out.println("Saldo : " + saldo);
        System.out.println("Linea de credito: " + lineaCredito);
        System.out.println("******************************************************************************");

    }
}
