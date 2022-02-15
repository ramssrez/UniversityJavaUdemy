package segundasesion;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria = new CuentaBancaria(1000.0);
        System.out.println("Balance inicial = " + cuentaBancaria.getBalance());
        System.out.println("Retiro: 600");
        cuentaBancaria.reducirFondos(600.0);
        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());
        System.out.println("Retiro: 600");
        cuentaBancaria.reducirFondos(600.0);
        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());

        //Cuenta de cheque: Comisión por retiro
        //Cuenta por inersión: +intereses
        CuentaCheques cuentaCheques = new CuentaCheques(1000.0, 5.0);
        cuentaCheques.getBalance();

    }
}
