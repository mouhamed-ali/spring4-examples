package org.spring.tutorial.examples.rest.war.controller;

import org.spring.tutorial.examples.rest.war.domain.User;
import org.spring.tutorial.examples.rest.war.exception.user.AccesDeniedUser;
import org.spring.tutorial.examples.rest.war.exception.user.UserNotFoundException;
import org.spring.tutorial.examples.rest.war.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    /*
        you can use apache tomcat to test the app (to run the war in the build directory [target])
        http://localhost:8080/rest-war-example-2/users
     */

    @Autowired
    UserServiceImpl service;

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") long id) throws AccesDeniedUser {

        if (id > 0 && id < 3) {
            /*
                request status will be 404 in this case
             */
            throw new AccesDeniedUser("access denied");
        }
        return service.findUserById(id);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws UserNotFoundException {

        if (id > 0 && id < 3) {
            throw new UserNotFoundException("not found user");
        }
        service.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.GET)//old school
    public List<User> findAll() {

        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)//201
    public void createCustomer(@RequestBody User user) {

        service.addUser(user);
    }

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//204
    public void update(@PathVariable("id") Long id, @RequestBody User user) {

        service.updateUser(id, user);
    }
}
