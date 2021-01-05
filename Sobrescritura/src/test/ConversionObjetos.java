package test;

import clases.*;

public class ConversionObjetos {
    public static void main(String[] args) {
        Empleado empleado;
        
        empleado = new Escritor("Juand", 10000, TipoEscritura.CLASICO);
        System.out.println("empleado = " + empleado);

    }
}
