package org.spring.tutorial.examples.junit;

import org.junit.After;
import org.junit.AfterClass;
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
import java.util.List;

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
		System.out.println("----------  Test 1 ----------");
		List<User> users = dao.findAll();
		users.forEach(System.out::println);
	}

	@After
	/*
	 * this method will be run after evey test (after every test run)
	 */
	public void testAfter(){
		System.out.println("----------  @After Test 1 ----------");
		List<User> users = dao.findAll();
		users.forEach(System.out::println);
	}

	@AfterClass
	/*
	 * this method will be run after all the tests (one time)
	 */
	public static void testAfterClass(){
		System.out.println("----------  @AfterClass Test 1 ----------");
		UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDaoImpl");
		List<User> users = userDao.findAll();
		users.forEach(System.out::println);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}
}
