package com.ramssrez.beans;

import com.ramssrez.interfaces.IMedidas;
import org.springframework.stereotype.Component;

@Component("medidas")
public class Medidas implements IMedidas {
    @Override
    public void realizarCalculos(String nombre, String unidadesMedida) {
        System.out.println("Realizando cálculos para la figura: " + nombre +  " en " +unidadesMedida);
    }
}
