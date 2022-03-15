package com.at.intership.schedule.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Contact {
    private Integer id;
    private String firstName;
    private String lastname;
    private String emailAdress;
    private String phoneNumber;
    private LocalDate birday;

    public Contact() {

    }
    public Contact(Contact source) {
        this.id= source.id;
        this.firstName=source.firstName;
        this.lastname = source.lastname;
        this.emailAdress = source.emailAdress;
        this.phoneNumber = source.phoneNumber;
        this.birday = source.birday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirday() {
        return birday;
    }

    public void setBirday(LocalDate birday) {
        this.birday = birday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return id != null && id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birday=" + birday +
                '}';
    }
}
