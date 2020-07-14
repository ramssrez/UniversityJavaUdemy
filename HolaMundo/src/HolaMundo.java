
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
        
        //Uso del ciclo for
        for(var contadorDos = 0;contadorDos<3;contadorDos++){
            System.out.println("contadorDos = " + contadorDos);
        }
    }
}
