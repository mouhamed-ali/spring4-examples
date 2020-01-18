package org.spring.tutorial.examples.jpa;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jpa.domain.User;
import org.spring.tutorial.examples.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
public class UserServiceImplTest {

	@Autowired
	IUserService userService;

	@Test
	public void testFindAll(){

		int nbUsers = userService.getAll().size();
		Assert.assertEquals(3,nbUsers);
	}

	@Test
	public void testGetById(){

		User user = userService.findUserById(1);
		Assert.assertEquals(1,user.getId());
		Assert.assertEquals("mkyong",user.getName());
		Assert.assertEquals("mkyong@gmail.com",user.getEmail());
	}

	@Test
	public void testCreateUpdateDelete(){

		User user = new User(99,"pikatchu","pikatchu@gmail.com");
		userService.createUser(user);

		user = userService.findUserById(99);
		Assert.assertNotNull(user);


		String name = "bill";
		String email = "bill@yahoo.com";
		user.setName(name);
		user.setEmail(email);
		userService.updateUser(user);

		user = userService.findUserById(99);
		Assert.assertNotNull(user);
		Assert.assertEquals(name,user.getName());
		Assert.assertEquals(email,user.getEmail());

		userService.removeById(user);
		user = userService.findUserById(99);
		Assert.assertNull(user);
	}
}
