package com.ett.example.contact.wweb;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ett.example.contact.dao.CategoryRepository;
import com.ett.example.contact.entities.Category;
import com.ett.example.contact.entities.Contact;

@RestController
@CrossOrigin("*")
public class CategoryRestService {
	@Autowired
	private CategoryRepository categoryRepository;
	@RequestMapping(value="/categories", method=RequestMethod.GET)
	public List<Category> getCategory(){
		return categoryRepository.findAll();
	}
	
	@RequestMapping (value = "/chercherCategories", method = RequestMethod.GET)
	public Page<Category>chercher(@RequestParam(name = "mc", defaultValue = "") String mc,
			        @RequestParam(name = "page", defaultValue = "0") int page,
			        @RequestParam(name = "size", defaultValue = "5") int size) {
		return categoryRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	@RequestMapping (value = "/getContactsOfCategory", method = RequestMethod.GET)
	public Page<Category> getContactsOfCategory (@RequestParam(name = "id") int id){
		return categoryRepository.getContacts(id,new PageRequest(0, 5));
	}
	
	@RequestMapping (value = "/addCategory", method = RequestMethod.POST)
	public Category save(@RequestBody Category c) {
		return categoryRepository.save(c);
		
	}
	@RequestMapping (value = "/deleteCategory/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		categoryRepository.deleteById(id);;
	}
	
	@RequestMapping (value = "/getCategoryById/{id}", method = RequestMethod.GET)
	public Optional<Category> getCategoryById(@PathVariable long id) {
		return categoryRepository.findById(id);
	}
	
	@RequestMapping (value = "/updateCategory/{id}", method = RequestMethod.PUT)
	public Category updateCategory(@PathVariable long id,@RequestBody Category category) {
		category.setId(id);
		return categoryRepository.save(category);
	}

}
