package com.at.internship.schedule.repository;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.domain.Contact;

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

    private ContactRepository getContactRepository() {
        if(contactRepository == null)
            contactRepository = (ContactRepository) SingletonRepository.getSingleton(SingletonRepository.KEY_CONTACT_REPOSITORY);
        return contactRepository;
    }

    public List<Appointment> findAll() {
        return appointmentList.stream().map(Appointment::new).collect(Collectors.toList());
    }

    public Optional<? extends Appointment> findOne(Integer id) {
        return appointmentList
                .stream().filter(a -> Objects.equals(a.getId(), id)).map(InnerAppointment::new)
                .findFirst();
    }

    public List<Appointment> findAll(Predicate<? super Appointment> predicate) {
        if(predicate == null)
            return findAll();
        return appointmentList.stream().filter(predicate).map(InnerAppointment::new).collect(Collectors.toList());
    }

    public Appointment save(Appointment c) {
        Appointment clone = new InnerAppointment(c);
        if(clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = appointmentList.indexOf(clone);
        if(index > -1)
            appointmentList.set(index, clone);
        else
            appointmentList.add(clone);

        return new InnerAppointment(clone);
    }

    public void delete(Integer id) {
        appointmentList = appointmentList.stream().filter(c -> !c.getId().equals(id)).collect(Collectors.toList());
    }

    public List<Appointment> findAllByDate(LocalDate date) {
        return appointmentList
                .stream()
                .filter(c -> date.isEqual(c.getTime().toLocalDate()))
                .map(InnerAppointment::new)
                .collect(Collectors.toList());
    }

    private class InnerAppointment extends Appointment {
        private boolean contactLoaded = false;

        private InnerAppointment(Appointment source) {
            super(source);
        }

        @Override
        public Contact getContact() {
            if(!contactLoaded) {
                if(super.getContact() == null && getContactId() != null)
                    setContact(getContactRepository().findOne(getContactId()).orElse(null));
                contactLoaded = true;
            }

            return super.getContact();
        }
    }
}
