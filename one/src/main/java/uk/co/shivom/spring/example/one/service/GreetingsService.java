package uk.co.shivom.spring.example.one.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

import uk.co.shivom.spring.example.one.model.Person;

@Service
public class GreetingsService {
	
	public void sayHello(Person p) {
		System.out.println("Howdy "+ p.getName()+" !!!!");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Initialising the service bean ......");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("destroying the service bean ......");
	}
}
