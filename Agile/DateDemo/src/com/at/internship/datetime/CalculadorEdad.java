package com.at.internship.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalculadorEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Captura tu fecha de nacimiento en formato DD/MM/AAAA > ");
        String fechaNacimiento = scanner.nextLine();
        Calendar hoy = Calendar.getInstance();
        Calendar nacimiento = Calendar.getInstance();
        Calendar diferencia = Calendar.getInstance();

        // Convertir hoy en fecha sin hora
        hoy.set(Calendar.HOUR, 0);
        hoy.set(Calendar.MINUTE, 0);
        hoy.set(Calendar.SECOND, 0);
        hoy.set(Calendar.MILLISECOND, 0);

        try {
            nacimiento.setTime(df.parse(fechaNacimiento));
            diferencia.setTimeInMillis(hoy.getTimeInMillis() - nacimiento.getTimeInMillis());
            int anios = diferencia.get(Calendar.YEAR) - 1970; // El primer año es 1970
            int meses = diferencia.get(Calendar.MONTH);

            System.out.printf("Tu edad es: %s años y %s meses", anios, meses);
        } catch (ParseException e) {
            System.err.println("La fecha introducida no es válida");
        }
    }
}
