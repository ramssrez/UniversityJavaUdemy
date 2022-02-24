package com.at.intership;

public class CuentaInversion extends CuentaBancaria {

    private double interesAlCorte;

    public CuentaInversion(double balanceInicial, double interesAlCorte) {
        super(balanceInicial);
        this.interesAlCorte = interesAlCorte;
    }

    public void aplicarCorte() {
        // Balance 2000
        // Tasa 5%
        // Interes bruto 100
        // Impuesto 15%
        // Interes neto 85
        // Balance 2085
        agregarFondos(getBalance() * interesAlCorte);
    }

    @Override
    public void imprimirEstadoCuenta() {
        System.out.println("Estado de Cuenta de Inversión ...");
        System.out.println("Balance: " + getBalance());
        System.out.println("Tasa de Interés: " + interesAlCorte);
    }
}
