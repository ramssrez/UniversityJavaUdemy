package main;

import clases.Municipio;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    //Declaración de variables globales para la solución de este ejercicio
    private static Municipio municipiosTotales[];

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
            System.out.println("1. Registrar el número de infectados, defunciones y casos recuperados de los municipios");
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
                    //Caso 1 en donde se ingresan los datos del los municipios
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
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3 en donde se obtiene el total de defunciones en la entidad
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método  que contiene una verificación en caso de que no se haya registrado datos en la opción 1
                        validacion(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 4 en donde se obtiene el total de  casos positivos en la entidad
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método  que contiene una verificación en caso de que no se haya registrado datos en la opción 1
                        validacion(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 5 en donde se obtiene el total de recuperados en la entidad
                    case 5:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método  que contiene una verificación en caso de que no se haya registrado datos en la opción 1
                        validacion(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 6 en donde se imprime los municipios que tienen un mayor y menor contagio
                    case 6:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método  que contiene una verificación en caso de que no se haya registrado datos en la opción 1
                        validacion(opcion);
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 7 en donde se sale del ciclo while
                    case 7:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Has seleccionado la opcion 7");
                        //Cambio de asignación de la variable salir para que salga del ciclo while
                        salir = true;
                        System.out.println("Gracias por tu visita. Adiós!!!!!");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso default en el caso de que no ingrese un valor entre 1 y 7
                    default:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("ERROR, el número no corresponde al rango de 1 a 7");
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
        //Creación del arreglo que contiene los nombres de los municipios
        String municipioString[] = {"Bacalar", "Benito Juárez", "Cozumel", "Felipe Carrillo Puerto",
            "Isla Mujeres", "José María Morelos", "Lázaro Cárdenas", "Othón P. Blanco", "Puerto Morelos",
            "Solidaridad", "Tulum"};
        //Crecaión del arreglo que contiene los valores de los municipios, para uso de pruebas
        int positivosList[] = {245, 5426, 365, 317, 194, 119, 267, 3084, 29, 1451, 229};
        int defuncionesList[] = {9, 1074, 67, 47, 15, 26, 20, 174, 12, 176, 17};
        int recuperadosList[] = {204, 4136, 271, 240, 141, 77, 200, 2251, 14, 1198, 188};
        //Creación del arreglo de objetos de tipo Municipio con el número de entidades
        Municipio municipios[] = new Municipio[municipioString.length];
        //Creación de un ciclo que se encaraga de llenar el arreglo de objetos de tipo Municipio para pruebas
        for (int i = 0; i < municipioString.length; i++) {
            Municipio municipioPrueba = new Municipio(municipioString[i], positivosList[i], defuncionesList[i], recuperadosList[i]);
            municipios[i] = municipioPrueba;
        }

        //Bloque Donde se efectua el llenado de datos de manera manual
//        for (int i = 0; i < municipioString.length; i++) {
//            System.out.print("Ingresa el número de infectados de " + municipioString[i] + ": ");
//            int positivos = scanner.nextInt();
//            System.out.print("Ingresa el número de defunciones de " + municipioString[i] + ": ");
//            int defunciones = scanner.nextInt();
//            System.out.print("Ingresa el número de recuperados de " + municipioString[i] + ": ");
//            int recuperados = scanner.nextInt();
//            Municipio municipio = new Municipio(municipioString[i], positivos, defunciones, recuperados);
//            municipios[i] = municipio;
//        }
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
            //Sentencia que manda a llamar un método que calcula el número de defunciones en la entidad
            System.out.println("El número de defunciones en Quintana Roo son: " + defuncionesTotal(municipiosTotales) + " personas");
        } else if (casoMenu == 4) {
            //Sentencia que manda a llamar un método que calcula el número de casos positivos en la entidad
            System.out.println("El número de casos positivos en Quintana Roo son: " + positivosTotal(municipiosTotales) + " personas");
        } else if (casoMenu == 5) {
            //Sentencia que manda a llamar un método que calcula el número de recuperados en la entidad
            System.out.println("El número de recuperados en Quintana Roo son: " + recuperadosTotal(municipiosTotales) + " personas");
        } else if (casoMenu == 6) {
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
    }

    public static int defuncionesTotal(Municipio municipios[]) {
        System.out.println("Has seleccionado la opcion 3");
        //Declaración de la variable que hace la suma de las defunciones en el estado
        int defuncionesTotal = 0;
        for (Municipio municipio : municipios) {
            defuncionesTotal += municipio.getNumeroDefunciones();
        }
        return defuncionesTotal;
    }

    public static int positivosTotal(Municipio municipios[]) {
        System.out.println("Has seleccionado la opcion 4");
        //Declaración de la variable que hace la suma de los infectados
        int positivosTotal = 0;
        for (Municipio municipio : municipios) {
            positivosTotal += municipio.getNumeroPositivos();
        }
        return positivosTotal;
    }

    public static int recuperadosTotal(Municipio municipios[]) {
        System.out.println("Has seleccionado la opcion 5");
        //Declaración de la variable que hace la suma de los recuperados
        int recuperadosTotal = 0;
        for (Municipio municipio : municipios) {
            recuperadosTotal += municipio.getNumeroRecuperados();
        }
        return recuperadosTotal;
    }

    //Método que determina el municipio con mayor y menor número de contagios
    public static void mayorContagio(Municipio municipios[]) {
        System.out.println("Has seleccionado la opcion 6");
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
        System.out.println("El municipio con menor número de contagios es: " + menorContagios);
        System.out.println("El municipio con mayor número de contagios es: " + mayorContagios);

    }
}
