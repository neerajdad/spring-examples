package uk.co.shivom.spring.example.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY, mappedBy="person")
	private Set<EmailAddress> emailAddresses;

	@Temporal(TemporalType.TIMESTAMP)
    private Date dateOfBirth;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmailAddress> getEmailAddresses() {
		return emailAddresses;
	}

	public void setEmailAddresses(Set<EmailAddress> emailAddresses) {
		this.emailAddresses = emailAddresses;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	} 

}
