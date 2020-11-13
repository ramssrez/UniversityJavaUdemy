package clases;

import java.util.Arrays;
import java.util.Scanner;

public class Pruebas {

    public static void main(String[] args) {
        //Creación de la matriz
        int suma = 0;
        int asiento[][] = new int[6][6];
        Asiento asientos[] = null;
        Asiento asientoEjemplo = null;
        Reserva reservas[] = new Reserva[180];
        Scanner scanner = new Scanner(System.in);

        char filas[] = {'A', 'B', 'C', 'D', 'E', 'F'};
        int columnas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        Asiento asientosEjemplos[][] = new Asiento[filas.length][columnas.length];

        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                suma = suma + 1;
                asientosEjemplos[i][j] = new Asiento(filas[i], columnas[j], false);
            }
        }

        //Asientos acupados que no puede reservar el usuario
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

        Asiento ocupados[] = {asientosEjemplos[2][0]};

        int opcional = 0;
        System.out.println("opcional " + opcional);

//        System.out.println("Ingresa tu nombre: ");
//        String nombre = scanner.nextLine();
//        System.out.println("Ingresa tu apellido: ");
//        String apellido = scanner.nextLine();
//        System.out.println("Ingresa el numero de asientos");
//        int numeroAsiento = scanner.nextInt();
        Reserva reserva = new Reserva("Jose", "Jimenez", 118);
        //reservas = new Reserva[opcional];
        reservas[opcional] = reserva;
        opcional = opcional + 1;
        System.out.println("opcional " + opcional);

        // reservas = new Reserva[opcional];
        Reserva reserva2 = new Reserva("Manuel", "Jimenez", 115);
        reservas[opcional] = reserva2;
        opcional = opcional + 1;
        System.out.println("opcional " + opcional);

        int numeroAsiento = 125;
        //Impresión de las reservas realizadas
        for (int i = 0; i < reservas.length; i++) {
            if (!(reservas[i] == null)) {
                System.out.println("Reservas " + reservas[i]);
            }
        }

        boolean registroExitiso = false;
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                if ((asientosEjemplos[i][j].getIdAsiento() == numeroAsiento) && (!asientosEjemplos[i][j].isOcupado())) {
                    asientosEjemplos[i][j].setOcupado(true);
                    registroExitiso =true;
                    System.out.println("Registro Exitoso");
                }else{
                    registroExitiso = false;
                }
            }
            System.out.println(" ");
        }
        
        if(registroExitiso){
            System.out.println("Registro exitoso");
        }else{
            System.out.println("No se puede realizar el registro");
        }

        //Impresión de los asientos disponibles
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                //System.out.println("Asientos: " + asientosEjemplos[i][j].toString());
                if (asientosEjemplos[i][j].isOcupado()) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println(" ");
        }

        //Impresión del número de asientos.
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                System.out.print(" " + asientosEjemplos[i][j].getIdAsiento());
            }
            System.out.println(" ");
        }

    }

}
