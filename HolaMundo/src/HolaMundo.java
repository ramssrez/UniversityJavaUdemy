
import java.util.Scanner;
//Importar la clase Scanner para usarla

public class HolaMundo {

    public static void main(String args[]) {
        //Uso de ciclos(while)
        var contador = 0;
        //Se puede hacer uso de una variable para poder observar la variable
        while(contador <3){
            System.out.println("contador = " + contador);
            contador++;
        }
        
        //Uso de ciclo do/while
        var conta = 0;
        do{
            System.out.println("conta = " + conta);
            conta++;
        }while(conta<3);
        
        //Uso del ciclo for con break
        for(var contadorDos = 0;contadorDos<3;contadorDos++){
            if(contadorDos%2 == 0){
                System.out.println("contadorDos = " + contadorDos);
                break;//Hace que el ciclo se termine
            }
            
        }

        //Cambiando la logica de programacion usando continue
        for (var contadorTres =0;contadorTres<3;contadorTres++){
            if(contadorTres%2 != 0){
                continue;
            }
            System.out.println("contadorTres = " + contadorTres);    
        }
    }
}
