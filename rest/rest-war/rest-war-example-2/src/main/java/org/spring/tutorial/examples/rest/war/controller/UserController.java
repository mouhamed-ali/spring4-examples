package org.spring.tutorial.examples.rest.war.controller;

import org.spring.tutorial.examples.rest.war.domain.User;
import org.spring.tutorial.examples.rest.war.exception.AccesDeniedUser;
import org.spring.tutorial.examples.rest.war.exception.UserNotFoundException;
import org.spring.tutorial.examples.rest.war.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServiceImpl service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findOne(@PathVariable("id") long id) throws AccesDeniedUser {

        if (id > 0 && id < 3) {
            throw new AccesDeniedUser("access denied");
        }
        return service.findUserById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.CONFLICT)//409
    @ExceptionHandler({UserNotFoundException.class})
    /*
     * if the method generates the UserNotFoundException exception the user will receive the
     * HttpStatus.CONFLICT as status
     */
    public void delete(@PathVariable("id") Long id) throws UserNotFoundException {

        if (id > 0 && id < 3) {
            throw new UserNotFoundException("not found user");
        }
        service.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.GET)
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
