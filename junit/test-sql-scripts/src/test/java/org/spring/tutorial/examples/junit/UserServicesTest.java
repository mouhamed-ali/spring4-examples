package org.spring.tutorial.examples.junit;

import org.junit.Ignore;
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
@Sql("/db/sql/insert-data.sql")
/*
 * the 'insert-data.sql' will be run before any @Test annotated method
 * one of the tests will be failed because we cannot execute the insert script in every method
 * (user already exists)
 */
public class UserServicesTest {

	@Autowired
	UserDaoImpl dao;

    //its not the best way to make unit tests (we must use asserts). but its just an example to show our app data
	@Test
    @Ignore
	public void test(){
		System.out.println("----------  Test 1 ----------");
		User user = dao.getUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void test2(){
		System.out.println("----------  Test 2 ----------");
		User user = dao.getUserById(1);
		System.out.println(user);
	}
}
