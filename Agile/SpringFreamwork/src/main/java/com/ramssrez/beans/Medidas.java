package com.ramssrez.beans;

import com.ramssrez.interfaces.IMedidas;

public class Medidas implements IMedidas {
    @Override
    public void realizarCalculos(String nombre) {
        System.out.println("Realizando cálculos para la figura: " + nombre);
    }
}
