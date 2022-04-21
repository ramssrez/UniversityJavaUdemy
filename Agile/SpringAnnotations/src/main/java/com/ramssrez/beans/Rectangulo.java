package com.ramssrez.beans;

import com.ramssrez.interfaces.IFigura;
import com.ramssrez.interfaces.IMedidas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("rectangulo")
public class Rectangulo implements IFigura {
    private IMedidas medidas;
    private String unidades;

    @Autowired
    public Rectangulo(@Qualifier("medidas")IMedidas medidas) {
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
