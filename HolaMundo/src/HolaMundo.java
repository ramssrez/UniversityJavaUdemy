
import java.util.Scanner;
//Importar la clase Scanner para usarla

public class HolaMundo {

    public static void main(String args[]) {
        //Operadores condicionales
        var a =10;
        var min = 0;
        var max=10;
        //uso del ooperador and &&
        var resultado = a>=min && a<=max;
        //Resultado es verdadero true y true
        //si un uno de los operando es falso el resultado es falso
        System.out.println("resultado = " + resultado);
        
        if(resultado){
            System.out.println("Dentro de rango");
        }else{
            System.out.println("Fuera de rango");
        }
        
        //Otra forma de expresar el if
         if((a>=min) && (a<=max)){
            System.out.println("Dentro de rango");
        }else{
            System.out.println("Fuera de rango");
        }
         
         //Para el caso del OR, ||, si uno es verdades, el resultado es verdader
        //Padre puede ir al juego de su hijo
        var vacaciones = false;
        var descanso = true;
        
        if(vacaciones||descanso){
            System.out.println("Padre puede ir al juego");
        }else{
            System.out.println("Padre no puede ir al juego");
        }
       
    }
}
