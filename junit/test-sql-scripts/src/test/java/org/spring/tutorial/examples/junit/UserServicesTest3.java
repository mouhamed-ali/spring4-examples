package org.spring.tutorial.examples.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.junit.dao.UserDaoImpl;
import org.spring.tutorial.examples.junit.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
/*
 * to be sure of the spring behavior of the last test class 'UserServicesTest2', we created this test class
 */
public class UserServicesTest3 implements ApplicationContextAware {

	@Autowired
	UserDaoImpl dao;

	//injection of the spring context to use it in the static methods
	private static ApplicationContext context;
	
	@Test
	@Sql("/db/sql/insert-data.sql")
	@Sql(
			scripts="/db/sql/update-data.sql"
			,executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD
	)
	public void test(){
		User user = dao.getUserById(1);
		Assert.assertEquals("mkyong", user.getName());
		Assert.assertEquals("mkyong@gmail.com", user.getEmail());
	}

	@After
	/*
	 * this method will be run after evey test (after every test run)
	 */
	public void testAfter(){
		User user = dao.getUserById(1);
		Assert.assertEquals("mkyong", user.getName());
		Assert.assertEquals("mkyong@gmail.com", user.getEmail());
	}

	@AfterClass
	/*
	 * this method will be run after all the tests (one time)
	 */
	public static void testAfterClass(){
		UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDaoImpl");
		User user = userDao.getUserById(1);
		Assert.assertEquals("spring", user.getName());
		Assert.assertEquals("mkyong@gmail.com", user.getEmail());
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}
