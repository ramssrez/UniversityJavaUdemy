package main;

public class Principal {
    public static void main(String[] args) {
        double dividendo = 50.0;
        double divisor = 0;
        System.out.println("El resultado dividir " + dividendo +" entre " + divisor+ " es: " + dividir(dividendo, divisor));
    }
    
    public static double dividir (double dividiendo, double divisor){
        return(dividiendo/divisor);
    }
 
}
