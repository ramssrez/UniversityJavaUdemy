package com.at.intership.schedule;

import com.at.intership.schedule.domain.Appointment;
import com.at.intership.schedule.repositorio.AppointmenteRespository;

import java.time.*;

public class TestAppoitment {
    public static void main(String[] args) {
        AppointmenteRespository appointmentRepository = new AppointmenteRespository();
        Appointment appointment;

        appointment = new Appointment();
        appointment.setContactId(1);
        appointment.setSubject("Junta con Adrian");
        appointment.setTime(LocalDateTime.of(2022, 3,16,12,0));
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(2);
        appointment.setSubject("Clase de inglés");
        appointment.setTime(LocalDateTime.of(2022,4,15,9,0));
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(3);
        appointment.setSubject("Clase de inglés");
        appointment.setTime(LocalDateTime.of(2022,3,15,9,0));
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(4);
        appointment.setSubject("Junta con David");
        appointment.setTime(LocalDateTime.of(2022, 3,15,10,0));
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(5);
        appointment.setSubject("Codeando con David");
        appointment.setTime(LocalDateTime.of(2022, 3,15,10,0));
        appointmentRepository.save(appointment);

        System.out.println("\nAll the appointments...");
        appointmentRepository.findAll().forEach(System.out::println);
        System.out.println("\nAll the appointments from today.....");
        appointmentRepository.findAll(a ->
                        a.getTime().getMonth() == Month.MARCH
                                && a.getTime().getDayOfMonth() == MonthDay.now().getDayOfMonth()
                                && a.getTime().getYear() == 2022)
                .forEach(System.out::println);
        System.out.println("\nAll appointments date:15/04/2022....");
        appointmentRepository.findAll(a -> a.getTime().toLocalDate().equals(LocalDate.of(2022, 4, 15)))
                .forEach(System.out::println);
    }
}
