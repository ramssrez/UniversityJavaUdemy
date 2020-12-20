
package paquete1;

//uso del modificador de acceso default o package el cual no tiene modificador
class Clase1 {
    //Protected no esta en el nivel de la clase
    String atributoDefaul = "Valos atributo Default";
    
    Clase1 (){
        System.out.println("Constructor default");
    }
   
    void metodoDefault(){
        System.out.println("Esto es un método default");
    }
    
}
