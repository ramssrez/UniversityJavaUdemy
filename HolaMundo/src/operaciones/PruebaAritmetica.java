package operaciones;
public class PruebaAritmetica {
    public static void main(String [] args){
        System.out.println("Antes del constructor");
        Aritmetica aritmetica = new Aritmetica();
        
        //Llamado de constructor vacio
        System.out.println("Aritmetica a: " + aritmetica.a);
        System.out.println("Aritmetica b: " + aritmetica.b);
        
        //Llamado de constructor con argumetos
        Aritmetica aritmeticaDos = new Aritmetica(10, 15);
        System.out.println("aritmeticaDos a = " + aritmeticaDos.a);
        System.out.println("aritmeticaDos b = " + aritmeticaDos.b);

    }   
}
