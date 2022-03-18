package com.at.intership.schedule;

import com.at.intership.schedule.domain.Contact;
import com.at.intership.schedule.repositorio.ContactRepository;
import com.at.intership.schedule.StaticExample;


import java.time.LocalDate;
import java.time.Month;

public class Test {
    public static void main(String[] args) {
        ContactRepository repository = new ContactRepository();
        Contact contact;
        contact = new Contact();
        contact.setFirstName("Pablo");
        contact.setLastname("Castañeda");
        contact.setEmailAdress("pablo@gmail.com");
        contact.setPhoneNumber("11111111111");
        contact.setBirday(LocalDate.of(1997,12,31));

        repository.save(contact);
        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastname("Santander");
        contact.setEmailAdress("david@gmail.com");
        contact.setPhoneNumber("11111111110");
        contact.setBirday(LocalDate.of(1995,12,30));
        repository.save(contact);

        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastname("Barredo");
        contact.setEmailAdress("david2@gmail.com");
        contact.setPhoneNumber("11111111110");
        contact.setBirday(LocalDate.of(1955,5,25));
        repository.save(contact);
        System.out.println("All contacts .......");
        repository.findAll().forEach(System.out::println);

        System.out.println("All the Davids");
        repository.findAllByName("David").forEach(System.out::println);

        System.out.println("Every who was birthday on december");
        repository.findAll(c -> c.getBirday().getMonth() == Month.DECEMBER).forEach(System.out::println);

        StaticExample.printSomething();

    }
}
