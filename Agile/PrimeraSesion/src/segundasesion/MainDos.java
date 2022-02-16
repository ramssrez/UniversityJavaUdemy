package segundasesion;

public class MainDos {
    public static void main(String[] args) {
        CuentaInversion cuentaBancaria = new CuentaInversion(1000.0,0.05);
        System.out.println("Balance inicial = " + cuentaBancaria.getBalance());
        System.out.println("Retiro: 600");
        cuentaBancaria.reducirFondos(600.0);
        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());
        System.out.println("Retiro: 600");
        cuentaBancaria.reducirFondos(600.0);
        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());
        //aplicar corte
        cuentaBancaria.agplicarCorrte();
        System.out.println("Aplicando corte............");
        System.out.println("Nuevo balance: " + cuentaBancaria.getBalance());
        cuentaBancaria.imprimirEstadoCuenta();

    }
}
