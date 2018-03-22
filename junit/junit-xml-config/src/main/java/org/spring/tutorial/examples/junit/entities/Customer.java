package org.spring.tutorial.examples.junit.entities;

public class Customer {

	private Long idetifier;
	private String firstName;
	private String lastName;
	
	@Override
	public String toString() {
		return "Customer [idetifier=" + idetifier + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	public Customer(Long idetifier, String firstName, String lastName) {
		super();
		this.idetifier = idetifier;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdetifier() {
		return idetifier;
	}

	public void setIdetifier(Long idetifier) {
		this.idetifier = idetifier;
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
