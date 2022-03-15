package com.at.intership.schedule.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Appointment {
    private Integer id;
    private Integer contactId;
    private LocalDateTime time;
    private String subject;
    //Crear appointment Repository
    //Mostrar todos los compromisos para un dia especifico
    public Appointment() {
    }

    public Appointment(Appointment sourse) {
        this.id = sourse.id;
        this.contactId = sourse.contactId;
        this.time = sourse.time;
        this.subject = sourse.subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", contactId=" + contactId +
                ", time=" + time +
                ", subject='" + subject + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment appointment = (Appointment) o;
        return id != null && id.equals(appointment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
