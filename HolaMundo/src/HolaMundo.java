
import java.util.Scanner;
//Importar la clase Scanner para usarla

public class HolaMundo {

    public static void main(String args[]) {
        //Operadores Ternarios
        //Simplificacion del if else
        var resultado = (1 > 2) ?"Verdadero":"falso" ;
        System.out.println("resultado = " + resultado);
        
        var numero = 9;
        resultado = (numero%2==0) ?"Numero Par":"Numero Impar";
        System.out.println("resultado = " + resultado);
    }
}
