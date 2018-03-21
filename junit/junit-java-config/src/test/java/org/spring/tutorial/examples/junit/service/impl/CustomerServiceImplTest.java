package org.spring.tutorial.examples.junit.service.impl;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.junit.config.Application;
import org.spring.tutorial.examples.junit.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={Application.class})
public class CustomerServiceImplTest {

	@Autowired
	CustomerServiceImpl customerServiceImpl;
	
	@Test
	public void retournerParIdentifiantTest(){
		
		Customer c = customerServiceImpl.retournerParIdentifiant(2L);
		assertEquals("customer2", c.getFirstName());
		assertEquals("customer2", c.getLastName());
	}
}
