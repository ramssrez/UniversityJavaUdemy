package main;

import clases.Asiento;
import clases.Reserva;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static Asiento asientos[][] = null;
    public static char filas[] = {'A', 'B', 'C', 'D', 'E', 'F'};
    public static int columnas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    public static Reserva reservas[] = new Reserva[2];

    public static void main(String[] args) {
        creacionObjetosAsiento();
        //Declaración de varaibles para hacer uso del menú
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        //Uso de la clase Scanner para recibir valores de la consola
        Scanner scan = new Scanner(System.in);
        //Varaible que incrementa el número de reservas1 realizadas
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
                        opcional = crearReserva(asientos, opcional);
                        System.out.println("Opcional " + opcional);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 donde se verifica si ya hay información de los salarios y en caso afirmativo imprimir los salarios de las diferetes áreas
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Sentencia if/else que verifica si el arreglo contiene datos
                        cancelarReserva(asientos);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;

                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        impresionNumeroAsientos(asientos);
                        impresionReservas(reservas);

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

    public static int crearReserva(Asiento asientos[][], int opcional) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Ingresa el numero de asiento");
        //int numeroAsiento = scanner.nextInt();
        System.out.println("Bienvenidos al sistema de reserva, a continuación se presentará la disponibilidad de asientos en función de las filas disponibles, los asientos que están ");
        System.out.println("marcados con R son asientos ya reservados y los asientos que puedes observar su número son los disponibles.\n");
        impresionNumeroAsientos(asientos);
        System.out.println("\nPara poder realizar tu registro es necesario que registres tu nombre, apellido y el número de asiento");
        int numeroAsiento = 0;
        boolean salir = false;

        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa tu apellido: ");
        String apellido = scanner.nextLine();

        while (!salir) {
            System.out.print("Ingresa el numero de asiento: ");
            numeroAsiento = scanner.nextInt();
            if ((numeroAsiento == 0) || (numeroAsiento == 4) || (numeroAsiento == 17) || (numeroAsiento == 34) || (numeroAsiento == 61) || (numeroAsiento == 62)
                    || (numeroAsiento == 63) || (numeroAsiento == 64) || (numeroAsiento == 91) || (numeroAsiento == 92) || (numeroAsiento == 93)
                    || (numeroAsiento == 94) || (numeroAsiento == 124) || (numeroAsiento == 154) || (numeroAsiento == 167) || (numeroAsiento > 180)) {
                System.out.println("No se puede asignar este asiento");
            } else {
                salir = true;
            }
        }

        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (!asientos[i][j].isOcupado())) {
                    asientos[i][j].setOcupado(true);
                    //registroExitiso =true
                    Reserva reserva = new Reserva(nombre, apellido, numeroAsiento);
                    reservas[opcional] = reserva;
                    opcional = opcional + 1;
                    asientos[i][j].setReserva(reserva);
                    System.out.println("\nRegistro Exitoso");
                    System.out.println("Tu número de asiento es: " + asientos[i][j].getIdAsiento());
                    System.out.println("Se encuentra en la fila: " + asientos[i][j].getFila() + asientos[i][j].getNumeroAsiento());
                } else if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (asientos[i][j].isOcupado())) {
                    System.out.println("No se puede asignar este asiento, ya se encuetra reservado");
                    System.out.println("Vuelve a registrar tu datos");
                }
            }
        }
        return opcional;
    }

    public static void cancelarReserva(Asiento asientos[][]) {
        int numeroAsiento = 0;
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        while (!salir) {
            System.out.print("Ingresa el numero de asiento para cancelar: ");
            numeroAsiento = scanner.nextInt();
            if ((numeroAsiento == 0) || (numeroAsiento == 4) || (numeroAsiento == 17) || (numeroAsiento == 34) || (numeroAsiento == 61) || (numeroAsiento == 62)
                    || (numeroAsiento == 63) || (numeroAsiento == 64) || (numeroAsiento == 91) || (numeroAsiento == 92) || (numeroAsiento == 93)
                    || (numeroAsiento == 94) || (numeroAsiento == 124) || (numeroAsiento == 154) || (numeroAsiento == 167) || (numeroAsiento > 180)) {
                System.out.println("No se tiene reserva de este asiento");
            } else {
                salir = true;
            }
        }
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (asientos[i][j].isOcupado())) {
                    asientos[i][j].setOcupado(false);
                    for (int k = 0; k < reservas.length; k++) {
                        if (reservas[k] != null) {
                            if ((reservas[k].getNumeroAsiento() == numeroAsiento)) {
                                reservas[k] = null;
                                System.out.println("Reserva cancelada");
                            }
                        }
                    }
                } else if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (!asientos[i][j].isOcupado())) {
                    System.out.println("No se tiene reserva de este asiento");
                }
            }
        }

//        System.out.println("Numero asiento: " + numeroAsiento);
//        try {
//            for (int i = 0; i < reservas.length; i++) {
//                if (reservas[i] != null) {
//                    if ((reservas[i].getNumeroAsiento() == numeroAsiento)) {
//                        reservas[i] = null;
//                        System.out.println("Reserva cancelada");
//                    } else {
//                        System.out.println("Este asiento no se encuentra reservado");
//
//                    }
//                }
//
//            }
//        } catch (Exception e) {
//            System.out.println("Error " + e.getMessage());
//        }

    }

    public static void creacionObjetosAsiento() {
        int suma = 0;
        Asiento[][] asientosMetodo = new Asiento[filas.length][columnas.length];

        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                suma = suma + 1;
                asientosMetodo[i][j] = new Asiento(filas[i], columnas[j], false);
            }
        }
        asientosMetodo[2][0].setOcupado(true);
        asientosMetodo[2][1].setOcupado(true);
        asientosMetodo[2][2].setOcupado(true);
        asientosMetodo[2][3].setOcupado(true);
        asientosMetodo[3][0].setOcupado(true);
        asientosMetodo[3][1].setOcupado(true);
        asientosMetodo[3][2].setOcupado(true);
        asientosMetodo[3][3].setOcupado(true);
        asientosMetodo[0][3].setOcupado(true);
        asientosMetodo[0][16].setOcupado(true);
        asientosMetodo[1][3].setOcupado(true);
        asientosMetodo[4][3].setOcupado(true);
        asientosMetodo[5][3].setOcupado(true);
        asientosMetodo[5][16].setOcupado(true);

        asientos = asientosMetodo;
    }

    public static void impresionAsientos(Asiento asientos[][]) {
        for (int i = 0; i < filas.length; i++) {
            System.out.print(filas[i] + " ");
            for (int j = 0; j < columnas.length; j++) {
                if (asientos[i][j].isOcupado()) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 0 ");
                }

            }
            System.out.println(" ");
        }
    }

    public static void impresionNumeroAsientos(Asiento asientos[][]) {
        for (int i = 0; i < filas.length; i++) {
            System.out.print(filas[i] + " ");
            for (int j = 0; j < columnas.length; j++) {
                if (asientos[i][j].isOcupado()) {
                    System.out.print("  R  ");

                } else if (asientos[i][j].getIdAsiento() < 10) {
                    System.out.print(" " + "00" + asientos[i][j].getIdAsiento() + " ");

                } else if ((asientos[i][j].getIdAsiento() > 9) && (asientos[i][j].getIdAsiento() < 100)) {
                    System.out.print(" " + "0" + asientos[i][j].getIdAsiento() + " ");

                } else {
                    System.out.print(" " + asientos[i][j].getIdAsiento() + " ");
                }
            }
            System.out.println(" ");
        }
    }

    public static void impresionReservas(Reserva reservas[]) {
        for (int i = 0; i < reservas.length; i++) {
            if (!(reservas[i] == null)) {
                System.out.println("Reservas " + reservas[i]);
            } //else {
            //System.out.println("Reservas " + reservas[i]);
            //}
        }
    }

}
