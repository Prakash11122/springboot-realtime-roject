package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.binding.Contact;
import com.example.demo.service.ContactService;


@RestController
public class ContactRestController {
	
	@Autowired
	private ContactService service;
	
	@PostMapping("/contact")
	public String createContact(@RequestBody Contact contact) {
		String status = service.savaContact(contact);
		return status;
	}
	
	@GetMapping("/contacts")
	public List<Contact> getAllContacts(){
		return service.getAllContacts();
	}
	
	@GetMapping("/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return service.getContactById(contactId);
	}
	@PutMapping("/contact")
	public String UpdateContact(@RequestBody Contact contact) {
		return service.updateContact(contact);
	}
	@DeleteMapping("/contact/{contactId}")
	public String deleteContact(@PathVariable Integer contactId) {
		return service.deleteContactById(contactId);
	}

}
