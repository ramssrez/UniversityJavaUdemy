
import java.util.Scanner;
//Importar la clase Scanner para usarla

public class HolaMundo {

    public static void main(String args[]) {
        //Sentencia switch es mas para los menus
        var numero =5;
        var numeroTexto = "Valor desconocido";
        
        switch(numero){
            case 1:
                numeroTexto = "Numero Uno";
                break;
            case 2:
                numeroTexto="Numero Dos";
                break;
            case 3:
                numeroTexto="Numero tres";
                break;
            case 4:
                numeroTexto="Numero Cuatro";
                break;
            default:
                numeroTexto="Caso no encontrado";
        }
        System.out.println("numeroTexto = " + numeroTexto);
        
        var mes =1;
        var estacion = "Estacion no valida";
        switch(mes){
            case 1:
            case 2:
            case 12:
                estacion = "Invierno";
                break;
            case 3:
            case 4:
            case 5:
                estacion ="Primavera";
                break;
            case 6:
            case 7:
            case 8:
                estacion = "Verano";
                break;
            case 9:
            case 10:
            case 11:
                estacion="Otoño";
                break;
            default:
            System.out.println("Estacion no valida"); 
        }
        System.out.println("estacion = " + estacion);
        
    }
}
