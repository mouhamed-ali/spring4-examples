package org.spring.tutorial.examples.junit.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.junit.config.Application;
import org.spring.tutorial.examples.junit.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Application.class})
public class CustomerServiceImplTest {

	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@Test
	public void findById(){
		
		Customer c = customerServiceImpl.getById(2L);
		assertEquals("customer2", c.getFirstName());
		assertEquals("customer2", c.getLastName());
	}
}
