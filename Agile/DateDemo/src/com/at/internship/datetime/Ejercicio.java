package com.at.internship.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaAhora = LocalDate.now();
        System.out.print("Captura tu fecha de nacimiento en formato DD/MM/AAAA > ");
        String fechaNacimientoString = scanner.nextLine();
        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoString,formatoFecha);
        Period period = Period.between(fechaNacimiento,fechaAhora);
        int meses = period.getMonths();
        int years = period.getYears();
        System.out.println("Tu edad es: " + years + " años, " + meses + " meses");
    }
}
