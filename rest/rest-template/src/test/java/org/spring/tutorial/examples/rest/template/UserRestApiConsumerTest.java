package org.spring.tutorial.examples.rest.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.rest.template.domain.User;
import org.spring.tutorial.examples.rest.template.user.api.UserRestApiConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserRestApiConsumerTest {

    @Autowired
    private UserRestApiConsumer userRest;

    @Test
    public void testUserApi() {

        System.out.println("------------------ getUserById  --------------------------");
        User user = userRest.getUserById(3L);
        System.out.println(user);

        System.out.println("\n------------------ getAllUsers  --------------------------");
        List<User> users = userRest.getAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n------------------ findAllUsers  --------------------------");
        users = userRest.findAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n------------------ createUser  --------------------------");
        User newUser = new User(99, "foulen", "foulen@foulen.com");
        HttpStatus status = userRest.createUser(newUser);
        if (status.equals(HttpStatus.CREATED)) {
            System.out.println(newUser + " successfully created");
        } else {
            System.out.println("Error Code : " + status.value());
        }

        System.out.println("\n------------------ findAllUsers  --------------------------");
        users = userRest.findAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n------------------ updateUser  --------------------------");
        newUser = new User(99, "chridigon1", "chridigon1@chridigon.com");
        status = userRest.updateUser(99L, newUser);
        if (status.equals(HttpStatus.NO_CONTENT)) {
            System.out.println(newUser + " successfully updated");
        } else {
            System.out.println("Error Code : " + status.value());
        }

        System.out.println("\n------------------ findAllUsers  --------------------------");
        users = userRest.findAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n------------------ deleteUser  --------------------------");
        status = userRest.deleteUser(99L);
        if (status.equals(HttpStatus.NO_CONTENT)) {
            System.out.println(newUser + " successfully deleted");
        } else {
            System.out.println("Error Code : " + status.value());
        }

        System.out.println("\n------------------ findAllUsers  --------------------------");
        users = userRest.findAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
