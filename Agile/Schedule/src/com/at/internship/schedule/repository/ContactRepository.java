package com.at.internship.schedule.repository;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.serialization.csv.ContactSerializer;
import com.at.internship.schedule.specification.SpecificationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactRepository {
    private static int ID_SEQUENCE = 0;

    private List<Contact> contactList;
    private AppointmentRepository appointmentRepository;
    private ContactSerializer serializer;


    ContactRepository() {
        serializer = new ContactSerializer();
        contactList = serializer.deserialize();
        ID_SEQUENCE = contactList.stream().map(Contact::getId).max(Integer::compare).orElse(0);
    }

    public List<Contact> findAll() {
        return contactList
                .stream() // contactList genera stream de salida a través de la función stream()
                // Stream de entrada va a la operación map
                .map(Inner::new)
                // Map genera stream de salida
                // Stream de entrada va a la operación collect
                .collect(Collectors.toList());
    }

    public List<Contact> findAll(Predicate<Contact> predicate) {
        if(predicate == null)
            return findAll();
        // La referencia al método puede reemplazar la expresión lambda
        return contactList
                .stream()
                .filter(predicate)
                // filter() -> stream -> map()
                .map(Inner::new)
                .collect(Collectors.toList());
    }

    public Optional<Contact> findOne(Integer id) {
        return contactList
                .stream().filter(a -> Objects.equals(a.getId(), id))
                .findFirst();
    }

    public Contact save(Contact c) throws IOException {
        Contact clone = new Inner(c);
        if(clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = contactList.indexOf(c);
        if(index > -1)
            contactList.set(index, clone);
        else
            contactList.add(clone);
        serializer.serialize(contactList);
        return new Inner(clone);
    }

    public void delete(Integer id) throws IOException{
        contactList = contactList
                .stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.toList());
        serializer.serialize(contactList);
    }

    public List<Contact> findAllByName(String name) {
        return contactList
                .stream()
                .filter(c -> SpecificationUtils.like(String.format("%s %s", c.getFirstName(), c.getLastName()), name))
                .map(Inner::new)
                .collect(Collectors.toList());
    }
    private class Inner extends Contact {
        private boolean appointmentsLoaded = false;

        private Inner(Contact source) {
            super(source);
        }

        @Override
        public List<Appointment> getAppointments() {
            if(!appointmentsLoaded) {
                if(super.getAppointments() == null && getId() != null)
                    setAppointments(getAppointmentRepository().findAll(appointment -> appointment.getContactId().equals(getId())));
                appointmentsLoaded= true;
            }

            return super.getAppointments();
        }
    }

    private AppointmentRepository getAppointmentRepository() {
        if(appointmentRepository == null)
            appointmentRepository = (AppointmentRepository) SingletonRepository.getSingleton(SingletonRepository.KEY_APPOINTMENT_REPOSITORY);
        return appointmentRepository;
    }
}
