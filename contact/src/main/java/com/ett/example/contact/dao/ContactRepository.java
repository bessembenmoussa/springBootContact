package com.ett.example.contact.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ett.example.contact.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
	@Query(value = "select * from Contact c where c.nom like :x" , nativeQuery = true)
    public Page<Contact> chercher(@Param("x")String mc, Pageable pageable);
}
