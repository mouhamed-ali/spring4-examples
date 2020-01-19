package org.spring.tutorial.examples.jpa;

import org.junit.Assert;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
public class UserServiceImplTest {

	@Autowired
	UserServiceImpl userService;

	@Test
	@Sql(scripts = "/db/sql/insert-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "/db/sql/delete-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void testCreateUpdate(){

		Assert.assertEquals(12, userService.getUsersCount());

		String name = "spring";
		String email = "spring@pivotal.com";
		User user = new User(99,name,email);
		userService.createUser(user);

		user = userService.findUserById(99L);
		Assert.assertEquals(99L,user.getId());
		Assert.assertEquals(name,user.getName());
		Assert.assertEquals(email,user.getEmail());

		// update data
		name+=name;
		email+=email;
		user.setName(name);
		user.setEmail(email);
		userService.updateUser(user);
		user = userService.findUserById(99L);
		Assert.assertEquals(name,user.getName());
		Assert.assertEquals(email,user.getEmail());
	}

	@Test
	@Sql(scripts = "/db/sql/insert-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "/db/sql/delete-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void testRemove(){

		Assert.assertEquals(12, userService.getUsersCount());

		User user = new User(77,"AAA","AAA@AAA.com");
		userService.createUser(user);

		userService.removeUser(user);
		user = userService.findUserById(77L);
		Assert.assertNull(user);

		userService.createUser(new User(66,"BBB","BBB@BBB.com"));
		userService.removeById(66L);
		user = userService.findUserById(66L);
		Assert.assertNull(user);
	}

	@Test
	@Sql(scripts = "/db/sql/insert-data.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(scripts = "/db/sql/delete-data.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
	public void testRetrieve(){

		Assert.assertEquals(12, userService.getUsersCount());

		Assert.assertTrue(userService.existUser(10L));
		Assert.assertFalse(userService.existUser(100L));

		User user = userService.findUserByEmail("alex@yahoo.com");
		Assert.assertEquals("alex",user.getName());
		Assert.assertEquals(2l,user.getId());

		user = userService.findUserByEmailAndName("joel@gmail.com","joel");
		Assert.assertEquals(3l,user.getId());

		user = userService.retrieveUserByItsName("mkyong4");
		Assert.assertEquals(4l,user.getId());

		user = userService.retrieveUserByItsEmail("joel6@gmail.com");
		Assert.assertEquals(6l,user.getId());

		Assert.assertEquals(12,userService.retrieveCount().intValue());

		user = userService.retrieveUserByItsIdOrEmail(1997L,"joel9@gmail.com");
		Assert.assertEquals(9l,user.getId());

		user = userService.selectUserByExample("mkyong");
		Assert.assertEquals(1l,user.getId());

		Assert.assertEquals(12,userService.getAll().size());

		// get first page
		Page<User> users = userService.getPage(0);
		Assert.assertEquals(2, users.getTotalPages());
		Assert.assertEquals(0, users.getNumber());
		Assert.assertEquals(10, users.getNumberOfElements());

		users = userService.getSortedByEmailPage(0);
		Assert.assertEquals("alex11@yahoo.com",users.getContent().get(0).getEmail());

		users = userService.getSortedByEmailPage(1);
		int lastElement = users.getContent().size() - 1;
		Assert.assertEquals("mkyong@gmail.com",users.getContent().get(lastElement).getEmail());
	}
}
