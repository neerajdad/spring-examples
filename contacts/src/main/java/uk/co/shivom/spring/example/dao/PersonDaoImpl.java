package uk.co.shivom.spring.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import uk.co.shivom.spring.example.entity.Person;

@Repository("personDao")
public class PersonDaoImpl implements PersonDao {

	private EntityManager em = null;
	
	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public Person create(Person person) {
		em.persist(person);
		return person;
	}

	@Transactional
	public Person update(Person person) {
		Person p = em.merge(person);
		return p;
	}

	@Transactional(readOnly = true)
	public Person get(Long id) {
		Person person = em.find(Person.class, id);
		return person;
	}

	public List<Person> getPersons(String name, int pageNumber, int pageSize) {
		Session session = (Session) em.getDelegate();
		Criteria criteria = session.createCriteria(Person.class);
		if(name!=null) {
			criteria.add(Restrictions.eq("name", name));
		}
		criteria.addOrder(Order.asc("id"));
		if(pageNumber > 0 && pageSize > 0) {
			criteria.setFirstResult((pageNumber-1) *pageSize);
		}
		if(pageSize > 0) {
			criteria.setMaxResults(pageSize);
		}
		List<Person> persons =  criteria.list();
		return persons;
	}

}
