
package pasoPorValor;
//Ejercicio de paso por Valor
public class PasoPorValor {
    public static void main(String []args){
        var x = 10;
        System.out.println("x = " + x);
        
        //Solo pasamos una compia del valor
        cambioValor(x);
        System.out.println("x = " + x);
    }
    
    public static void cambioValor(int arg1){
        System.out.println("arg1 = " + arg1);
        arg1=15;
    }
}
