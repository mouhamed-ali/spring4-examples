package org.spring.tutorial.examples.secutity.service;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.security.RootConfig;
import org.spring.tutorial.examples.security.domain.User;
import org.spring.tutorial.examples.security.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    @Ignore
    // TODO resolve the dependencies problems of this project check https://docs.spring.io/platform/docs/Brussels-SR9/reference/html/appendix-dependency-versions.html
    public void testCreate() {

        //TODO add junit (or spring aspectj) asserts
        System.out.println("--------------- test create ---------------");
        userService.createUser(new User(99, "AAA", "AAA@AAA.com"));

        System.out.println("--------------- test find ---------------");
        User user = userService.findUserById(99L);
        System.out.println(user);

        System.out.println("--------------- test update ---------------");
        user.setEmail("BBB@BBB.com");
        user.setName("BBB");
        user = userService.updateUser(user);

        System.out.println("--------------- test get All ---------------");
        showUsers(userService.getAll());

        System.out.println("--------------- test remove user by id ---------------");
        userService.removeById(99L);

        System.out.println("--------------- test get All ---------------");
        showUsers(userService.getAll());
    }

    public void showUsers(List<User> list) {
        list.forEach(System.out::println);
    }
}
