
//Importar la clase Scanner para usarla
import java.util.Scanner;
public class HolaMundo {

    public static void main(String args[]) {
        /*
         Tipos primitivos enteros:
        Si se va ahorrar espacio es recomendable el bite
        byte 8 bits   Rango[-128,127]
        short 16 bits Rango[-32768,32767]
        int 32 bits   Rango[-2^31,2^31-1]
        long 64 bits  Rango[-2^63,2^63-1]
        char 16 bits  Rango[0,65535]
        
        
        Tipos prmitivos flotantes
        float 32 bits Rango[1.4e-0.45, 3.4e+038]
        double 64 bits Rango[4.9e-324,1.8e+308]
        boolean       true or false
        */  
        byte numeroByte = 10;
        System.out.println("numeroByte = " + numeroByte);
        //Parseo de para que se pueda realizar en byte
        numeroByte =(byte) 129;
        System.out.println("numeroByte = " + numeroByte);
        
        //Valores minimos y máximos del byte
        System.out.println("Valor minimo byte: " + Byte.MIN_VALUE);
        System.out.println("Valor máxmo byte: " + Byte.MAX_VALUE);
        
        //Valors minimos y maximos del short
        short numeroShort = 10;
        System.out.println("numeroShort = " + numeroShort);
        System.out.println("Valor minimo short" + Short.MIN_VALUE);
        System.out.println("Valor minimo short" + Short.MAX_VALUE);

        
    }
}
