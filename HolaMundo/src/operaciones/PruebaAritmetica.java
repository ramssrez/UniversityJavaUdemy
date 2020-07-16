package operaciones;
public class PruebaAritmetica {
    public static void main(String [] args){
        //Variables locales y su alcance, solo hasta el metodos
        int a=3;
        int b=5;
        /*
        La palabra reservada var, solo se usa en variables locales
        no se puede usar en los argumetos de la clase 
        ni en los atributos de los metodos
        */        
        
        //Llamado del metodo que declaramos, pero es necesario la palabra static
        miMetodo();
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
    public static void miMetodo(){
        //La variales esta fuera del alcance donde fue definida
        //a=10;
        System.out.println("Otro metodo");
    }
}
