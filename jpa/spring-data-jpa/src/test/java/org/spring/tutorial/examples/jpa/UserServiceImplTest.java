package org.spring.tutorial.examples.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jpa.domain.User;
import org.spring.tutorial.examples.jpa.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
public class UserServiceImplTest {

	@Autowired
	UserServiceImpl userService;
	
	@Test
	@Sql(scripts="/db/sql/insert-data.sql",executionPhase=ExecutionPhase.BEFORE_TEST_METHOD)
	public void testCreate(){
		
		System.out.println("--------------- test count ---------------");
		System.out.println(userService.getUsersCount());
		
		System.out.println("--------------- test create ---------------");
		userService.createUser(new User(99,"AAA","AAA@AAA.com"));
		
		System.out.println("--------------- test find ---------------");
		User user = userService.findUserById(99L);
		System.out.println(user);
		
		System.out.println("--------------- test update ---------------");
		user.setEmail("BBB@BBB.com");
		user.setName("BBB");
		userService.updateUser(user);
		
		System.out.println("--------------- test User existence ---------------");
		System.out.println(userService.existUser(99L));
		
		System.out.println("--------------- test find by email ---------------");
		System.out.println(userService.findUserByEmail("BBB@BBB.com"));
		
		System.out.println("--------------- test find by email , name---------------");
		System.out.println(userService.findUserByEmailEtName("BBB@BBB.com","BBB"));
		
		System.out.println("--------------- test retirieve by name ---------------");
		System.out.println(userService.retrieveUserByItsName("BBB"));
		
		System.out.println("--------------- test retirieve by email ---------------");
		System.out.println(userService.retrieveUserByItsEmail("BBB@BBB.com"));
		
		System.out.println("--------------- test retirieve count ---------------");
		System.out.println(userService.retrieveCount());
		
		System.out.println("--------------- test retirieve by identifier ---------------");
		System.out.println(userService.retrieveUserByItsId(99L,"BBB@BBB.com"));
		
		System.out.println("--------------- test get User by a dummy example ---------------");
		System.out.println(userService.selectUserByExample());
		

		System.out.println("--------------- test count ---------------");
		System.out.println(userService.getUsersCount());
		
		System.out.println("--------------- test selectAll ---------------");
		showUsers(userService.getAll());

		System.out.println("--------------- test select page 1 ---------------");
		showUsers(userService.getPage(1));
		
		System.out.println("--------------- test select page 1 sorted by email ---------------");
		showUsers(userService.getSortedByEmailPage(1));

		System.out.println("--------------- test remove user ---------------");
		userService.removeUser(user);
		
		System.out.println("--------------- test remove user by id ---------------");
		//userService.removeById(1L);
		
	}
	
	private void showUsers(Page<User> page) {
		for(User user : page){
			System.out.println(user);
		}
	}

	public void showUsers(List<User> list){
		for(User user : list){
			System.out.println(user);
		}
	}
}
