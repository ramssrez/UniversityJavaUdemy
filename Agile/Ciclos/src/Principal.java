import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int randomTres = (int) (Math.random()*(10-1)) + 1;
        int valorEntrada;
        Scanner scanner = new Scanner(System.in);
        System.out.println("randomTres = " + randomTres);

        boolean bandera = true;
        while(bandera){
            System.out.print("Ingresa un número: ");
            valorEntrada = scanner.nextInt();
            if(valorEntrada == randomTres){
                System.out.println("El valor es correcto");
                bandera = false;
            }
        }
    }
}
