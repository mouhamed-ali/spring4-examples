package org.spring.tutorial.examples.rest.template;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.rest.template.api.user.UserRestApiConsumer;
import org.spring.tutorial.examples.rest.template.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class UserRestApiConsumerTest {

    //TODO : change system out to asserts

    @Autowired
    private UserRestApiConsumer userRest;

    @Test
    @Ignore // TODO use mocks or create a json collection of services
    public void testUserApi() {

        System.out.println("------------------------------------------------------ getUserById  --------------------------------------------------------------");
        User user = userRest.getUserById(3L);
        System.out.println(user);

        System.out.println("\n\n------------------------------------------------------ getAllUsers  --------------------------------------------------------------");
        List<User> users = userRest.getAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n\n------------------------------------------------------ findAllUsers  --------------------------------------------------------------");
        users = userRest.findAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n\n------------------------------------------------------ getItInAnEasyWay  --------------------------------------------------------------");
        users = userRest.getItInAnEasyWay();
        users.forEach(System.out::println);

        System.out.println("\n\n------------------------------------------------------ createUser  --------------------------------------------------------------");
        User newUser = new User(99, "foulen", "foulen@foulen.com");
        HttpStatus status = userRest.createUser(newUser);
        if (status.equals(HttpStatus.CREATED)) {
            System.out.println(newUser + " successfully created");
        } else {
            System.out.println("Error Code : " + status.value());
        }

        System.out.println("\n\n------------------------------------------------------ createUserSecond  --------------------------------------------------------------");
        newUser = new User(88, "maxime", "maxime@maxime.com");
        userRest.createUserSecond(newUser);

        System.out.println("\n\n------------------------------------------------------ findAllUsers  --------------------------------------------------------------");
        users = userRest.findAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n\n------------------------------------------------------ updateUser  --------------------------------------------------------------");
        newUser = new User(99, "chridigon1", "chridigon1@chridigon.com");
        status = userRest.updateUser(99L, newUser);
        if (status.equals(HttpStatus.NO_CONTENT)) {
            System.out.println(newUser + " successfully updated");
        } else {
            System.out.println("Error Code : " + status.value());
        }

        System.out.println("\n\n------------------------------------------------------ updateUserSecond  --------------------------------------------------------------");
        newUser = new User(88, "KingKong", "KingKong@gmail.com");
        userRest.updateUserSecond(88L, newUser);

        System.out.println("\n\n------------------------------------------------------ findAllUsers  --------------------------------------------------------------");
        users = userRest.findAllUsers();
        users.forEach(System.out::println);

        try {

            System.out.println("\n\n------------------------------------------------------ deleteUser  --------------------------------------------------------------");
            status = userRest.deleteUser(99L);
            if (status.equals(HttpStatus.NO_CONTENT)) {
                System.out.println(newUser + " successfully deleted");
            } else {
                System.out.println("Error Code : " + status.value());
            }
        } catch (Exception e) {

            //TODO : the rest service returns 409 all the time even if the user was deleted, check the rest service
            System.out.println("exception : " + e.toString());
        }

        try {

            System.out.println("\n\n------------------------------------------------------ deleteUserSecond  --------------------------------------------------------------");
            userRest.deleteUserSecond(88L);
        } catch (Exception e) {

            //TODO : the rest service returns 409 all the time even if the user was deleted, check the rest service
            System.out.println("exception : " + e.toString());
        }

        System.out.println("\n\n------------------------------------------------------ findAllUsers  --------------------------------------------------------------");
        users = userRest.findAllUsers();
        for (User u : users) {
            System.out.println(u);
        }
    }
}
