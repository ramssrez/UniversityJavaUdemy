package com.ramssrez.beans;

import com.ramssrez.interfaces.IFigura;
import com.ramssrez.interfaces.IMedidas;
import org.springframework.stereotype.Component;

@Component("circulo")
public class Circulo implements IFigura {
    private IMedidas medidas;
    private String unidades;

    public Circulo(IMedidas medidas) {
        this.medidas = medidas;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    @Override
    public void imprimirNombre() {
        System.out.println("Figura: Circulo");
    }

    @Override
    public void proceso() {
        System.out.println("medidas = " + medidas);
        this.medidas.realizarCalculos("Circulo",this.unidades);
    }
}
