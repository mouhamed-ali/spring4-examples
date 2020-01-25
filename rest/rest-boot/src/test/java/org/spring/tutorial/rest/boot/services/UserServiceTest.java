package org.spring.tutorial.rest.boot.services;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.rest.boot.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    public void globalTest(){

        Assertions.assertThat(userService).isNotNull();

        // Test find all
        Assertions.assertThat(userService.findAllUsers().size()).isEqualTo(5);

        // Test exist
        Assertions.assertThat(userService.isUserExist(new User(1, "user 1", "password 1"))).isTrue();

        // Test create
        User user = new User(99, "user", "password");
        userService.saveUser(user);
        Assertions.assertThat(userService.findById(99)).isEqualTo(user);

        // Test update
        User toUpdate = new User(88,"updated", "password");
        userService.updateUser(99, toUpdate);
        Assertions.assertThat(userService.findById(88)).isEqualTo(toUpdate);
        Assertions.assertThat(userService.findById(99)).isNull();

        // Test delete
        userService.deleteUserById(99);
        Assertions.assertThat(userService.findById(99)).isNull();

        // Test delete all
        userService.deleteAllUsers();
        Assertions.assertThat(userService.findAllUsers().size()).isEqualTo(0);
    }
}
