package test;

import paquete1.Clase1;
import paquete2.ClaseHija;

public class TestModificadores {
    public static void main(String[] args) {
        System.out.println("");
        Clase1 clase1 = new Clase1("Publico");
        //Tenemos acceso al atributo publico de la clase que se ha declarado en otro paquete
        System.out.println("");
        System.out.println("clase1 = " + clase1.atributoPublico);
        clase1.metodoPublico("Publico");
        
        ClaseHija claseHija = new ClaseHija();
        System.out.println("claseHija = " + claseHija);
    }
}
