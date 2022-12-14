 package com.example.demo.service;

import java.util.List;

import com.example.demo.binding.Contact;

public interface ContactService {
	
	public String savaContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer contactId);
	
	public String updateContact(Contact contact);
	
	public String deleteContactById(Integer contactId);
	
 
}
