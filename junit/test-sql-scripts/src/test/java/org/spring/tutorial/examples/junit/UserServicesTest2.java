package org.spring.tutorial.examples.junit;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.junit.dao.UserDaoImpl;
import org.spring.tutorial.examples.junit.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlConfig.ErrorMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
public class UserServicesTest2 {

	@Autowired
	UserDaoImpl dao;
	
	@Test
	@Sql("/db/sql/insert-data.sql")
	/*
	 * this script will be run before the execution of this method
	 */
	@Sql(
			scripts="/db/sql/update-data.sql"
			,executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD
			,config=@SqlConfig(
					errorMode=ErrorMode.FAIL_ON_ERROR,
					commentPrefix="//",
					separator="@@"
					)
			)
	/*
	 * this script will be run after the execution of this method (and other tests if they exists. check application logs)
	 * if the script generates an exception our test will be in failure (otherwise use ErrorMode.CONTINUE_ON_ERROR )
	 * commentPrefix and separator used to specialize the generated error script
	 * ( for comments we will use // and @@ as separator)
	 */
	public void test(){
		System.out.println("----------  Test 1 ----------");
		List<User> users = dao.findAll();
		users.forEach(System.out::println);
	}
}
