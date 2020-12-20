package test;

import paquete1.Clase1;

public class TestModificadores {
    public static void main(String[] args) {
        System.out.println("");
        Clase1 clase1 = new Clase1();
        //Tenemos acceso al atributo publico de la clase que se ha declarado en otro paquete
        System.out.println("");
        System.out.println("clase1 = " + clase1.atributoPublico);
        clase1.metodoPublico();
    }
}
