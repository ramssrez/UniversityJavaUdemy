package main;

import static aritmetica.Aritmetica.division;
import excepcion.OperadorExcepcion;

public class Principal {

    public static void main(String[] args) {
        double resultado = 0;
        int numeros[] = {1,4,2,3};
        
        try {
            //resultado = division(10, 0);
            System.out.println(numeros[10]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Ocurrio un error de tipo ArrayIndex " + e.getMessage());
        }catch(ArithmeticException e){
            System.out.println("Ocurrio un error de ArithmeticaException " + e.getMessage());
        }catch(OperadorExcepcion e){
            System.out.println("Ocurrio un erro de tipo Operacion Exception " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Ocurrio un error de tipo Exception: " + e.getMessage());
            //e.printStackTrace(System.out);
        }finally{
            System.out.println("Se realizo la divición entre cero ");
        }
        
        
        System.out.println("resultado = " + resultado);
    }

    public static double dividir(double dividiendo, double divisor) {
        return (dividiendo / divisor);
    }

}
