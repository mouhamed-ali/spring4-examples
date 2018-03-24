package org.spring.tutorial.examples.junit;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.junit.dao.UserDaoImpl;
import org.spring.tutorial.examples.junit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
public class UserServicesTest4 {

	@Autowired
	UserDaoImpl dao;
	
	@Test
	@Sql
	/*
	 * this annotation supposes that you have a script named
	 * UserServicesTest4.test.sql (classe.methode.sql) in your classpath
	 * the script will be run before the method execution
	 */
	public void test(){
		System.out.println("----------  Test 1 ----------");
		List<User> users = dao.findAll();
		users.forEach(System.out::println);
	}
}
