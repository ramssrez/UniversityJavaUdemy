package com.ramssrez.app.service.impl;

import com.ramssrez.app.dto.ContactDto;
import com.ramssrez.app.service.IContact;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ContactListImp implements IContact {

    public static final List<ContactDto> CONTACTS = Arrays.asList(
            new ContactDto(1,"Raúl","Ramirez","ejemplo@ejemplo.com","5555555512", LocalDate.of(1992,06,27)),
            new ContactDto(2,"Julio","Iglesias","ejemplo2@ejemplo.com","5555555513", LocalDate.of(1992,05,27)),
            new ContactDto(3,"Antonio","Morales","ejemplo3@ejemplo.com","5555555514", LocalDate.of(1992,03,27))
            );
    @Override
    public List<ContactDto> getContactList() {
        return CONTACTS;
    }
}
