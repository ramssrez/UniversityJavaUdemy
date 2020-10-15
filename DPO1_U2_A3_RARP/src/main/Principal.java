package main;

import clases.Personal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    private static Personal personas[];

    public static void main(String arg[]) {
        System.out.println("Bienvenidos al registro de personal");
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Registro de Personal");
            System.out.println("2. Cantidad de hombres mayores de 50 años");
            System.out.println("3. Cantidad de mujeres mayores de 50 años");
            System.out.println("4. Cantidad de hombres con alguna comorbilidad");
            System.out.println("5. Salir");

            try {

                System.out.print("Selecciona una de las opciones: ");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                       
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        System.out.println("Has seleccionado la opcion 1");
                        ingresoNumeroPersonal();
                        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        //System.out.println("Personas " + personas.length);
                        if (personas == null) {
                            System.out.println("No hay datos, ingresa datos del personal");
                        } else {
                            System.out.println("Este si tiene datos");
                            int numeroMayor = conteoHombres(personas);
                            System.out.println("Hombres mayores de 50 años: " + numeroMayor + " persona(s)");
                        }
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        if (personas == null) {
                            System.out.println("No hay datos, ingresa datos del personal");
                        } else {
                            System.out.println("Este si tiene datos");
                            int numeroMayor = conteoMujeres(personas);
                            System.out.println("Mujeres mayores de 50 años: " + numeroMayor + " persona(s)");
                        }
                        break;
                    case 4:
                        System.out.println("Haz seleccionado la opción 4");
                        if (personas == null) {
                            System.out.println("No hay datos, ingresa datos del personal");
                        } else {
                            System.out.println("Este si tiene datos");
                            int numeroMayor = conteoHombresEnfermos(personas);
                            System.out.println("Hombres con alguna enfermedad: " + numeroMayor + " persona(s)");
                        }
                        break;
                    case 5:
                        salir = true;
                        System.out.println("Gracias por tu visita. Adiós!!!!!");
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número" + e);
                sn.next();
            }
        }
    }

    public static void ingresoNumeroPersonal() {
        System.out.println("El número de personal a registrar debe ser mayor a 15");
        System.out.print("Ingresa el número de personal para dar de alta: ");
        Scanner sn = new Scanner(System.in);
        int numeroPersonas;
        numeroPersonas = sn.nextInt();
        if (numeroPersonas < 2) {
            System.out.println("El número de personas debe ser mayor, vuelve a intentar");
        } else {
            System.out.println("Numero Correcto1");
            Personal personales[] = generacionArregloPersonal(numeroPersonas);
            for (int i = 0; i < personales.length; i++) {
                System.out.println("Persona " + (i + 1) + ": " + personales[i]);
            }
        }
    }

    public static Personal[] generacionArregloPersonal(int numeroPersonas) {
        Scanner sn = new Scanner(System.in);
        Personal personales[] = new Personal[numeroPersonas];
        for (int i = 0; i < personales.length; i++) {
            System.out.println("Ingreso del personal numero " + (i + 1));
            System.out.println("Ingresa la edad: ");
            int edad = sn.nextInt();
            System.out.println("Ingresa el sexo, M para masculino, F para femenino");
            char sexo = sn.next().charAt(0);
            System.out.println("¿Tiene alguna enfemedad? true para SI, false para NO");
            boolean enfermedad = sn.nextBoolean();
            personales[i] = new Personal(sexo, edad, enfermedad);
            System.out.println("**********************************************************************************************************************************************");
            personas = personales;
        }
        return personales;
    }

    public static int conteoHombres(Personal personas[]) {
        int j = 0;
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + personas[i]);
            if ((personas[i].getEdad() >= 50) && (personas[i].getSexo() == 'M')) {
                j = j + 1;
            }
        }
        return j;
    }

    public static int conteoMujeres(Personal personas[]) {
        int j = 0;
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + personas[i]);
            if ((personas[i].getEdad() >= 50) && (personas[i].getSexo() == 'F')) {
                j = j + 1;
            }
        }
        return j;
    }

    public static int conteoHombresEnfermos(Personal personas[]) {
        int j = 0;
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Persona " + (i + 1) + ": " + personas[i]);
            if ((personas[i].isTieneComorbilidad()) && personas[i].getSexo() == 'M') {
                j = j + 1;
            }
        }
        return j;
    }

}
