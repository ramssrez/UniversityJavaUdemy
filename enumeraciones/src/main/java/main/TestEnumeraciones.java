package main;

import enumeracion.Dias;

public class TestEnumeraciones {

    public static void main(String[] args) {
        System.out.println("Dia 1: " + Dias.LUNES);
        indicarDiaSemana(Dias.LUNES);
    }

    private static void indicarDiaSemana(Dias dias) {
        switch (dias) {
            case LUNES ->
                System.out.println("Primer día de la semana");
            case MARTES ->
                System.out.println("Segundo día de la semana");
            case MIERCOLES ->
                System.out.println("Tercer día de la semana");
            case JUEVES ->
                System.out.println("Cuarto día de la semana");
            case VIERNES ->
                System.out.println("Quinto día de la semana");
            case SABADO ->
                System.out.println("Sexto día de la semana");
            case DOMINGO ->
                System.out.println("Septimo día de la semana");
            default ->
                System.out.println("No se han ingresado dias de la semana");
        }
    }
}
