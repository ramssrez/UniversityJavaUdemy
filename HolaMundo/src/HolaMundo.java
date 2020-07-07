
//Importar la clase Scanner para usarla
import java.util.Scanner;
public class HolaMundo {

    public static void main(String args[]) {
        System.out.println("Escribe tu nombre: ");
        //Creación un objeto de la clase Scanner
        Scanner consola = new Scanner(System.in);
        // Con esto le estamos asignando a la variables usuario lo que
        //venga de la consola
        
        //El metodo nextLine() nos permite leer datos de la consola
        var usuario = consola.nextLine();
        System.out.println("usuario = " + usuario);
        System.out.println("Escribe el titulo: ");
        var titulo = consola.nextLine();
        System.out.println("Resultado: " + titulo + " " + usuario);
    }
}
