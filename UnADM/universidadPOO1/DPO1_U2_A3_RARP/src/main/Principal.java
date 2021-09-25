package main;

import clases.Personal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    //Declaración del arreglo global de los objetos de tipo Personal
    private static Personal personas[];

    public static void main(String arg[]) {
        System.out.println("Bienvenidos al registro de personal");
        //Declaración de la clase Scanner para poder registrar los datos que ingrese el ususario
        Scanner sn = new Scanner(System.in);
        //Declaración de la variable salir para salir del ciclo while
        boolean salir = false;
        //Declaración de la variable opción donde se guarada la opción que eligío el usuario
        int opcion; //Guardaremos la opcion del usuario
        //Inicio del ciclo while con la sentencia de salid cuando sea verdadera
        while (!salir) {
            //Impresión del menú de los diferentes opciones que contieney los cuales el usuario puede observar 
            System.out.println("1. Registro de Personal");
            System.out.println("2. Cantidad de hombres mayores de 50 años");
            System.out.println("3. Cantidad de mujeres mayores de 50 años");
            System.out.println("4. Cantidad de hombres con alguna comorbilidad");
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
                        ingresoNumeroPersonal();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 2 en donde se obtiene el número de hombres mayores a 50 años.
                    case 2:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que contiene una varificación de la declaración global en caso de que no tenga valores asignados, dependiente del caso 1
                        opcionDos();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 3 en donde se obtiene el número de mujeres mayores a 50 años.
                    case 3:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que contiene una varificación de la declaración global en caso de que no tenga valores asignados, dependiente del caso 1
                        opcionTres();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    //Caso 4 en donde se obtiene el número de hombres que tienen alguna comorbilidad
                    case 4:
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        //LLamado al método que contiene una varificación de la declaración global en caso de que no tenga valores asignados, dependiente del caso 1
                        opcionCuatro();
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
                        System.out.println("ERROR, el número no corresponde alrango de 1 a 5");
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                }
            //Continuación de la sentencia try/catch en donde mandamos un mesaje de que se debe ingresar números al menú.
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    //Método en el cual se ingresa las personas que se van a registrar con un minímo de 15, no regresa un valor ni recibe un valor
    public static void ingresoNumeroPersonal() {
        //Impresión de los detalles generales de la opción que seleccionaron
        System.out.println("Has seleccionado la opcion 1");
        System.out.println("El número de personal a registrar debe ser mayor a 15");
        System.out.print("Ingresa el número de personal para dar de alta: ");
        //DEcalración del objetos Scanner para obtener el número de personas que se ingresarán 
        Scanner sn = new Scanner(System.in);
        //Delcaración del número de personas
        int numeroPersonas;
        //Asignación de número de personas con lo que ingrese el ususario.
        numeroPersonas = sn.nextInt();
        //Validación del número de personas ingresada con un minímo de 15, en caso de que no se cumpla se regresa el menú principal
        if (numeroPersonas < 15) {
            System.out.println("El número de personas debe ser mayor, vuelve a intentar");
        } else {
            //Declaración de la lista de objetos de tipo Personal, en base al número que declaro el usuario
            //Además de mandar a llamar el método que los instancia, donde recibe el valor de personas a generar
            Personal personales[] = generacionArregloPersonal(numeroPersonas);
            //Despues de utilizar el método se imprime la lista de objetos de tipo Personal que se asignaron
            System.out.println("El personal agregado es el siguiente");
            //Uso del ciclo for para imprimir los objetos de tipo Personal con sus respectivos parametros
            for (int i = 0; i < personales.length; i++) {//Uso de .length que contiene las listas en donde se observa el tamaño del array
                System.out.println("Personal " + (i + 1) + ": " + personales[i]);
            }
        }
    }

    //Método que se encarga de la generación del array de tipo Personal, en donde regresa un array de tipo Personal y necesita datos de entrada un entero 
    public static Personal[] generacionArregloPersonal(int numeroPersonas) {
        Scanner sn = new Scanner(System.in);
        //Declaración del array en función del número de personas que ingreso al ususario
        Personal personales[] = new Personal[numeroPersonas];
        //Ciclo for para generar los diferentes objetos de tipo Personal
        for (int i = 0; i < personales.length; i++) {
            //Declaración de edad, sexo y enfermedad con ayuda de la clase Scanner
            System.out.println("Ingreso del personal numero " + (i + 1));
            System.out.println("Ingresa la edad: ");
            int edad = sn.nextInt();
            System.out.println("Ingresa el sexo, M para masculino, F para femenino");
            char sexo = sn.next().charAt(0);
            //Error en la funcionalidad de la calse Scanner al no tomar el salto de línea para los enteros, por lo que se utilizo la siguietne línea
            sn.nextLine();
            System.out.println("¿Tiene alguna enfemedad? SI/NO");
            String enfermedad;
            enfermedad = sn.nextLine();
            //Creación de los objetos de tipo persona con la ayuda de su constructor ya definido
            personales[i] = new Personal(sexo, edad, enfermedad);
            System.out.println("**********************************************************************************************************************************************");
            //Asignación del array global con la que se acaba de generar
            personas = personales;
        }
        //Regreso del array de tipo Personal que se necesita en el método ingresoNumeroPersonal() {
        return personales;
    }

    //Método en donde se verifica si el array global tiene datos para la opción dos
    public static void opcionDos() {
        System.out.println("Has seleccionado la opcion 2");
        //Utilización de la sentencia if/else para validar el array global
        if (personas == null) {
            System.out.println("No hay datos, ingresa datos del personal");
        } else {
            //En caso de contar con valores en el array global se realiza lo siguiente.
            //Asignación de un entero con lo que se retorne del método y es necesario el uso del array global
            int numeroMayor = conteoHombres(personas);
            //Impresión de pantalla del dato que obtuvimos del método anterior
            System.out.println("Hombres mayores de 50 años: " + numeroMayor + " persona(s)");
        }
    }

    //Método que realiza el contero de número de personas que tiene una edad mayor de 50 años, en función del array global para hombres
    public static int conteoHombres(Personal personas[]) {
        //Declaración del contador en base a ciertos especificaciones
        int j = 0;
        System.out.println("Personal registrado");
        //Impresión de personal registrado, asi como el conteo de personas varones mayores a 50
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + personas[i]);
            //Condición que busca cuantas personas hombres son mayores a 50, con los métodos del objetos Personal
            if ((personas[i].getEdad() >= 50) && (personas[i].getSexo() == 'M')) {
                //En caso de cumplirse se realiza la suma de personas que cumplen con la sentencia
                j = j + 1;
            }
        }
        return j; //Retorn del número de pesonas hombres mayores de 50 años
    }
 
    //Método en donde se verifica si el array global tiene datos para la opción tres
    public static void opcionTres() {
        System.out.println("Has seleccionado la opcion 3");
        if (personas == null) {
            System.out.println("No hay datos, ingresa datos del personal");
        } else {
            int numeroMayor = conteoMujeres(personas);
            System.out.println("Mujeres mayores de 50 años: " + numeroMayor + " persona(s)");
        }
    }

    //Método que realiza el contero de número de personas que tiene una edad mayor de 50 años, en función del array global para mujeres, similar al conteoHombre()
    public static int conteoMujeres(Personal personas[]) {
        int j = 0;
        System.out.println("Personal registrado");
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + personas[i]);
            //Condición que busca cuantas personas mujeres son mayores a 50, con los métodos del objetos Personal
            if ((personas[i].getEdad() >= 50) && (personas[i].getSexo() == 'F')) {
                j = j + 1;
            }
        }
        return j;
    }

    //Método en donde se verifica si el array global tiene datos para la opción cuatro
    public static void opcionCuatro() {
        System.out.println("Has seleccionado la opcion 4");
        if (personas == null) {
            System.out.println("No hay datos, ingresa datos del personal");
        } else {
            int numeroMayor = conteoHombresEnfermos(personas);
            System.out.println("Hombres con alguna comorbilidad: " + numeroMayor + " persona(s)");
        }
    }

    //Método que realiza el contero de número de personas hombres que tiene una enfermedad
    public static int conteoHombresEnfermos(Personal personas[]) {
        int j = 0;
        System.out.println("Personal registrado");
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + personas[i]);
            //Condición que busca cuantas personas hombres tienen enfermedad, con los métodos del objetos Personal
            if ((personas[i].isTieneComorbilidad()) && personas[i].getSexo() == 'M') {
                j = j + 1;
            }
        }
        return j;
    }

}
