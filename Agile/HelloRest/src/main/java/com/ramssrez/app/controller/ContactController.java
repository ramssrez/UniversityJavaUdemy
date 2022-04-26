package com.ramssrez.app.controller;

import com.ramssrez.app.dto.ContactDto;
import com.ramssrez.app.service.IContact;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    IContact iContact;

    public ContactController(IContact iContact) {
        this.iContact = iContact;
    }
    //path http://localhost:8080/contact/list
    @GetMapping("/list")
    public List<ContactDto> retornarList(){
        return iContact.getContactList();
    }
}
