package com.ramssrez.beans;

import com.ramssrez.interfaces.IFigura;

public class Circulo implements IFigura {
    @Override
    public void imprimirNombre() {
        System.out.println("Figura: Circulo");
    }
}
