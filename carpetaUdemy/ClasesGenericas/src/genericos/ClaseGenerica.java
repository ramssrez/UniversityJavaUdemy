package genericos;

public class ClaseGenerica<T> {
    //Definimos T para un tipo Generico de clase, para nuestro caso es el uso 
    //Del generico de la clase.

    T objeto;

    public ClaseGenerica(T objeto) {
        this.objeto = objeto;
    }

    public void obtenerTipo() {
        System.out.println("El tipo T es: " + objeto.getClass());
        System.out.println("El tipo T es: " + objeto.getClass().getSimpleName());
    }

}
