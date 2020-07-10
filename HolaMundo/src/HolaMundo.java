
import java.util.Scanner;
//Importar la clase Scanner para usarla

public class HolaMundo {

    public static void main(String args[]) {
        //Operaciones de asignacion y relacionales
        var a = 3;
        var b = 2;
        //Operador de igualdad ==
        var c = (a == b); //Es igual igula
        System.out.println("c = " + c);

        //Operador de desigualdad o diferente de != 
        var d = a != b;
        System.out.println("d = " + d);

        //La igualdad no funcina con objetos
        var cadena1 = "Hola";
        var cadena2 = "Adios";
        var e = cadena1 == cadena2; //Compara la referencia de onbetos

        //No se esta comparando las variables, ya que son de tipo string
        System.out.println("e = " + e);
        var f = cadena1.equals(cadena2); //Comparamos contenidos de cadenas
        //Es la manera correcta de igualar unos objetos
        System.out.println("f = " + f);

        //Operadores relacionales
        var g = a > b; //Operdor de mayor que
        System.out.println("g = " + g);
        g = a >= b;
        System.out.println("g = " + g); //Operador de mayor o igual que
        
        //Operación de igualdad
        if (a % 2 == 0) {
            System.out.println("Es Número par");
        } else {
            System.out.println("Es Número impar");
        }
        
        var edad = 10;
        var adulto =18;
        
        //Operacion relacional
        if(edad >=adulto){
            System.out.println("Es un adulto");
        }else{
            System.out.println("Es menor de edad");
        }
             
    }
}
