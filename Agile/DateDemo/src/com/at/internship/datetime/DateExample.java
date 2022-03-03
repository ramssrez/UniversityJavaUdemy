package com.at.internship.datetime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class DateExample {
    public static void main(String[] args) {
        // Constructor
        Date date1 = new Date();
        System.out.println("date1: " + date1);
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println("date2: " + date2);
        // Copiar fechas
        Date date3 = (Date) date1.clone();
        System.out.println("date3: " + date3);
        Date date4 = new Date(date1.getTime());
        System.out.println("date4: " + date4);
        // Modificar fechas
        date4.setTime(date2.getTime());
        System.out.println("date4: " + date4);
        // Comparar fechas
        System.out.println("date1 es igual a date2? " + date1.equals(date2));
        System.out.println("date1 es igual a date3? " + date1.equals(date3));
        System.out.println("date2 es igual a date4? " + date2.equals(date2));
        System.out.println("Resultado de comparar date1 y date2: " + date1.compareTo(date2));
        System.out.println("date1 está antes que date2? " +  date1.before(date2));
        System.out.println("date1 está después de date2? " + date1.after(date2));
        // No usar
        date1.getDate();
        date1.getDay();
        date1.getMonth();
        date1.getYear();
        // ... Y otros métodos o funciones obsoletos

        // Siempre que sea factible usar Instant en lugar de Date
        Instant instant1 = date1.toInstant();

        // Formato de fecha
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        // Para más opciones de formato, ver: https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
        String fechaConFormato = df.format(date1);
        System.out.println("Fecha con formato: " + fechaConFormato);
        try {
            Date date5 = df.parse("28/02/2022 10:00");
            System.out.println("date5: " + date5);
            // Fecha no válida
            Date date6 = df.parse("28/02/2022 1000");
            System.out.println("Esta línea no debería ejecutarse");
        } catch (ParseException e) {
            System.out.println("La fecha no es válida");
        }

        // TimeZone
        TimeZone timezone = df.getTimeZone();
        System.out.println("Zona horaria del sistema: " + timezone.getDisplayName());
        System.out.println("TZ IDs disponibles");
        for(String tzId : TimeZone.getAvailableIDs()) {
            System.out.println(" - " + tzId);
        }
    }
}
