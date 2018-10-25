package com.ett.example.contact;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ett.example.contact.dao.ContactRepository;
import com.ett.example.contact.entities.Contact;

@SpringBootApplication
public class ContactApplication implements CommandLineRunner{
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// TODO Auto-generated method stub
		contactRepository.save(new Contact("Ben Moussa", "Bessem", df.parse("16/06/1988"), "bessem.bnmoussa@gmail.com", 52198080, "bessem.png"));
		contactRepository.save(new Contact("Bou seta", "Ziyed", df.parse("10/04/1988"), "zied@gmail.com", 50022585, "ziyed.png"));
		contactRepository.save(new Contact("Farhat", "Rami", df.parse("19/02/1990"), "rami@gmail.com", 25648572, "rami.png"));
		contactRepository.findAll().forEach(c ->{
			System.out.println(c.getNom());
		});
		

	}
}
