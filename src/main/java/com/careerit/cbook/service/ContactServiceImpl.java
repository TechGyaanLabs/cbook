package com.careerit.cbook.service;

import com.careerit.cbook.domain.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {

        private List<Contact> contacts = new ArrayList<>();

        @Override
        public Contact addContact(Contact contact) {
            UUID id = UUID.randomUUID();
            contact.setId(id);
            contacts.add(contact);
            log.info("Contact added with id : {}", id);
            return contact;
        }

        @Override
        public Contact updateContact(Contact contact) {
               UUID id = contact.getId();
                for(int i = 0; i < contacts.size(); i++){
                     if(contacts.get(i).getId().equals(id)){
                          contacts.set(i, contact);
                          log.info("Contact updated with id : {}", id);
                          return contact;
                     }
                }
                log.error("Contact not found with id : {}", id);
                return contact;
        }

        @Override
        public boolean deleteContact(UUID id) {
                for (Contact contact : contacts) {
                    if(contact.getId().equals(id)){
                        contacts.remove(contact);
                        log.info("Contact deleted with id : {}", id);
                        return true;
                    }
                }
                log.error("Contact not found with id : {}", id);
                return false;
        }

        @Override
        public Contact getContact(UUID id) {
              for (Contact contact : contacts) {
                  if(contact.getId().equals(id)){
                        log.info("Contact found with id : {}", id);
                      return contact;
                  }
              }
              log.error("Contact not found with id : {}", id);
              throw new IllegalArgumentException("Contact not found with id : "+id);
        }

        @Override
        public List<Contact> getContacts() {
                log.info("Total contacts found : {}", contacts.size());
                return contacts;
        }

        @Override
        public List<Contact> search(String str) {
                List<Contact> searchContacts = new ArrayList<>();
                for (Contact contact : contacts) {
                    if(contact.getFullName().contains(str) || contact.getEmail().contains(str) || contact.getMobile().contains(str)){
                        searchContacts.add(contact);
                    }
                }
                log.info("Total contacts found with search string : {}", searchContacts.size());
                return searchContacts;
        }
}
