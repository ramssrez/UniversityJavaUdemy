
import java.util.Scanner;
//Importar la clase Scanner para usarla
public class HolaMundo {

    public static void main(String args[]) {
        //Operaciones de asignacion y relacionales
        var a = 3;
        var b=2;
        //Operador de igualdad ==
        var c =(a ==b); //Es igual igula
        System.out.println("c = " + c);
       
        //Operador de desigualdad o diferente de != 
        var d = a!=b;
        System.out.println("d = " + d);
        
        //La igualdad no funcina con objetos
        var cadena1 = "Hola";
        var cadena2="Adios";
        var e = cadena1==cadena2; //Compara la referencia de onbetos
        
        //No se esta comparando las variables, ya que son de tipo string
        System.out.println("e = " + e);
        var f = cadena1.equals(cadena2); //Comparamos contenidos de cadenas
        //Es la manera correcta de igualar unos objetos
        System.out.println("f = " + f);
        
    }
    
}