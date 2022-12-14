package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.binding.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
