package segundasesion;

public class CuentaBancaria {
    private double balance;

    public CuentaBancaria(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void agregarFondos(double importe){
        this.balance += importe;
    }

    public void reducirFondos(double importe){
        if (importe > balance) {
            System.out.println("Fondos insuficientes");
        }else{
            this.balance -= importe;
        }
    }
}
