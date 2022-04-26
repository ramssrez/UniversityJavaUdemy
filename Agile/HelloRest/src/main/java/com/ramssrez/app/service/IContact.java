package com.ramssrez.app.service;

import com.ramssrez.app.dto.ContactDto;

import java.util.List;

public interface IContact {
    List<ContactDto> getContactList();
}
