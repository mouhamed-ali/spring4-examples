package org.spring.tutorial.examples.junit.service.impl;

import org.spring.tutorial.examples.junit.dao.CustomerDao;
import org.spring.tutorial.examples.junit.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerDao dao;
	
	public Customer retournerParIdentifiant(Long id){
		
		return dao.findById(id);
	}
}
