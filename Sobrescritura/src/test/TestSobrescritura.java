
package test;

import clases.*;


public class TestSobrescritura {
    public static void main(String[] args) {
        //Uso de la clase padre
        Empleado empleado = new Empleado("Juan", 5000);
        System.out.println("empleado = " + empleado.obtenerDetalles());
        Gerente gerente = new Gerente("Karla" ,10000, "Sistemas Artificiales" );
        gerente.obtenerDetalles();
        System.out.println("gerente = " + gerente.obtenerDetalles());
        
        //Esto es despues para el polimorfismo
        System.out.println("");
        imprimir(empleado);
        System.out.println("");
        imprimir(gerente);
    }
    
    public static void imprimir (Empleado empleado){
        System.out.println("empleado = " + empleado.obtenerDetalles());
    }
    
}
