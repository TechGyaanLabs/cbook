package com.careerit.cbook.api;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

        @Autowired
        private ContactService contactService;
        @GetMapping("/all")
        public List<Contact> getContacts(){
            return contactService.getContacts();
        }

        @GetMapping("/search")
        public List<Contact> search(@RequestParam(defaultValue = "") String str){
            return contactService.search(str);
        }

        @PostMapping
        public Contact addContact(@RequestBody Contact contact){
            return contactService.addContact(contact);
        }

        @PutMapping
        public Contact updateContact(@RequestBody  Contact contact){
            return contactService.updateContact(contact);
        }

        @DeleteMapping("/{id}")
        public boolean deleteContact(@PathVariable UUID id){
            return contactService.deleteContact(id);
        }

         @GetMapping("/{id}")
        public boolean getContactById(@PathVariable UUID id){
            return contactService.getContact(id);
        }

}
