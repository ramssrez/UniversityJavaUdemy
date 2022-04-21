package com.ramssrez.beans;

import com.ramssrez.interfaces.IFigura;
import com.ramssrez.interfaces.IMedidas;
import org.springframework.stereotype.Component;

@Component
public class Cuadrado implements IFigura {
    private IMedidas medidas;
    private String unidades;


    public Cuadrado(IMedidas medidas) {
        this.medidas = medidas;
    }
    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    @Override
    public void imprimirNombre() {
        System.out.println("Figura: Cuadrado");
    }

    @Override
    public void proceso() {
        System.out.println("medidas = " + medidas);
        this.medidas.realizarCalculos("Cuadrado",this.unidades);
    }
}
