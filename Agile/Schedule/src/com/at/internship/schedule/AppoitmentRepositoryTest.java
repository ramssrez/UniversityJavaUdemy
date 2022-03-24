package com.at.internship.schedule;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.repository.AppointmentRepository;
import com.at.internship.schedule.repository.SingletonRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public class AppoitmentRepositoryTest {
    public static void main(String[] args) {
        AppointmentRepository appointmentRepository = (AppointmentRepository) SingletonRepository.getSingleton(SingletonRepository.KEY_APPOINTMENT_REPOSITORY);
        // ContactRepository contactRepository = (ContactRepository) SingletonRepository.getSingleton(KEY_CONTACT_REPOSITORY);

        ContactRepositoryTest.saveContacts();

        Appointment appointment;

        appointment = new Appointment();
        appointment.setContactId(1);
        appointment.setTime(LocalDateTime.of(2022, 04, 15, 8, 15));
        appointment.setSubject("Code Review Session");
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(2);
        appointment.setTime(LocalDateTime.of(2022, 03, 14, 9, 20));
        appointment.setSubject("Information Session");
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(3);
        appointment.setTime(LocalDateTime.of(2022, 03, 15, 12, 30));
        appointment.setSubject("Java Proyect");
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(1);
        appointment.setTime(LocalDateTime.of(2022, 03, 15, 10,15));
        appointment.setSubject("Meeting");
        appointmentRepository.save(appointment);

        Optional<? extends Appointment> optSelect = appointmentRepository.findOne(2);
        Appointment select = optSelect.get();
        System.out.println("Appointment # " + select.getId());
        System.out.println("Contact ID: " + select.getContactId());
        System.out.println("Contact name: " + select.getContact().getFirstName());
    }
}
