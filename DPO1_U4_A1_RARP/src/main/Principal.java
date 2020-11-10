package main;

import clases.Municipio;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    //Declaración de variables globales para la solución de este ejercicio
    private static final String BACALAR = "Bacalar";
    private static final String BENITO_JUAREZ = "Benito Juárez";
    private static final String COZUMEL = "Cozumel";
    private static final String FELIPE_CARRILLO_PUERTO = "Felipe Carrillo Puerto";
    private static final String ISLAMUJERES = "Isla Mujeres";
    private static final String JOSE_MARIA_MORELOS = "José María Morelos";
    private static final String LAZARO_CARDENAZ = "Lázaro Cárdenas";
    private static final String OTHON_BLANCO = "Othón P. Blanco";
    private static final String PUERTO_MORELOS = "Pueto Morelos";
    private static final String SOLARIDAD = "Solaridad";
    private static final String TULUM = "Tulum";
    private static final String CANCUN = "Cancún";

    private static final String PLAYACARMEN = "Playa del Carmen";
    private static Municipio municipiosTotales[];
    private static int total;

    public static void main(String[] args) {
        System.out.println("Bienvenidos al registro de contagiados del estado de Quintana Roo");
        //Declaración de la clase Scanner para poder registrar los datos que ingrese el ususario
        Scanner sn = new Scanner(System.in);
        //Declaración de la variable salir, para salir del ciclo while
        boolean salir = false;
        //Declaración de la variable opción donde se guarada la opción que eligío el usuario
        int opcion; //Guardaremos la opcion del usuario
        //Inicio del ciclo while con la sentencia de salir cuando sea verdadera
        while (!salir) {
            //Impresión del menú de los diferentes opciones que contiene, los cuales el usuario puede observar 
            System.out.println("1. Registrar los infectados en los municipios, defunciones y casos recuperados");
            System.out.println("2. Indicar el semáforo que corresponde la entidad");
            System.out.println("3. Mostrar la cantidad total de defunciones");
            System.out.println("4. Mostrar la cantidad total de positivos");
            System.out.println("3. Mostrar la media de contagios a nivel estatal");
            System.out.println("5. Mostrar la cantidad total de recuperados");
            System.out.println("6. Indicar el municipio que más contagios tuvo y el que menos contagios");
            System.out.println("7. Salir");
            //Uso de la sentencia try/catch para el caso de que el ususario ingrese letras al menú
            try {
                //Impresión para que el ususario registre alguna de las opciones que se le presenta
                System.out.print("Selecciona una de las opciones: ");
                //Uso del objeto sn de la clase scanner para registrar la opción del usuario
                opcion = sn.nextInt();

                //Uso de la sentencia Switch para los diferentes casos en los que el usuario haya elegido
                switch (opcion) {
                    //Caso 1 en donde se ingresallos datos del los municipios
                    case 1:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que retorna un array de objeto de tipo municipio, donde se cargan los datos de los infectadis
                        municipiosTotales = registrarInfectados(); //Asignación de la variable global a lo que regresa el método
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2. Donde se imprime el semaforo en donde se ubica la entidad en este momento.
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método  que contiene una verificación en caso de que no se haya registrado datos en la opción 1
                        validacion(opcion);
                        System.out.println(Arrays.toString(municipiosTotales) + "Municipios totales");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3 en donde se obtiene el promedio de infecciones en la entidad.
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método  que contiene una verificación en caso de que no se haya registrado datos en la opción 1
                        validacion(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 4 en donde se los municipios que tiene un mayor contagio y los que no
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método  que contiene una verificación en caso de que no se haya registrado datos en la opción 1
                        validacion(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 5 en donde se sale del ciclo while
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

    //Método que registra el número de infectados por municipio
    public static Municipio[] registrarInfectados() {
        //Registro del número de infectados de los diferentes municipios
        System.out.println("Has seleccionado la opcion 1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Registra los datos de los municipios");
        System.out.print("Ingresa en número de casos para " + CANCUN + ": ");
        int infectadosCancun = scanner.nextInt();
        System.out.print("Ingresa el número de casos para " + PLAYACARMEN + ": ");
        int infectadosCarmen = scanner.nextInt();
        System.out.print("Ingres en número de casos para " + COZUMEL + ": ");
        int infectadosCozumel = scanner.nextInt();
        System.out.print("Ingresa el número de casos para " + ISLAMUJERES + ": ");
        int infectadosIsla = scanner.nextInt();

        //Creación de los objetos de tipo Municipio haciendo uso de las variables globales que se declararon al principio y los que ingreso el usuario
        Municipio municipioCancun = new Municipio(CANCUN, infectadosCancun);
        Municipio municipioCarmen = new Municipio(PLAYACARMEN, infectadosCarmen);
        Municipio municipioCozumel = new Municipio(COZUMEL, infectadosCozumel);
        Municipio municipioIsla = new Municipio(ISLAMUJERES, infectadosIsla);
        //Creación del array de tipo Municipio que contiene los objetos que se crearon previamente.
        Municipio municipios[] = {municipioCancun, municipioCarmen, municipioCozumel, municipioIsla};
        //Retorno del array que contiene los objetos
        return municipios;
    }

    //Método que realiza la validación en caso de que la variable global no contenga valores o sea nula
    public static void validacion(int casoMenu) {
        //Uso de la sentencia if, donde se realiza la validación, en función de la opción que haya elegido el usuario
        if (municipiosTotales == null) {
            //Sentencia en caso de que no haya datos en el array global
            System.out.println("No ha registrado datos, vuelve a la opción 1");
        } else if (casoMenu == 2) {
            //Sentencia que manda a llamar un método que identifica que en que semáforo se encuentra la entidad
            semaforo(municipiosTotales);
        } else if (casoMenu == 3) {
            //Sentencia que manda a llamar un método que calcula la media de infecciones en la entidad
            mediaContagios(total, municipiosTotales);
        } else if (casoMenu == 4) {
            //Sentencia que determina el municipio que tiene mayor contagios y el que no
            mayorContagio(municipiosTotales);
        }
    }

    //Método que identifica en que semaforo se encuentra la entidad, en base a los datos que ingresaron en la opción 1
    public static void semaforo(Municipio municipios[]) {
        System.out.println("Has seleccionado la opcion 2");
        //Declaración de la variable que hace la suma de los infectados
        int j = 0;
        //Sentencia for que realiza la suma de los infectados
        for (int i = 0; i < municipios.length; i++) {
            //Uso de la variable j que realiza la suma de los infectados
            j = j + municipios[i].getNumeroPositivos();
        }

        //Sentencia similar a la que se encuentra dentro del ciclo for, pero tomando el total de infecciones en la entidad
        System.out.println("El total de infecciónes en Quinana Roo son: " + j);
        if ((j >= 0) && (j <= 25)) {
            System.out.println("La entidad tiene semáforo verde");
        }
        if ((j > 25) && (j <= 150)) {
            System.out.println("La entidad tiene semáforo Amarillo");
        }
        if ((j > 150) && (j <= 275)) {
            System.out.println("La entidad tiene semáforo Naranja");
        }
        if ((j > 275)) {
            System.out.println("La entidad tiene semáforo Rojo");
        }
        //Asignación del total en la variable global 
        total = j;
    }

    //Método que calcula la media de los contagiados en función del total y array que estan declarados globalmente
    public static void mediaContagios(int totalInfecciones, Municipio municipios[]) {
        System.out.println("Has seleccionado la opcion 3");
        //Declaración de las varaibles locales
        float media;
        //Parseo de las varibales que ingresaros para que no se presente un error logico al momento de compular
        float totalFloat = (float) totalInfecciones;
        float sizeFloat = (float) municipios.length;
        //Realización del calculo de la media
        media = totalFloat / sizeFloat;
        //Impresión de la media para que el usuario pueda observar el promedio
        System.out.println("El promedio de infectados son: " + media + " infectados/municipio");
    }

    //Método que determina el municipio con mayor y menor número de contagios
    public static void mayorContagio(Municipio municipios[]) {
        System.out.println("Has seleccionado la opcion 4");
        //Declaración de las variables auxiliares
        int mayor = 0;
        //Declaración de la variable menor, la cual se le tiene que asignar un valor que se encuentre en el array
        int menor = municipios[0].getNumeroPositivos();
        String mayorContagios = "";
        //Al igual que la varaible menor, se le tiene que asignar el valor que se encuentre en el array
        String menorContagios = municipios[0].getNombreMunicipio();
        //Ciclo for que recorre los objetos para poder determinar el municipio de mayor y menor contagios, haciendo uso de las variables auxiliares
        for (int i = 0; i < municipios.length; i++) {
            if (municipios[i].getNumeroPositivos() > mayor) {
                mayor = municipios[i].getNumeroPositivos();
                mayorContagios = municipios[i].getNombreMunicipio();
            }
            if (municipios[i].getNumeroPositivos() < menor) {
                menor = municipios[i].getNumeroPositivos();
                menorContagios = municipios[i].getNombreMunicipio();
            }
        }

        //Impresión de los municipios que tiene un mayor y menor numero de contagios.
        System.out.println("El municipio con menor contagios es: " + menorContagios);
        System.out.println("El municipio con mayor contagios es: " + mayorContagios);

    }
}
