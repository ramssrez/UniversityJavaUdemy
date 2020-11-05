package mx.com.gm.mundopc;

public class Computadora {

    private int idComputadora;
    private String nombre;
    private Monitor monitor;
    private Raton raton;
    private Teclado teclado;
    private static int contadorComputadoras;

    private Computadora() {
        this.idComputadora = ++ Computadora.contadorComputadoras;
    }
    
    public Computadora(String nombre, Monitor monitor, Teclado teclado, Raton raton){
        this();
        
    }
    

}
