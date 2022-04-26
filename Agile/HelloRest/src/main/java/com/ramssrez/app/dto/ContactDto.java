package com.ramssrez.app.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;

    public ContactDto(Integer id, String firstName, String lastName, String email, String phoneNumber, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }
}
