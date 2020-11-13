package main;

import clases.Asiento;
import clases.Reserva;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static Asiento asientos[][] = null;
    public static char filas[] = {'A', 'B', 'C', 'D', 'E', 'F'};
    public static int columnas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

    public static void main(String[] args) {
        creacionObjetosAsiento();
        //Declaración de varaibles para hacer uso del menú
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        //Uso de la clase Scanner para recibir valores de la consola
        Scanner scan = new Scanner(System.in);
        //Varaible que incrementa el número de reservas realizadas
        int opcional = 0;
        while (!salir) {
            //Impresión de las opciones del menú
            System.out.println("1.- Reservar");
            System.out.println("2.- Cancelar Reserva");
            System.out.println("3.- Consular");
            System.out.println("4.- Salir");
            //Uso de la sentecia try/catch para que solo ingrese un número

            try {
                System.out.print("Selecciona una de la opciones: ");
                opcion = scan.nextInt();
                //Uso de la sentencia switch para las opciones del menú
                switch (opcion) {
                    //Caso 1 en donde se realiza el llenado de los salarios
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Asignación de ciclo bidimencional de arreglos con un método que se manda a llamar
                        System.out.println("Opcional " + opcional);
                        opcional = opcional + 1;
                        System.out.println("opcional " + opcional);
                        crearReserva(asientos);

                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 donde se verifica si ya hay información de los salarios y en caso afirmativo imprimir los salarios de las diferetes áreas
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Sentencia if/else que verifica si el arreglo contiene datos
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;

                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        impresionAsientos(asientos);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3 donde da por terminado el programa y sale del menú
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Has seleccionado la opción 4");
                        System.out.println("Gracias por tu visita. Adiós!!!!!");
                        salir = true;
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso default que manda un error en caso de que no se cumpla con las tres primeras opciones
                    default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("ERROR, el número no corresponde al rango de 1 a 4");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                }
            } catch (InputMismatchException e) {
                //Excepción en caso de que se ingrese una letra o un caracter que no sea igual al esperado
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                System.out.println("Debes de ingresar un número");
                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                scan.next();
            }

        }
    }

    public static void crearReserva(Asiento asientos[][]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa tu apellido: ");
        String apellido = scanner.nextLine();
        //System.out.println("Ingresa el numero de asiento");
        //int numeroAsiento = scanner.nextInt();
        int numeroAsiento = 0;

        boolean salir = false;
        while (!salir) {
            System.out.print("Ingresa el numero de asiento: ");
            numeroAsiento = scanner.nextInt();
            if ((numeroAsiento == 4) || (numeroAsiento == 17) || (numeroAsiento == 34) || (numeroAsiento == 61) || (numeroAsiento == 62)
                    || (numeroAsiento == 63) || (numeroAsiento == 64) || (numeroAsiento == 91) || (numeroAsiento == 92) || (numeroAsiento == 93)
                    || (numeroAsiento == 94) || (numeroAsiento == 124) || (numeroAsiento == 154) || (numeroAsiento == 167) || (numeroAsiento > 180)) {
                System.out.println("No se puede asignar este asiento");
            } else {
                salir = true;
            }
        }
        
        Reserva reserva = new Reserva(nombre, apellido, numeroAsiento);

    }

    public static void creacionObjetosAsiento() {
        int suma = 0;
        Asiento asientosEjemplos[][] = new Asiento[filas.length][columnas.length];

        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                suma = suma + 1;
                asientosEjemplos[i][j] = new Asiento(filas[i], columnas[j], false);
            }
        }
        asientosEjemplos[2][0].setOcupado(true);
        asientosEjemplos[2][1].setOcupado(true);
        asientosEjemplos[2][2].setOcupado(true);
        asientosEjemplos[2][3].setOcupado(true);
        asientosEjemplos[3][0].setOcupado(true);
        asientosEjemplos[3][1].setOcupado(true);
        asientosEjemplos[3][2].setOcupado(true);
        asientosEjemplos[3][3].setOcupado(true);
        asientosEjemplos[0][3].setOcupado(true);
        asientosEjemplos[0][16].setOcupado(true);
        asientosEjemplos[1][3].setOcupado(true);
        asientosEjemplos[4][3].setOcupado(true);
        asientosEjemplos[5][3].setOcupado(true);
        asientosEjemplos[5][16].setOcupado(true);

        asientos = asientosEjemplos;
    }

    public static void impresionAsientos(Asiento asientos[][]) {
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                //System.out.println("Asientos: " + asientosEjemplos[i][j].toString());
                if (asientos[i][j].isOcupado()) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println(" ");
        }
    }

}
