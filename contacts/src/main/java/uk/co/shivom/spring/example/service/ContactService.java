package uk.co.shivom.spring.example.service;

import java.util.List;

import uk.co.shivom.spring.example.entity.Person;

public interface ContactService {
	
	public Long save(Person person);
	
	public Person getContact(Long contactId);
	
	public List<Person> getContacts(String name, int maxResults, int startOffset);

}
