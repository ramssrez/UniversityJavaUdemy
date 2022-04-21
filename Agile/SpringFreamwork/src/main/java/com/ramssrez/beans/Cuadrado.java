package com.ramssrez.beans;

import com.ramssrez.interfaces.IFigura;
import com.ramssrez.interfaces.IMedidas;

public class Cuadrado implements IFigura {
    private IMedidas medidas;

    public Cuadrado(IMedidas medidas) {
        this.medidas = medidas;
    }

    @Override
    public void imprimirNombre() {
        System.out.println("Figura: Cuadrado");
    }

    @Override
    public void proceso() {
        System.out.println("medidas = " + medidas);
        this.medidas.realizarCalculos("Cuadrado");
    }
}
