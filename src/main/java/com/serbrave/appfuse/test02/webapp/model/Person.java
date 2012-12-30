package com.serbrave.appfuse.test02.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Common class to handle Person
 * 
 * <p>
 * <a href="Person.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:roysiu@serbrave.com">Roy Siu</a>
 *
 * 
 */
@Entity
@Table(name = "person")
public class Person {
	private Long id;
	private String firstName;
	private String lastName;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
