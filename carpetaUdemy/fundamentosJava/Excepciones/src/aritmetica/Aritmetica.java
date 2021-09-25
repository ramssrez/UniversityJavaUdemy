package aritmetica;

import excepcion.OperadorExcepcion;

public class Aritmetica {

    public static int division(int numerador, int denominador) {
        if (denominador == 0) {
            throw new OperadorExcepcion("Divición entre cero");
        }
        return numerador / denominador;
    }
}
