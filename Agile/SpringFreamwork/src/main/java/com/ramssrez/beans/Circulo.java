package com.ramssrez.beans;

import com.ramssrez.interfaces.IFigura;
import com.ramssrez.interfaces.IMedidas;

public class Circulo implements IFigura {
    private IMedidas medidas;

    public Circulo(IMedidas medidas) {
        this.medidas = medidas;
    }

    @Override
    public void imprimirNombre() {
        System.out.println("Figura: Circulo");
    }

    @Override
    public void proceso() {
        this.medidas.realizarCalculos("Circulo");
    }
}
