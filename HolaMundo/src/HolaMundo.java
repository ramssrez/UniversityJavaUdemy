
import java.util.Scanner;
//Importar la clase Scanner para usarla
public class HolaMundo {

    public static void main(String args[]) {
       int a=3,b=2;
       var resultado = a + b;  //Operador suma
       System.out.println("resultado = " + resultado);
       
       resultado = a - b;     //Operador resta
       System.out.println("resultado de la resta = " + resultado);
        
       resultado = a * b;    //Operador multiplicación
       System.out.println("resultado de la multiplicación= " +resultado );
        
       resultado = a/b;//Resultado en enteros
       System.out.println("resultado de la división= " + resultado);
        
       var resultadoDos =3.0 / b;    //operador división
       System.out.println("resultado de la división = " + resultadoDos);
        
       resultado = a%b; //Operador modulo
       System.out.println("resultado del modulo= " + resultado);
       
       if (a%2==0){
           System.out.println("Es número par");
       }else{
           System.out.println("Es número impar");
       }
    }
}