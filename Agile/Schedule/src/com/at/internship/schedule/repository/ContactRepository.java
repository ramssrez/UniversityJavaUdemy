package com.at.internship.schedule.repository;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.specification.SpecificationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactRepository {
    private static int ID_SEQUENCE = 0;

    private List<Contact> contactList = new ArrayList<>();

    ContactRepository() {}

    public List<Contact> findAll() {
        return contactList
                .stream() // contactList genera stream de salida a través de la función stream()
                // Stream de entrada va a la operación map
                .map(Contact::new)
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
                .map(Contact::new)
                .collect(Collectors.toList());
    }

    public Contact save(Contact c) {
        Contact clone = new Contact(c);
        if(clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = contactList.indexOf(c);
        if(index > -1)
            contactList.set(index, clone);
        else
            contactList.add(clone);

        return new Contact(clone);
    }

    public void delete(Integer id) {
        contactList = contactList
                .stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Contact> findAllByName(String name) {
        return contactList
                .stream()
                .filter(c -> SpecificationUtils.like(String.format("%s %s", c.getFirstName(), c.getLastName()), name))
                .map(Contact::new)
                .collect(Collectors.toList());
    }

}
