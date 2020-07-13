
import java.util.Scanner;
//Importar la clase Scanner para usarla

public class HolaMundo {

    public static void main(String args[]) {
        var mes = 11;
        if (mes == 1 || mes == 2 || mes == 12){
            System.out.println("Estas en Invierno");
            
        }else if(mes == 3|| mes == 4|| mes == 5 ){
            System.out.println("Estas en Primavera");
        }else if (mes == 6|| mes == 7 || mes ==8){
            System.out.println("Estas en Verano");
        }else if (mes == 9|| mes == 10|| mes == 11){
            System.out.println("Estas en Otoño");
        }else {
            System.out.println("Este es no es un mes del año");
        }
        
    }
}
