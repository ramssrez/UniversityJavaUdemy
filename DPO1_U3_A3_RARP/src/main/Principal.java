package main;

public class Principal {

    public static void main(String[] args) {
        double resultado;

        try {
            resultado = 10 / 0;
            System.out.println("resultado = " + resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("El try catch ha terminado");
        }

    }

    public static double dividir(double dividiendo, double divisor) {
        return (dividiendo / divisor);
    }

}
