package operaciones;
public class PruebaAritmetica {
    public static void main(String [] args){
        Aritmetica aritmetica = new Aritmetica();
        //Se declara espacio de memoria
        
        aritmetica.a = 3;
        aritmetica.b = 2;
        aritmetica.sumar();
        
        int resultado = aritmetica.sumarRetorno();
        //De esta manera le asignamos el valor de retorno del metodo
        
        System.out.println("resultado desde prueba = " + resultado);
    }   
}
