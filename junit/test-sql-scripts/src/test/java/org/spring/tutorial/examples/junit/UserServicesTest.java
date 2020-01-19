package org.spring.tutorial.examples.junit;

import org.junit.Assert;
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
@Sql(scripts = "/db/sql/delete-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
/*
 * the 'insert-data.sql' will be run before any @Test annotated method
 * one of the tests will be failed because we cannot execute the insert script in every method
 * (user already exists)
 * We gonna delete data after each test so we will not have errors (user already exist) when running the next test
 */
public class UserServicesTest {

	@Autowired
	UserDaoImpl dao;

	@Test
	public void testSelect(){
		User user = dao.getUserById(1);
		Assert.assertEquals("mkyong", user.getName());
		Assert.assertEquals("mkyong@gmail.com", user.getEmail());
	}
	
	@Test
	public void testSelect2(){
		User user = dao.getUserById(2);
		Assert.assertEquals("alex", user.getName());
		Assert.assertEquals("alex@yahoo.com", user.getEmail());
	}
}
