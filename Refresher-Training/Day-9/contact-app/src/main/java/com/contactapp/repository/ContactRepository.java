package com.contactapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.contactapp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

    // for create
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

    // for update
    boolean existsByEmailAndIdNot(String email, int id);

    boolean existsByPhoneAndIdNot(String phone, int id);
}