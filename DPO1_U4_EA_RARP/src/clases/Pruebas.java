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

        //Impresión de las reservas realizadas
        for (int i = 0; i < reservas.length; i++) {
            if(!(reservas[i]==null)){
                            System.out.println("Reservas " + reservas[i]);
            }
        }

        //Impresión del número de asientos.
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                System.out.print(" " + asientosEjemplos[i][j].getIdAsiento());
            }
            System.out.println(" ");
        }

//        //Creación del array del avion
//        for (int i = 0; i < asiento.length; i++) {
//            for (int j = 0; j < asiento[i].length; j++) {
//                suma = suma + 1;
//                asiento[i][j] = suma;
//                asientoEjemplo = new Asiento(filas[i], suma, false);
//                //System.out.println("Asiento ejemplo " + asientoEjemplo.toString());
//                try {
//                    asientos[j] = asientoEjemplo;
//                } catch (Exception e) {
//                    System.out.println("Error  = " + e.getMessage());
//                }
//
//            }
//        }
//        //Impresion de la matriz
//        for (int i = 0; i < asiento.length; i++) {
//            //System.out.print("fila : " + filas[i] + " ");
//            for (int j = 0; j < asiento[i].length; j++) {
//                if ((asiento[i][j]) == 61 || (asiento[i][j] == 62) || (asiento[i][j] == 63) || (asiento[i][j] == 91) || (asiento[i][j] == 92) || (asiento[i][j] == 93)
//                        || (asiento[i][j]) == 4 || (asiento[i][j] == 34) || (asiento[i][j] == 64) || (asiento[i][j] == 94) || (asiento[i][j] == 124) || (asiento[i][j] == 154)
//                        || (asiento[i][j]) == 17 || (asiento[i][j] == 167)) {
//                    System.out.print("  0  ");
//                } else {
//                    System.out.print(asiento[i][j] + "    ");
//                }
//
//            }
//            System.out.println("");
//        }
        //Crecion de los objetos tipo Asiento
//        for (int i = 0; i < filas.length; i++) {
//            for (int j = 0; j < columnas.length; j++) {
//                Asiento asiento = new Asiento(filas[i], columnas[j]);
//                
//            }
//            
//        }
        //Impresion de asientos de tipo objeto
//        for (int i = 0; i < asientos.length; i++) {
//            System.out.println("Asientos" + asientos[i].toString());
//        }
    }

}