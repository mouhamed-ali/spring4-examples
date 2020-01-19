package org.spring.tutorial.examples.junit.service.impl;

import org.spring.tutorial.examples.junit.dao.CustomerDao;
import org.spring.tutorial.examples.junit.entities.Customer;

public class CustomerServiceImpl {

	private CustomerDao dao;
	
	public Customer getById(Long id){
		
		return dao.findById(id);
	}

	//this method is so important when using xml configuration
	public void setDao(CustomerDao dao) {
		this.dao = dao;
	}
}
