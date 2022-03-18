package com.at.intership.schedule.repositorio;

import com.at.intership.schedule.domain.Contact;
import com.at.intership.schedule.specification.SpacificatinUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactRepository {
    private List<Contact> contactList = new ArrayList<>();
    private static int ID_SEQUENCE =0;
    ContactRepository(){

    }
    public List<Contact> findAll(){
        return contactList
                .stream() //ContactList genera stream de salida a traves de la función stream
                //Stream de entrada va a la operacion de map
                .map(c-> new Contact(c))
                //Map genera stream de salida
                //Stream de entrada va a a la operacion collect
                .collect(Collectors.toList());
    }
    public List<Contact> findAll(Predicate<Contact> predicate){
        if (predicate == null){
            return findAll();
        }
        return contactList
                .stream()
                .filter(predicate)
                //Referencia al método puede remplazar la expresión lambda
                //filter() stream -> map()
                .map(Contact::new)
                .collect(Collectors.toList());
    }
    public Contact save(Contact contact){
        Contact clone = new Contact(contact);
        if (clone.getId() == null){
            contact.setId(++ID_SEQUENCE);
        }
        int index = contactList.indexOf(contact);
        if (index > -1) {
            contactList.set(index, clone);
        }else{
            contactList.add(clone);
        }
        return  new Contact(clone);
    }
    public void delete(Integer id){
        contactList = contactList
                .stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.toList());
    }
    public List<Contact> findAllByName (String name){
        return contactList
                .stream()
                .filter(c -> SpacificatinUtils.like(String.format("%s %s",c.getFirstName(),c.getLastname()),name))
                .map(Contact::new)
                .collect(Collectors.toList());
    }


}
