package com.at.internship.schedule.repository;

import com.at.internship.schedule.domain.Appointment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppointmentRepository {
    private static int ID_SEQUENCE = 0;

    private List<Appointment> appointmentList = new ArrayList<>();
    private ContactRepository contactRepository;

    AppointmentRepository() { }

    public List<Appointment> findAll() {
        return appointmentList.stream().map(Appointment::new).collect(Collectors.toList());
    }

    public Optional<Appointment> findOne(Integer id) {
        return appointmentList
                .stream().filter(a -> Objects.equals(a.getId(), id))
                .findFirst();
    }

    public List<Appointment> findAll(Predicate<? super Appointment> predicate) {
        if(predicate == null)
            return findAll();
        return appointmentList.stream().filter(predicate).map(Appointment::new).collect(Collectors.toList());
    }

    public Appointment save(Appointment c) {
        Appointment clone = new Appointment(c);
        if(clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = appointmentList.indexOf(clone);
        if(index > -1)
            appointmentList.set(index, clone);
        else
            appointmentList.add(clone);

        return new Appointment(clone);
    }

    public void delete(Integer id) {
        appointmentList = appointmentList.stream().filter(c -> !c.getId().equals(id)).collect(Collectors.toList());
    }

    public List<Appointment> findAllByDate(LocalDate date) {
        return appointmentList
                .stream()
                .filter(c -> date.isEqual(c.getTime().toLocalDate()))
                .map(Appointment::new)
                .collect(Collectors.toList());
    }
}
