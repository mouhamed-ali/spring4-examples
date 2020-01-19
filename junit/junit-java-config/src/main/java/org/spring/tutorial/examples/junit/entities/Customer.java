package org.spring.tutorial.examples.junit.entities;

public class Customer {

	private Long identifier;
	private String firstName;
	private String lastName;
	
	@Override
	public String toString() {
		return "Customer [identifier=" + identifier + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Customer(Long identifier, String firstName, String lastName) {
		super();
		this.identifier = identifier;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Customer() {
	}

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
