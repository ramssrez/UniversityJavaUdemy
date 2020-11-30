package test;

public class TestArgumentosVariables {

    public static void main(String[] args) {
        imprimirNumeros(3,4,5);
        imprimirNumeros(1,2,5);
    }
    
    //Método que recibe argumentos variables, no es necesario saber el número exacto
    private static void imprimirNumeros(int... numeros){
        for (int i = 0; i <numeros.length; i++) {
            System.out.println("Elemento: " + numeros[i]);
        }
    }
}
