
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
        determinarTipo(empleado);
        System.out.println("");
        empleado = new Gerente ("Karla", 10000, "Contabilidad");
        imprimir(empleado);
        determinarTipo(empleado);
    }
    
    public static void imprimir (Empleado empleado){
        System.out.println("empleado = " + empleado.obtenerDetalles());
    }
    
    //Las siguientes lineas es para determinar el tipo de la variable con un intance of
    public static void determinarTipo (Empleado empleado){
        if(empleado instanceof Gerente){
            System.out.println("Es de tipo Gerente");
        } if(empleado instanceof Empleado){
            System.out.println("Es de tipo Empleado ");
        } if (empleado instanceof Object){
            System.out.println("Es de tipo Object");
        }
    }
    
}
