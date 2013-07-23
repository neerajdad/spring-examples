package uk.co.shivom.spring.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import uk.co.shivom.spring.example.one.model.Person;
import uk.co.shivom.spring.example.one.model.SamePerson;
import uk.co.shivom.spring.example.one.service.GreetingsService;

/**
 * This example illustrates the singleton beans and prototype beans
 * @author neerajdad
 *
 */
public class GreetingsApplication {

	public static void main(String[] args) {
		ApplicationContext context = (ApplicationContext) new ClassPathXmlApplicationContext("applicationContext.xml");
		Person p = (Person) context.getBean("person");
		p.setName("Neeraj");
		GreetingsService g = (GreetingsService) context.getBean("greetingsService");
		g.sayHello(p);
		Person p1 = (Person) context.getBean("person");
		g.sayHello(p1);
		SamePerson s = (SamePerson) context.getBean("samePerson");
		s.setName("Neel");
		g.sayHello(s);
		SamePerson s1 = (SamePerson) context.getBean("samePerson");
		g.sayHello(s1);
		
	}

}
