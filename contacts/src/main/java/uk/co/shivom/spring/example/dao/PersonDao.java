package uk.co.shivom.spring.example.dao;

import java.util.List;

import uk.co.shivom.spring.example.entity.Person;

public interface PersonDao {
	
	public Person create(Person person);
	
	public Person update(Person person);
	
	public Person get(Long id);
	
	public List<Person> getPersons(String name, int pageNumber, int pageSize);

}
