
import java.util.Scanner;
//Importar la clase Scanner para usarla
public class HolaMundo {

    public static void main(String args[]) {
        
        //Operadores Unarios
        int a = 3;
        var b = -a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        
        //operador de negación, tipo oolean
        var c= true;
        var d = !c; //Operador de negación !, solo para boleanos
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        
        //Operdor de incrementos
          //Preincremento (simbolo antes de la variable)
          var e =3;
          var f =++e; //Primero se incrementa la variable y despues se usa 
          System.out.println("e = " + e);
          System.out.println("f = " + f);
          
          //Posincremento ( despues de la variable)
          var g=5;
          var h=g++; //Primero se utiliza el valor de la varible y despues se incrementa
          System.out.println("g = " + g);
          System.out.println("h = " + h);
          
          
          
          
        
    }
    
}