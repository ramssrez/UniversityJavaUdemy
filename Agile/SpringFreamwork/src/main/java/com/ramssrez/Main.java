package com.ramssrez;

import com.ramssrez.beans.Circulo;
import com.ramssrez.interfaces.IFigura;

public class Main {
    public static void main(String[] args) {
        IFigura circulo = new Circulo();
        circulo.imprimirNombre();
    }
}
