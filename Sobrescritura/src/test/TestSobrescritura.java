package test;

import clases.*;

public class TestSobrescritura {

    public static void main(String[] args) {
        //Uso de la clase padre
        Empleado empleado = new Empleado("Juan", 5000);
        System.out.println("empleado = " + empleado.obtenerDetalles());
        Gerente gerente = new Gerente("Karla", 10000, "Sistemas Artificiales");
        gerente.obtenerDetalles();
        System.out.println("gerente = " + gerente.obtenerDetalles());

        //Esto es despues para el polimorfismo
        System.out.println("");
        imprimir(empleado);
        determinarTipo(empleado);
        System.out.println("");
        empleado = new Gerente("Karla", 10000, "Contabilidad");
        imprimir(empleado);
        determinarTipo(empleado);
    }

    public static void imprimir(Empleado empleado) {
        System.out.println("empleado = " + empleado.obtenerDetalles());
    }

    //Las siguientes lineas es para determinar el tipo de la variable con un intance of
    public static void determinarTipo(Empleado empleado) {
        //Dentro de este metod lo dejamos como una relación de if, nos van aparecer las tres opciones
        if (empleado instanceof Gerente) {
            System.out.println("Es de tipo Gerente");
            //Si dejemos esta línea de codigo para entrar a un método de la clase hija
            //No sería posible entrar a el por lo que se tiene que hacer una modificacion
            //Recordemos que la clase padre es Empleado y la clase hija es Gerente
            //empleado.getDepartamento()
            
            
            //Opción 1, creación de una variable local con un parseo de clases,
            //De la clase Empleado a la clase Gerente
            Gerente gerente = (Gerente)empleado;
            System.out.println("gerente = " + gerente.getDepartamento());
 
        } else if (empleado instanceof Empleado) {
            System.out.println("Es de tipo Empleado ");
            //Error de compilación al usar una clase hija cuando hace la preguna de una clase padre
            //El polimorfismo actua en el tiempo de compilación 
            /*
            Gerente gerente = (Gerente)empleado;
            System.out.println("gerente = " + gerente.getDepartamento());
            */
            System.out.println("empleado = " + empleado.getNombre());
 
        } else if (empleado instanceof Object) {
            System.out.println("Es de tipo Object");
            empleado.toString();
        }
    }

}
