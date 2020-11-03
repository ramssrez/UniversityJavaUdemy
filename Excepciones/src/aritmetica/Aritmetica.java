package aritmetica;

import excepcion.OperadorEcxepcion;

public class Aritmetica {
    public static int division(int numerador, int denominador) throws OperadorEcxepcion{
        if(denominador == 0){
            throw new OperadorEcxepcion("Divición entre cero");
        }
        return numerador/denominador;
    }
}
