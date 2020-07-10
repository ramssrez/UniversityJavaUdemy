
import java.util.Scanner;
//Importar la clase Scanner para usarla
public class HolaMundo {

    public static void main(String args[]) {
       //Operadores de asignación
       int a = 3, b=2;
       int c = a +5 -b;
       //La asignación va de izquierda a derecha, se le agnación de c
        System.out.println("c = " + c);
       
       a+=1;//a = a+1 operadorde composición de suma
        System.out.println("composición suma a = " + a);
        a +=3; //a=a+3
        System.out.println("a = " + a);
        
        a-=2; //Operador composicion de resta
        //a=a-2
        System.out.println("composición resta a = " + a);
        a/=2; //Operador de composición de división
        System.out.println("composición división a = " + a);
        
        a*=3; //Operador de composición de multiplicación
        System.out.println("composición multiplicación a = " + a);
        
        a%=2; //Operador de composición de modulo
        System.out.println("composición modulo a = " + a);
     
 
        
    }
}