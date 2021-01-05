package test;

import clases.*;

public class ConversionObjetos {
    public static void main(String[] args) {
        Empleado empleado;
        
        empleado = new Escritor("Juan", 10000, TipoEscritura.CLASICO);
        System.out.println("empleado = " + empleado);
        
        System.out.println(empleado.obtenerDetalles());
        
        //Sintaxis para castear de la clase padre a la clase hija (Downcasting)
        ((Escritor)empleado).getTipoEscritura();
        
        //Sintaxis para realizar upcasting
        Escritor escritor = (Escritor) empleado;
        escritor.getTipoEscritura();
        Empleado empleado2 = escritor;
        System.out.println(empleado2.obtenerDetalles());
    }
}
