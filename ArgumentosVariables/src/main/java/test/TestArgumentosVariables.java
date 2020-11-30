package test;

public class TestArgumentosVariables {

    public static void main(String[] args) {
        imprimirNumeros(3,4,5);
        imprimirNumeros(1,2,5);
        variosParametros("Juan", 2,3,4,5);
    }
    
    //Método que recibe argumentos variables, no es necesario saber el número exacto
    private static void imprimirNumeros(int... numeros){
        for (int i = 0; i <numeros.length; i++) {
            System.out.println("Elemento: " + numeros[i]);
        }
    }
    
    //El parámetro de entrada de los argumentos de varibales tiene que estar al final de los variables 
    private static void variosParametros(String nombre, int... numeros){
        System.out.println("Nombre: " + nombre);
        imprimirNumeros(numeros);
    }
    
    //Este es el mismo ejemplo pero con el vararg al inicio marcando un error
    /*
       private static void variosParametrosDos( int... numeros, String nombre){
        System.out.println("Nombre: " + nombre);
        imprimirNumeros(numeros);
    }7
    */

    
}
