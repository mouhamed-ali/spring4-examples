package org.spring.tutorial.examples.rest.template;

import org.spring.tutorial.examples.rest.template.api.user.UserRestApiConsumer;
import org.spring.tutorial.examples.rest.template.domain.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.util.List;

public class AppInitializer {

    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
        UserRestApiConsumer apiConsumer = (UserRestApiConsumer) context.getBean("apiConsumer");
        // the name of the bean is apiConsumer check RootConfig

        System.out.println("------------------------------------------------------ getUserById  --------------------------------------------------------------");
        User user = apiConsumer.getUserById(3L);
        Assert.notNull(user,"There is no user with id = 3");

        System.out.println("\n\n------------------------------------------------------ getAllUsers  --------------------------------------------------------------");
        List<User> users = apiConsumer.getAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n\n------------------------------------------------------ createUser  --------------------------------------------------------------");
        User newUser = new User(99, "mike", "mike@mike.com");
        HttpStatus status = apiConsumer.createUser(newUser);
        if (status.equals(HttpStatus.CREATED)) {
            System.out.println(newUser + " successfully created");
        } else {
            System.err.println("Error Code : " + status.value());
        }

        System.out.println("\n\n------------------------------------------------------ createUserSecond  --------------------------------------------------------------");
        newUser = new User(88, "maxime", "maxime@maxime.com");
        apiConsumer.createUserSecond(newUser);

        System.out.println("\n\n------------------------------------------------------ findAllUsers  --------------------------------------------------------------");
        users = apiConsumer.findAllUsers();
        users.forEach(System.out::println);

        System.out.println("\n\n------------------------------------------------------ updateUser  --------------------------------------------------------------");
        newUser = new User(99, "jeanne", "jeanne@jeanne.com");
        status = apiConsumer.updateUser(99L, newUser);
        if (status.equals(HttpStatus.NO_CONTENT)) {
            System.out.println(newUser + " successfully updated");
        } else {
            System.out.println("Error Code : " + status.value());
        }

        System.out.println("\n\n------------------------------------------------------ updateUserSecond  --------------------------------------------------------------");
        newUser = new User(88, "KingKong", "KingKong@gmail.com");
        apiConsumer.updateUserSecond(88L, newUser);

        System.out.println("\n\n------------------------------------------------------ getItInAnEasyWay  --------------------------------------------------------------");
        users = apiConsumer.getItInAnEasyWay();
        users.forEach(System.out::println);

        try {

            System.out.println("\n\n------------------------------------------------------ deleteUser  --------------------------------------------------------------");
            status = apiConsumer.deleteUser(99L);
            if (status.equals(HttpStatus.NO_CONTENT)) {
                System.out.println(newUser + " successfully deleted");
            } else {
                System.out.println("Error Code : " + status.value());
            }
        } catch (Exception e) {

            System.err.println("exception has occurred : " + e.toString());
        }

        try {

            System.out.println("\n\n------------------------------------------------------ deleteUserSecond  --------------------------------------------------------------");
            apiConsumer.deleteUserSecond(88L);
        } catch (Exception e) {

            System.err.println("exception has occurred : " + e.toString());
        }

        System.out.println("\n\n------------------------------------------------------ findAllUsers  --------------------------------------------------------------");
        users = apiConsumer.findAllUsers();
        users.forEach(System.out::println);

        context.destroy();
    }
}
