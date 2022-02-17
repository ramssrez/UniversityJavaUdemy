package segundasesion;

public class CuentaCheques extends CuentaBancaria{
    double comision;
    public CuentaCheques(double balance, double comisionRetiro) {
        super(balance);
        this.comision = comisionRetiro;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    /*
    public void reducirFondos(double importe){
        if (importe > super.getBalance()) {
            System.out.println("Fondos insuficientes");
        }else{
            double resta = (importe/100)*super.getBalance();
            System.out.println("resta = " + resta);
            //this.balance -= importe;
            double balance = super.getBalance()-resta;
            balance-= resta;
            super.setBalance(balance);
        }
    }
    */

    @Override
    public void reducirFondos(double importe){
        double importeTotal = importe + comision;
        super.reducirFondos(importeTotal);
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("******************************************************************************");
        System.out.println("Estado de cuenta de cheques.....");
        System.out.println("Balance : " +getBalance());
        System.out.println("Comisión de  retiro: " + comision);
        System.out.println("******************************************************************************");

    }


}
