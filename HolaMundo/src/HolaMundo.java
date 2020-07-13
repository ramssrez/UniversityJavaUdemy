
import java.util.Scanner;
//Importar la clase Scanner para usarla

public class HolaMundo {

    public static void main(String args[]) {
        //Sentencias de control if else
        var condicion = true;
        if (condicion){
            System.out.println("Esta condicion es verdadera");
            System.out.println("Nueva línea");
        }else{
            System.out.println("Esta condicion es falsa");
        }
        
        
        var numero =2;
        var numeroTexto ="Numero desconocido";
        if (numero == 1){
            numeroTexto = "Numero Uno";
        }else if(numero == 2){
            numeroTexto ="Numero Dos";
        }else if (numero == 3){
            numeroTexto="Numero Tres";
        }else {
            System.out.println("Numero no encontrado");
        }
        
        System.out.println("numeroTexto = " + numeroTexto);
    }
}
