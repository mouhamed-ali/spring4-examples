package org.spring.tutorial.examples.rest.template.api.user;

import org.spring.tutorial.examples.rest.template.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class UserRestApiConsumer {

    // we gonna use the rest api of the project named rest-war-example-2
    private static final String USER_URI = "http://localhost:8080/rest-war-example-2/users/";

    @Autowired
    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /*
        GET
     */
    public User getUserById(Long id) {

        return restTemplate.getForObject(USER_URI + id, User.class);
    }

    /*
        POST
     */
    public HttpStatus createUser(User user) {

        /*
         * restTemplate.***ForObject methods returns domain objects (entities of our application)
         * restTemplate.***ForEntity methods returns the Http response
         */
        ResponseEntity<User> response = restTemplate.postForEntity(USER_URI, user, User.class);
        return response.getStatusCode();
    }

    /*
        POST
     */
    public void createUserSecond(User user) {

        restTemplate.postForLocation(USER_URI, user, User.class);
    }

    /*
        PUT
     */
    public HttpStatus updateUser(Long id, User user) {

        User requestBody = user;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> entity = new HttpEntity<>(requestBody, headers);//construction of the body of the http request
        ResponseEntity<?> response = restTemplate.exchange(USER_URI + "/{id}", HttpMethod.PUT, entity, Object.class, id);
        return response.getStatusCode();
        /*
         * another example of using the exchange method:
         * ResponseEntity<byte[]> result =
         * restTemplate.exchange("http://localhost:7070/spring-rest-provider/krams/person/{id}", HttpMethod.GET, entity, byte[].class, id);
         * A GET request will be performed to the given URL sending the HTTP headers that are wrapped in the HttpEntity instance.
         * Since the the URL contains a template variable ({id}), it will be replaced with the value given in the last method parameter (id).
         * The response entity will be returned​ as a byte[] wrapped into a ResponseEntity instance.
         * in our case we are not interested in the body of the request that's why we used the ResponseEntity <?> and Object.class
         */
    }

    /*
        PUT
     */
    public void updateUserSecond(Long id, User user) {

        restTemplate.put(USER_URI + "/{id}", user, id);
    }

    /*
        DELETE
     */
    public HttpStatus deleteUser(Long id) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<Object>(headers);//send an empty body
        ResponseEntity<?> response = restTemplate.exchange(USER_URI + "/{id}", HttpMethod.DELETE, null, String.class, id);
        return response.getStatusCode();
    }

    /*
        DELETE
     */
    public void deleteUserSecond(Long id) {

        restTemplate.delete(USER_URI + "/{id}", id);
    }

    /*
        GET
     */
    public List<User> getAllUsers() {

        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(USER_URI, Object[].class);
        /*
         * Response Entity : Represents an HTTP request or response entity,
         * consisting of headers and body.
         */
        Object[] objects = responseEntity.getBody();
        /*
         * the list of returned objects are of type linkedHashMap we will do the cast to retrieve all users
         */
        LinkedHashMap<String, Object> hashMapUsers;
        List<User> users = new ArrayList<>();
        Integer id;
        String name;
        String email;
        User user;
        for (Object obj : objects) {
            hashMapUsers = (LinkedHashMap<String, Object>) obj;
            id = (Integer) hashMapUsers.get("id");
            name = (String) hashMapUsers.get("name");
            email = (String) hashMapUsers.get("email");
            user = new User(id, name, email);
            users.add(user);
        }
        return users;
        //we can also use the method below its the same thing
    }

    /*
        GET
     */
    public List<User> findAllUsers() {

        List<User> users = new ArrayList<User>();
        Integer id;
        String name;
        String email;
        User user;

        List<LinkedHashMap<String, Object>> usersMap = restTemplate.getForObject(USER_URI, List.class);
        if (usersMap != null) {
            for (LinkedHashMap<String, Object> map : usersMap) {

                id = (Integer) map.get("id");
                //problem : the type of the id field is long and not Integer. but the cast fails if we use long or Long
                name = (String) map.get("name");
                email = (String) map.get("email");
                user = new User(id, name, email);
                users.add(user);
            }
        } else {
            return null;
        }
        return users;
    }

    /*
           GET
    */
    public List<User> getItInAnEasyWay() {

        ResponseEntity<List<User>> usersResponse = restTemplate.exchange(
                USER_URI,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        if (usersResponse != null && usersResponse.hasBody()) {
            return usersResponse.getBody();
        }
        return null;
    }
}
