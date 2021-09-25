package operaciones;
/*
Todas las variables locales se agregan en la memoria stack
Lo objetos se crean en la memoria heap
los atributos del objeto tambien se crean en la memoria heap
*/
public class PruebaCaja {
    public static void main(String [] args){
        var ancho = 3;
        var alto = 2;
        var profundo = 6;
        
        Caja caja = new Caja();
        var volumen = caja.volumenArguemntos(alto, ancho, profundo);
        System.out.println("volumen = " + volumen);
        Caja cajaDos = new Caja(3,2,6);
        System.out.println("cajaDos = " + cajaDos.volumen());
    }
       
}
