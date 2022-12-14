package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.binding.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactRepository repo;
	

	@Override
	public String savaContact(Contact contact) {
		
		contact = repo.save(contact); //insertion
		if (contact.getContactId() !=null) {
			return "contact save successfully";
		}else {
			return "contact faild to save";
		}
			
	}

	@Override
	public List<Contact> getAllContacts() {
		
	 return	repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		
	  Optional<Contact> findById = repo.findById(contactId);
	  if (findById.isPresent()) {
		  return findById.get();
	  }
	  return null;
	  
	}

	@Override
	public String updateContact(Contact contact) {
		
		if (repo.existsById(contact.getContactId())) {
			repo.save(contact); //update operation
			return "Update successful";
		}else {
			return "No Record Found";
		}		
	}

	@Override
	public String deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		if (repo.existsById(contactId)) {
			repo.deleteById(contactId);
			return "record deleted";
		}else {
			return "No record found";
		}
	}

}
