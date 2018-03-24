package org.spring.tutorial.examples.jpa;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jpa.domain.User;
import org.spring.tutorial.examples.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
@Sql(scripts="/db/sql/insert-data.sql",executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
public class UserServiceImplTest {

	@Autowired
	IUserService userService;
	
	@Test
	public void testCreate(){
		System.out.println("--------------- test create ---------------");
		userService.createUser(new User(99,"AAA","AAA@AAA.com"));
		
		System.out.println("--------------- test find ---------------");
		User user = userService.findUserById(99);

		System.out.println("--------------- test selectAll ---------------");
		selectAll();
		
		System.out.println("--------------- test update ---------------");
		user.setEmail("BBB@BBB.com");
		user.setName("BBB");
		userService.updateUser(user);

		System.out.println("--------------- test selectAll ---------------");
		selectAll();
		
		System.out.println("--------------- test remove ---------------");
		userService.removeById(user);

		System.out.println("--------------- test selectAll ---------------");
		selectAll();
		
	}
	
	public void selectAll(){

		List<User> users = userService.getAll();
		for(User user : users){
			System.out.println(user);
		}
	}
}
