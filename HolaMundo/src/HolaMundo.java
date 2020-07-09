
import java.util.Scanner;
//Importar la clase Scanner para usarla
public class HolaMundo {

    public static void main(String args[]) {
       //Convertir un tipo String a tipo int con el metodo parseInt
       var edad = Integer.parseInt("20");
        System.out.println("edad = " + edad);
        System.out.println("edad = " + (edad+1));
        
        var edadDos ="20";
        System.out.println("edadDos = " + edadDos);
        //No realiza la suma, solo concatena con el numero 1
        System.out.println("edadDos = " + (edadDos+1));
        
        var valorPi = Double.parseDouble("3.1416");
        System.out.println("valorPi = " + valorPi);
        
        //Pedir un valor
//        System.out.println("Ingrese tu edad: ");
        var consola = new Scanner(System.in);
//        edad = Integer.parseInt(consola.nextLine());
//        System.out.println("Edad = " + edad );
//        
        //Conversion del tipo string al tipo int
        var edadTexto = String.valueOf(10);
        System.out.println("edadTexto = " + edadTexto);
        
        //Con el metodo charAt(index), nos regresa el valor
        //que se le ha asignado a ese indice
        var caracter = "Hola".charAt(0);
        System.out.println("caracter = " + caracter);
        
        System.out.println("Proporciona un caracter");
        //Estamos parseando de tipo caracter en donde solo tomara uno de ellos
        caracter = consola.nextLine().charAt(0);
        System.out.println("caracter = " + caracter);
    }
}
