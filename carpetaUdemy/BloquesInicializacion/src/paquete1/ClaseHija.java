package paquete1;

import paquete1.Clase1;

public class ClaseHija extends Clase1 {
    public ClaseHija(){
        super();
        this.atributoDefaul = "Modificación del atributo default";
        System.out.println("atributo default: " + this.atributoDefaul);
        this.metodoDefault();
    }
    
}
