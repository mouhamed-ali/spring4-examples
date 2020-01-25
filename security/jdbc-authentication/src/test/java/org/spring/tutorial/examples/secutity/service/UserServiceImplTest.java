package org.spring.tutorial.examples.secutity.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.security.RootConfig;
import org.spring.tutorial.examples.security.domain.User;
import org.spring.tutorial.examples.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    @DirtiesContext
    public void testGlobal() {

        //test of the insert-data.sql
        Assert.assertEquals(userService.getAll().size(),3);

        //test create entity
        User user = new User(99, "gerard", "gerard@gmail.com");
        userService.createUser(user);
        Assert.assertEquals(userService.getAll().size(),4);

        //test find entity
        Assert.assertEquals(userService.findUserById(99L),user);

        //test update entity
        user.setEmail("mike@gmail.com");
        user.setName("mike");
        Assert.assertEquals(userService.updateUser(user),new User(99L, "mike", "mike@gmail.com"));

        //test remove entity
        userService.removeById(99L);
        Assert.assertEquals(userService.getAll().size(),3);
        Assert.assertNull(userService.findUserById(99L));
    }
}
