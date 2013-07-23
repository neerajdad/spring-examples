package uk.co.shivom.spring.example.one.service;

import org.springframework.stereotype.Service;

import uk.co.shivom.spring.example.one.model.Person;

@Service
public class GreetingsService {
	
	public void sayHello(Person p) {
		System.out.println("Howdy "+ p.getName()+" !!!!");
	}
	
}
