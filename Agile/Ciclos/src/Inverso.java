import java.util.Scanner;

public class Inverso {
    public static void main(String[] args) {
        String [] strings = new String[8];
        Scanner scanner = new Scanner(System.in);
        for (int i=0; i<strings.length;i++){
            System.out.print("Ingrsa un valor: ");
            strings[i] = scanner.next();
        }
        System.out.println("El orden inverso es: ");
        for (int i=strings.length-1; i>=0;i--){
            System.out.print(strings[i] + " ");
        }
    }
}
