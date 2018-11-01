package com.ett.example.contact.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy="category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Collection<Contact> contacts;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Collection<Contact> contacts) {
		this.contacts = contacts;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String name, Collection<Contact> contacts) {
		super();
		this.name = name;
		this.contacts = contacts;
	}
	public Category(String name) {
		super();
		this.name = name;
	}
	public Category(Long id, String name, Collection<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.contacts = contacts;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
