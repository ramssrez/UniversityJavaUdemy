package paquete2;

import paquete1.Clase1;

public class ClaseHija extends Clase1 {
    public ClaseHija(){
        super();
        this.atributoProtected = "Modificación del atributo protected";
        System.out.println("atributo protegido: " + this.atributoProtected);
        this.metodoProtected();
    }
    
}
