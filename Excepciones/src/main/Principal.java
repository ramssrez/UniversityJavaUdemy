package main;

import static aritmetica.Aritmetica.division;

public class Principal {

    public static void main(String[] args) {
        double resultado = 0;

        try {
            resultado = division(10, 0);

        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
            e.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    public static double dividir(double dividiendo, double divisor) {
        return (dividiendo / divisor);
    }

}