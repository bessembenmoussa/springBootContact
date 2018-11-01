package com.ett.example.contact.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Entity
public class Contact implements Serializable{
	
@Id @GeneratedValue 
private Long id;
private String Nom;
private String Prenom;
@Temporal(TemporalType.DATE) //formater le type date 
private Date dateNaissance;
private String email;
private long tel;
private String photo;
@ManyToOne(fetch = FetchType.EAGER)
private Category category;

public Contact() {
	super();
	// TODO Auto-generated constructor stub
}
public Contact(String nom, String prenom, Date dateNaissance, String email, long tel, String photo) {
	super();
	Nom = nom;
	Prenom = prenom;
	this.dateNaissance = dateNaissance;
	this.email = email;
	this.tel = tel;
	this.photo = photo;
}


public Contact(String nom, String prenom, Date dateNaissance, String email, long tel, String photo, Category category) {
	super();
	Nom = nom;
	Prenom = prenom;
	this.dateNaissance = dateNaissance;
	this.email = email;
	this.tel = tel;
	this.photo = photo;
	this.category = category;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
}
public String getPrenom() {
	return Prenom;
}
public void setPrenom(String prenom) {
	Prenom = prenom;
}
public Date getDateNaissance() {
	return dateNaissance;
}
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getTel() {
	return tel;
}
public void setTel(long tel) {
	this.tel = tel;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}




}
