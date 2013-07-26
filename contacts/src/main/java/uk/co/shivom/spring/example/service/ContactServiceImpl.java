package uk.co.shivom.spring.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.shivom.spring.example.dao.PersonDao;
import uk.co.shivom.spring.example.entity.Person;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private PersonDao personDao;
	
	public Long save(Person person) {
		Person persistedPerson = personDao.create(person);
		if(persistedPerson != null) {
			return persistedPerson.getId();
		} else {
			return null;
		}
	}

	public Person getContact(Long contactId) {
		Person person = personDao.get(contactId);
		return person;
	}

	public List<Person> getContacts(String name, int maxResults, int startOffset) {
		List<Person> persons = personDao.getPersons(name, startOffset, maxResults);
		return persons;
	}

}
