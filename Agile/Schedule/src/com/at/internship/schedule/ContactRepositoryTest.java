package com.at.internship.schedule;

import com.at.internship.schedule.domain.Contact;
import com.at.internship.schedule.repository.ContactRepository;
import com.at.internship.schedule.repository.SingletonRepository;

import java.time.LocalDate;
import java.time.Month;

import static com.at.internship.schedule.repository.SingletonRepository.getSingleton;
import static com.at.internship.schedule.repository.SingletonRepository.KEY_CONTACT_REPOSITORY;

public class ContactRepositoryTest {

    public static void main(String[] args) {
        ContactRepository contactRepository = (ContactRepository) getSingleton(KEY_CONTACT_REPOSITORY);

        Contact contact;

        contact = new Contact();
        contact.setFirstName("Pablo");
        contact.setLastName("Castañeda");
        contact.setEmailAddress("pablo.1.gmail.com");
        contact.setPhoneNumber("1111111111");
        contact.setBirthDay(LocalDate.of(1997, 12, 31));
        contactRepository.save(contact);

        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastName("Santander");
        contact.setEmailAddress("david.1.gmail.com");
        contact.setPhoneNumber("2222222222");
        contact.setBirthDay(LocalDate.of(1995, 12, 30));
        contactRepository.save(contact);

        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastName("Barredo");
        contact.setEmailAddress("david.2.gmail.com");
        contact.setPhoneNumber("3333333333");
        contact.setBirthDay(LocalDate.of(1985, 5, 25));
        contactRepository.save(contact);

        System.out.println("\nAll the contacts...");
        contactRepository.findAll().forEach(System.out::println);

        System.out.println("\nAll the Davids");
        contactRepository.findAllByName("DAVID").forEach(System.out::println);

        System.out.println("\nEveryone who has a birthday on December");
        contactRepository
                .findAll(c -> c.getBirthDay().getMonth() == Month.DECEMBER)
                .forEach(System.out::println);
    }

}
