
package paquete1;


public class Clase1 {
    //Protected no esta en el nivel de la clase
    public String atributoPublico ="valor atriuto publico";
    protected String atributoProtected = "Valos atributo protected";
    
    protected Clase1 (){
        System.out.println("Constructor protected");
    }
    public Clase1 (String args){
        System.out.println("Constructor publico");
    }
    
    public void metodoPublico(String args){
        System.out.println("Esto es un metodo publico");
    }
    
    protected void metodoProtected(){
        System.out.println("Esto es un método protected");
    }
    
}
