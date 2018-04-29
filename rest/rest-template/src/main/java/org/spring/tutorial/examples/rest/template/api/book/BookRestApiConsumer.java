package org.spring.tutorial.examples.rest.template.api.book;

import org.spring.tutorial.examples.rest.template.domain.Book;
import org.spring.tutorial.examples.rest.template.domain.User;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

public class BookRestApiConsumer {

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    private static void listAllUsers() {
        System.out.println("Testing listAllUsers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(REST_SERVICE_URI + "/user/", List.class);

        if (usersMap != null) {
            for (LinkedHashMap<String, Object> map : usersMap) {
                System.out.println("User : ID=" + map.get("id") + ", Login=" + map.get("login") + ", Password=" + map.get("password"));
            }
        } else {
            System.out.println("No user exist ----------");
        }
    }

    /* GET */
    private static void getUser() {
        System.out.println("Testing getUser API----------");
        RestTemplate restTemplate = new RestTemplate();
        Book book = restTemplate.getForObject(REST_SERVICE_URI + "/user/1", Book.class);
        System.out.println(book);
    }

    /* POST */
    private static void createUser() {
        System.out.println("Testing create User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Book user = new Book("Sarah", "Sarah2017");
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/user/", user, User.class);
        System.out.println("Location : " + uri.toASCIIString());
    }

    /* PUT */
    private static void updateUser() {
        System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        User user = new User(134, "Tomy", "Tomy2014");
        restTemplate.put(REST_SERVICE_URI + "/user/1", user);
        System.out.println(user);
    }

    /* DELETE */
    private static void deleteUser() {
        System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/user/4");
    }

    /* DELETE */
    private static void deleteAllUsers() {
        System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/user/");
    }
}
