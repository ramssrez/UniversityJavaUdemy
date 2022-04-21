package com.ramssrez.beans;

import com.ramssrez.interfaces.IFigura;
import com.ramssrez.interfaces.IMedidas;
import org.springframework.stereotype.Component;

@Component
public class Rectangulo implements IFigura {
    private IMedidas medidas;
    private String unidades;


    public Rectangulo(IMedidas medidas) {
        this.medidas = medidas;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    @Override
    public void imprimirNombre() {
        System.out.println("Figura: Rectángulo");
    }

    @Override
    public void proceso() {
        System.out.println("medidas = " + medidas);
        this.medidas.realizarCalculos("Rectángulo",this.unidades);
    }
}
