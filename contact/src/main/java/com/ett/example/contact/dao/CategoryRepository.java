package com.ett.example.contact.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ett.example.contact.entities.Category;
import com.ett.example.contact.entities.Contact;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	@Query(value = "select * from Category c where c.name like :x" , nativeQuery = true)
    public Page<Category> chercher(@Param("x")String mc, Pageable pageable);
	@Query(value = "select * from Category c where c.id = :x" , nativeQuery = true)
	public Page<Category> getContacts (@Param("x")int id, Pageable pageable);
}
