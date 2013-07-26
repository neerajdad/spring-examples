package uk.co.shivom.spring.example.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.shivom.spring.example.entity.Person;
import uk.co.shivom.spring.example.service.ContactService;

@Controller
public class ContactsController {

	@Autowired
	private ContactService service;
	
	@RequestMapping(value="/contacts/new", method=RequestMethod.GET)
	public String newContact() {
		return "contacts";
	}
	
	@RequestMapping(value="/contacts", method=RequestMethod.POST)
	public String saveContact(@ModelAttribute("contact") Person contact, BindingResult result) {
		System.out.println("contact name"+ contact.getName());
		service.save(contact);
		return "contacts";
	}
	
	@RequestMapping(value="/contacts/{id}")
	public String getContact(HttpServletRequest request, ModelMap model, @PathVariable("id") Long id) {
		Person contact = service.getContact(id);
		model.addAttribute("contact", contact);
		return "contactDetails";
	}
	
	@RequestMapping(value="/contacts")
	public String getContacts(HttpServletRequest request, ModelMap model) {
		return "contactList";
	}
	
}
