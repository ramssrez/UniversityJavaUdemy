import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        //Ejercicio de edad
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa la edad: ");
        int edad = scanner.nextInt();
        String mensaje = edad >= 18 ? "Ya puedes votar":"Aún no puedes votar";
        System.out.println(mensaje);

        //ejercicios login
        final String USUARIO ="admin";
        final String PASSWORD = "123456";
        System.out.print("Ingresa tu usario: ");
        String userName = scanner.next();
        System.out.print("Ingresa tu password: ");
        String pass = scanner.next();
        String mensajeDos  = (USUARIO.equals(userName) && PASSWORD.equals(pass)) ? "Inicio de sesión correcto":"Usuario o contraseña incorrectas";
        System.out.println(mensajeDos);
    }
}
