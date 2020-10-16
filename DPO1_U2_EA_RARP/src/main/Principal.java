package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    String cancun = "Cancún";
    String cozumel = "Cozumel";
    String islaMujeres = "Isla Mujeres";
    String playaCarmen = "Playa del Carmen";
    int total = 0;

    public static void main(String[] args) {
        System.out.println("Bienvenidos al registro de contagiados del estado de Quintana Roo");
        //Declaración de la clase Scanner para poder registrar los datos que ingrese el ususario
        Scanner sn = new Scanner(System.in);
        //Declaración de la variable salir para salir del ciclo while
        boolean salir = false;
        //Declaración de la variable opción donde se guarada la opción que eligío el usuario
        int opcion; //Guardaremos la opcion del usuario
        //Inicio del ciclo while con la sentencia de salir cuando sea verdadera
        while (!salir) {
            //Impresión del menú de los diferentes opciones que contiene, los cuales el usuario puede observar 
            System.out.println("1. Registrar los infectados en los municipios");
            System.out.println("2. Indicar el semáforo que corresponde la entidad");
            System.out.println("3. Mostrar la media de contagios a nivel estatal");
            System.out.println("4. Indicar el municipio que más contagios tuvo y el que menos contagios");
            System.out.println("5. Salir");
            //Uso de la sentencia try/catch para el caso de que el ususario ingrese letras al menú
            try {
                //Impresión para que el ususario registre alguna de las opciones que se le presenta
                System.out.print("Selecciona una de las opciones: ");
                //Uso del objeto sn de la clase scanner para registrar la opción del usuario
                opcion = sn.nextInt();

                //Uso de la sentencia Switch para los diferentes casos en los que el usuario haya elegido
                switch (opcion) {
                    //Caso 1 en donde se ingresa el número de personal que vaya a ser ingresado
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que contiene una varificación del número ingresado, este método no retorna valores.
                        System.out.println("Opción 1");
                        registrarInfectados();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 en donde se obtiene el número de hombres mayores a 50 años.
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que contiene una varificación de la declaración global en caso de que no tenga valores asignados, dependiente del caso 1
                        System.out.println("Opción 2");
                        semaforo();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3 en donde se obtiene el número de mujeres mayores a 50 años.
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que contiene una varificación de la declaración global en caso de que no tenga valores asignados, dependiente del caso 1
                        System.out.println("Opción 3");
                        mediaContagios();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 4 en donde se obtiene el número de hombres que tienen alguna comorbilidad
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que contiene una varificación de la declaración global en caso de que no tenga valores asignados, dependiente del caso 1
                        System.out.println("Opción 4");
                        mayorContagio();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 5 en donde se obtiene se sale del ciclo while
                    case 5:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Has seleccionado la opcion 5");
                        //Cambio de asignación de la variable salir para que salga del ciclo while
                        salir = true;
                        System.out.println("Gracias por tu visita. Adiós!!!!!");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso default en el caso de que no ingrese un valor entre 1 y 5
                    default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("ERROR, el número no corresponde al rango de 1 a 5");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                }
                //Continuación de la sentencia try/catch en donde mandamos un mesaje de que se debe ingresar números al menú.
            } catch (InputMismatchException e) {
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.println("Debes insertar un número");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");

                sn.next();
            }
        }
    }

    public static void registrarInfectados() {
        System.out.println("Método del registro");
    }

    public static void semaforo() {
        System.out.println("Método del semaforo");
    }

    public static void mediaContagios() {
        System.out.println("Método de los contagios");
    }

    public static void mayorContagio() {
        System.out.println("Método de mayor contagio");
    }
}
