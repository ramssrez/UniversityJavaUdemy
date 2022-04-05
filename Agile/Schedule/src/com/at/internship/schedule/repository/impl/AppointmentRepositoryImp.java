package com.at.internship.schedule.repository.impl;

import com.at.internship.schedule.domain.Appointment;
import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.repository.IRepository;
import com.at.internship.schedule.serialization.csv.ApoitmentSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppointmentRepositoryImp implements IRepository<Appointment,Integer> {
    private static int ID_SEQUENCE = 0;

    private List<Appointment> appointmentList;
    private ContactRepositoryImp contactRepository;
    private ApoitmentSerializer serializer;

    AppointmentRepositoryImp() {
        serializer = new ApoitmentSerializer();
        appointmentList = serializer.deserialize();
        ID_SEQUENCE = appointmentList.stream().map(Appointment::getId).max(Integer::compare).orElse(0);
    }

    private ContactRepositoryImp getContactRepository() {
        if(contactRepository == null)
            contactRepository = (ContactRepositoryImp) SingletonRepository.getSingleton(SingletonRepository.KEY_CONTACT_REPOSITORY);
        return contactRepository;
    }

    public synchronized List<Appointment> findAll() {
        return appointmentList.stream().map(Appointment::new).collect(Collectors.toList());
    }

    public synchronized List<Appointment> findAll(Predicate<? super Appointment> predicate) {
        if(predicate == null)
            return findAll();
        return appointmentList.stream().filter(predicate).map(InnerAppointment::new).collect(Collectors.toList());
    }

    public synchronized Optional<? extends Appointment> findOne(Integer id) {
        return appointmentList
                .stream().filter(a -> Objects.equals(a.getId(), id)).map(InnerAppointment::new)
                .findFirst();
    }

    public synchronized Appointment save(Appointment c) throws IOException {
        Appointment clone = new InnerAppointment(c);
        if(clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = appointmentList.indexOf(clone);
        if(index > -1)
            appointmentList.set(index, clone);
        else
            appointmentList.add(clone);
        serializer.serialize(appointmentList);
        return new InnerAppointment(clone);
    }

    public synchronized void delete(Integer id) throws IOException {
        appointmentList = appointmentList.stream().filter(c -> !c.getId().equals(id)).collect(Collectors.toList());
        serializer.serialize(appointmentList);
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
