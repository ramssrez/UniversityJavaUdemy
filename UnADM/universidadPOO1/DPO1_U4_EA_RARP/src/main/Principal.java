package main;

import clases.Asiento;
import clases.Reserva;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    //Declaración de las varables globlales que son necesarias para poder intanciar el tamaño de las filas y columnas del avión
    public static Asiento asientos[][] = null;
    //Estas variables le dan el tamaño de las matriz de nxm con los parametros establecidos
    public static char filas[] = {'A', 'B', 'C', 'D', 'E', 'F'};
    public static int columnas[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    //Declaración del arreglo de la reserva para que se puedan guardar el nombre y asiento de los diferetes clientes
    public static Reserva reservas[] = new Reserva[360];

    //Declaración de la función principal
    public static void main(String[] args) {
        //LLamado al método que se encarga de la creación de los objetos de tipo asiento
        creacionObjetosAsiento();
        //Declaración de varaibles para hacer uso del menú
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
        //Uso de la clase Scanner para recibir valores de la consola
        Scanner scan = new Scanner(System.in);
        //Varaible que incrementa el número de reservas1 realizadas
        int opcional = 0;
        //Impresión de una pequeña introducción para hacer uso del sistema
        System.out.println("\nBienvenido al centro de reservas, a continuación se presentará un menú para que escoga la opción que desee");
        System.out.println("Nuestro avión tiene un total de 166 asientos disponibles, los cuales los puedes consulta el la opción 1, ");
        System.out.println("además de que esta dividido en 6 filas (A,B,C,D,E,F) y puede escoger la opción que mas le convenga.");
        System.out.println("\nLa primera opción es parar reservar una asiento en el avión, nuestro avión cuenta con 12 asientos de primera clase");
        System.out.println("que se encuentran al inicio del avión y 154 asientos de segunda clase.");
        System.out.println("\nLa segunda opción es para cancelar la reservación del asiento ingresando el número de asiento que ha seleccionado.");
        System.out.println("\nLa tercera opción es para consultar su reservación, ingresando el número que ha seleccionado.");
        System.out.println("\nPor último, la cuarta opción es para salir de nuestro sistema de reservas");
        //Comienzo del ciclo repetitivo while pa el menú
        while (!salir) {
            //Impresión de las opciones del menú
            System.out.println("\n1.- Reservar");
            System.out.println("2.- Cancelar Reserva");
            System.out.println("3.- Consular");
            System.out.println("4.- Salir");
            //Uso de la sentecia try/catch para que solo ingrese un número
            try {
                System.out.print("Selecciona una de la opciones: ");
                opcion = scan.nextInt();
                //Uso de la sentencia switch para las opciones del menú
                switch (opcion) {
                    //Caso 1 en donde se realiza la reserva de un asiento
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Asignación de la variable local para poder crear los objetos de tipo Reserva
                        opcional = crearReserva(asientos, opcional);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 donde se realiza la cancelación de la reserva de nuestro programa
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Llamado del métodoq que se encarga de realizar la cancelación de la reserva, con parámetros de entrada como el arreglo bidimencional de tipo asiento
                        cancelarReserva(asientos);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3. donde se realiza la consulta de la reserva realizada en la opción uno, un función del número de asiento
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //Llamado del método que realiza la consulta de aseintos de nuestro sistema de reservas
                        consultarReserva(asientos);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 4 donde da por terminado el programa y sale del menú, además de imprimir los lugares del avión ocupado y las reservas solicitadas
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("\nReservas actualizadas");
                        //Llamado del método que realiza la impresión de reservas realizadas
                        impresionReservas(reservas);
                        System.out.println("\nLugares ocupados en el avión");
                        //Llamado del método que realiza la impresión del número de asientos
                        impresionNumeroAsientos(asientos);
                        System.out.println("\n\nGracias por tu visita. Adiós!!!!!");
                        //Asignación para que salga del menú y de por finalizada la ejecución del programa
                        salir = true;
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso default que manda un error en caso de que no se cumpla con las cuatra primeras opciones
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

    //Método que se encarga de realizar la reserva de un asiento, donde se tiene que ingresar la matriz de asientos y un entero que se encargará de ser el contador del arrelglo de reservas
    public static int crearReserva(Asiento asientos[][], int opcional) {
        //Varaible de Scanner para poder recibir lo que ingrese el usuario
        Scanner scanner = new Scanner(System.in);
        //Impresión de una pequeña descripción del método
        System.out.println("Bienvenidos a la sección de reserva, a continuación se presentará la disponibilidad de asientos en función de las filas disponibles, los asientos que están ");
        System.out.println("marcados con R son asientos ya reservados y los asientos que puedes observar su número son los disponibles.\n");
        //Llamado del método que imprime los asientos del avión
        impresionNumeroAsientos(asientos);
        System.out.println("\nPara poder realizar tu registro es necesario que registres tu nombre, apellido y el número de asiento");
        int numeroAsiento = 0;
        boolean salir = false;
        //Ingreso de los datos para poder realizar la reservación como el nombre, apellido y el número de asietno
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa tu apellido: ");
        String apellido = scanner.nextLine();
        //Ciclo while que se encarga de verificar el número ingresado por el ususario y en caso de que no sea adecuado mandar un mensaje
        while (!salir) {
            System.out.print("Ingresa el número de asiento: ");
            numeroAsiento = scanner.nextInt();
            //Validación para el caso de que el usuario haya ingresado un número de asiento valido y que exista, en caso contrario mandar un mensaje
            if ((numeroAsiento == 0) || (numeroAsiento == 4) || (numeroAsiento == 17) || (numeroAsiento == 34) || (numeroAsiento == 61) || (numeroAsiento == 62)
                    || (numeroAsiento == 63) || (numeroAsiento == 64) || (numeroAsiento == 91) || (numeroAsiento == 92) || (numeroAsiento == 93)
                    || (numeroAsiento == 94) || (numeroAsiento == 124) || (numeroAsiento == 154) || (numeroAsiento == 167) || (numeroAsiento > 180)) {
                System.out.println("No existe este asiento, vuelve a ingresar el número de asiento");
            } else {
                salir = true;
            }
        }
        //Ciclo que recorre la matriz de asientos para poder realzar la reserva.
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                //Validación para poder reservar en función del núemro de asiento y si se encuentra ocupado
                if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (!asientos[i][j].isOcupado())) {
                    //Cambio del atributo ocupado para determinar que se encuentra ocupado
                    asientos[i][j].setOcupado(true);
                    //Creación del objeto reserva con el nombre, apellido y número de asiento
                    Reserva reserva = new Reserva(nombre, apellido, numeroAsiento);
                    //Uso del arreglo reserva para resguardar la reserva en función del entero que ha ingresado en el método
                    reservas[opcional] = reserva;
                    //Aumento del núemero entero que ha ingresado
                    opcional = opcional + 1;
                    //Mensaje de registro exitoso en nuestra resercva, mostrando el núemero de asiento y el lugar en donde se encuentra
                    System.out.println("\nRegistro Exitoso");
                    System.out.println("Tu número de asiento es: " + asientos[i][j].getIdAsiento());
                    System.out.println("Se encuentra en la fila: " + asientos[i][j].getFila() + asientos[i][j].getNumeroAsiento());
                    //Validación para el caso de que el número asignado se encuentre ocupado y mandar un mensaje al respecto
                } else if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (asientos[i][j].isOcupado())) {
                    System.out.println("No se puede asignar este asiento, ya se encuetra reservado");
                    System.out.println("Vuelve a escoger un asiento");
                }
            }
        }
        //Regreso del entero que ha aumentado en líneas de codigo anteriores.
        return opcional;
    }

    //Método que se encarga de cancelar la reserva del asiento seleccionado
    public static void cancelarReserva(Asiento asientos[][]) {
        int numeroAsiento = 0;
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        //Impresión de un pequeña descirpción
        System.out.println("Bienvenidos a la sección de cancelación de reserva, vamos a necesitar el número de asiento para poder realizar la cancelación del asiento");
        //Ciclo while que se encarga de verificar el número ingresado por el ususario y en caso de que no sea adecuado mandar un mensaje
        while (!salir) {
            System.out.print("Ingresa el número de asiento por cancelar: ");
            numeroAsiento = scanner.nextInt();
            //Validación para el caso de que el usuario haya ingresado un número de asiento valido y que exista, en caso contrario mandar un mensaje
            if ((numeroAsiento == 0) || (numeroAsiento == 4) || (numeroAsiento == 17) || (numeroAsiento == 34) || (numeroAsiento == 61) || (numeroAsiento == 62)
                    || (numeroAsiento == 63) || (numeroAsiento == 64) || (numeroAsiento == 91) || (numeroAsiento == 92) || (numeroAsiento == 93)
                    || (numeroAsiento == 94) || (numeroAsiento == 124) || (numeroAsiento == 154) || (numeroAsiento == 167) || (numeroAsiento > 180)) {
                System.out.println("No existe este asiento, vuelve a ingresar el número de asiento");
            } else {
                salir = true;
            }
        }

        //Ciclo que recorre la matriz de asientos para poder observar si el asiento ingresado por el usuario se encuentra ocupado.
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                //Validación para poder realizar la cancelación y verifica si se encuentra ocupado
                if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (asientos[i][j].isOcupado())) {
                    asientos[i][j].setOcupado(false);
                    //Recorrido del arreglo para poder eliminar el nombre de la reserva
                    for (int k = 0; k < reservas.length; k++) {
                        //VAlidación para el caso de que nuestro arreglo no este vacío
                        if (reservas[k] != null) {
                            //VAlidación para poder realizar la cancelación del asiento
                            if ((reservas[k].getNumeroAsiento() == numeroAsiento)) {
                                //Borrado de lo que contiene la reserva así como un mensaje de cancelación exitosa
                                reservas[k] = null;
                                System.out.println("Reserva cancelada");
                            }
                        }
                    }
                    //Varificación para el caso de que el asiento no se encuentra reseirvado
                } else if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (!asientos[i][j].isOcupado())) {
                    //Mensaje al ususario para mencionar que no se encuentra reservado el número de asiento que ha seleccionado
                    System.out.println("Este asiento no se encuentra reservado");
                }
            }
        }
    }

    //Método que se encarga de revisar la reserva del asiento
    public static void consultarReserva(Asiento sientos[][]) {
        int numeroAsiento = 0;
        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenidos a la sección de consulta de reserva, vamos a necesitar el número de asiento para poder realizar la consulta del asiento");
        //Ciclo while que se encarga de verificar el número ingresado por el ususario y en caso de que no sea adecuado mandar un mensaje
        while (!salir) {
            System.out.print("Ingresa el número de asiento para consultar: ");
            numeroAsiento = scanner.nextInt();
            //Validación para el caso de que el usuario haya ingresado un número de asiento valido y que exista, en caso contrario mandar un mensaje
            if ((numeroAsiento == 0) || (numeroAsiento == 4) || (numeroAsiento == 17) || (numeroAsiento == 34) || (numeroAsiento == 61) || (numeroAsiento == 62)
                    || (numeroAsiento == 63) || (numeroAsiento == 64) || (numeroAsiento == 91) || (numeroAsiento == 92) || (numeroAsiento == 93)
                    || (numeroAsiento == 94) || (numeroAsiento == 124) || (numeroAsiento == 154) || (numeroAsiento == 167) || (numeroAsiento > 180)) {
                System.out.println("No existe este asiento, vuelve a ingresar el número de asiento");
            } else {
                //Ciclo que recorre la matriz de asientos para poder observar si el asiento ingresado por el usuario se encuentra ocupado.
                for (int i = 0; i < filas.length; i++) {
                    for (int j = 0; j < columnas.length; j++) {
                        //Validación para el caso de que el asiento este ocupado
                        if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (asientos[i][j].isOcupado())) {
                            for (int k = 0; k < reservas.length; k++) {
                                if (reservas[k] != null) {
                                    //En caso afirmativo poder observar el nombre de la persona que ha reservado el asietno
                                    if ((reservas[k].getNumeroAsiento() == numeroAsiento)) {
                                        System.out.println("Este asiento esta reservado por " + reservas[k].getNombre() + " " + reservas[k].getApellido());
                                    }
                                }
                            }
                            //En caso contrario imprimir al usuario que el asiento no se encuentra reservado y mandarle un mensaje al usuario
                        } else if ((asientos[i][j].getIdAsiento() == numeroAsiento) && (!asientos[i][j].isOcupado())) {
                            System.out.println("Este asiento no se encuentra reservado, esta disponible para reservar");
                        }
                    }
                }
                salir = true;
            }
        }

    }

    //Método que se encarga de realizar la creación de los objetos asientos 
    public static void creacionObjetosAsiento() {
        int suma = 0;
        //intancia de la matriz de asientos en donde se les asigna un tamaño de filas y columnas
        Asiento[][] asientosMetodo = new Asiento[filas.length][columnas.length];

        //Ciclo for que se encarga de recorrer la matriz de asientos, ademas de realizar su creación
        for (int i = 0; i < filas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                suma = suma + 1;
                asientosMetodo[i][j] = new Asiento(filas[i], columnas[j], false);
            }
        }
        //Reserva de objetos de tipo asiento, los cuales el ususario no podrá seleccionar
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

        //Asignación de la variable global con la del método para que se pueda utilizar en todo el programa
        asientos = asientosMetodo;
    }

    //Método que realiza la impresión de los asientos, con un formato en donde se imprime el número de aseinto para hacerlo mas visual para el ususario
    public static void impresionNumeroAsientos(Asiento asientos[][]) {
        //Recorrido del ciclo del arreglo de asientos
        for (int i = 0; i < filas.length; i++) {
            System.out.print(filas[i] + " ");
            for (int j = 0; j < columnas.length; j++) {
                //Validación para el caso de que el asiento se encuentre ocupado
                if (asientos[i][j].isOcupado()) {
                    System.out.print("  R  ");

                    //Validación para el caso de que el asiento su número sea menor a 10
                } else if (asientos[i][j].getIdAsiento() < 10) {
                    System.out.print(" " + "00" + asientos[i][j].getIdAsiento() + " ");

                    //Validación para el caso de que el asiento su número sea menor a 100 y mayor a 10
                } else if ((asientos[i][j].getIdAsiento() > 9) && (asientos[i][j].getIdAsiento() < 100)) {
                    System.out.print(" " + "0" + asientos[i][j].getIdAsiento() + " ");

                    //Impresión del numero de asiento cuando sea mayor a 100
                } else {
                    System.out.print(" " + asientos[i][j].getIdAsiento() + " ");
                }
            }
            System.out.println(" ");
        }
    }

    //M´todo que se encarga de imprimir las reservas realizadas
    public static void impresionReservas(Reserva reservas[]) {
        for (int i = 0; i < reservas.length; i++) {
            //Validación para el caso de que las reservas no exixtan solo se imprima las que continenen valores
            if (!(reservas[i] == null)) {
                System.out.println(reservas[i]);
            }
        }
    }

}
