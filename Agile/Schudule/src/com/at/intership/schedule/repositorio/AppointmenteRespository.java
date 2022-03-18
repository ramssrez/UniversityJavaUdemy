package com.at.intership.schedule.repositorio;

import com.at.intership.schedule.domain.Appointment;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppointmenteRespository {
    private List<Appointment> appointmentList = new ArrayList<>();
    private static int ID_SEQUENCE = 0;
    AppointmenteRespository(){}
    public List<Appointment> findAll() {
        return appointmentList
                .stream()
                .map(Appointment::new)
                .collect(Collectors.toList());
    }

    public List<Appointment> findAll(Predicate<Appointment> predicate) {
        if (predicate == null) {
            return findAll();
        }
        return appointmentList
                .stream()
                .filter(predicate)
                .map(Appointment::new)
                .collect(Collectors.toList());
    }

    public Appointment save(Appointment appointment) {
        Appointment clone = new Appointment(appointment);
        if (clone.getId() == null) {
            appointment.setId(++ID_SEQUENCE);
        }
        int index = appointmentList.indexOf(appointment);
        if (index > -1) {
            appointmentList.set(index, clone);
        } else {
            appointmentList.add(clone);
        }
        return new Appointment(clone);
    }

    public void delete(Integer identificador) {
        appointmentList = appointmentList
                .stream()
                .filter(c -> !c.getId().equals(identificador))
                .collect(Collectors.toList());
    }
    public Appointment findById(Integer id) {
        return  appointmentList.get(id-1);
    }
}
