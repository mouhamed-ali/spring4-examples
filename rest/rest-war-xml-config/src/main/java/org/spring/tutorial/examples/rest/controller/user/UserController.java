package org.spring.tutorial.examples.rest.controller.user;

import java.util.List;
import org.spring.tutorial.examples.rest.domain.User;
import org.spring.tutorial.examples.rest.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/users/") already mapped in web xml
class UserController {

	/*
	 * use postman to test the app
	 */
	
	@Autowired
	UserServiceImpl service;

	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll() {
		
		return service.findAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)// return 200
	public User findOne(@PathVariable("id") Long id) {

		return service.findUserById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)//201
	//the body of this answer is empty
	public void createCustomer(@RequestBody User user /* mapping the body of the request to a User java object */) {

		service.addUser(user);
	}

	@PutMapping(path = "/{id}")//for the mapping we use the property path or value its the same thing
	@ResponseStatus(HttpStatus.NO_CONTENT)//204
	public void update(@PathVariable("id") Long id, @RequestBody User user) {

		service.updateUser(id, user);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)//204
	public void delete(@PathVariable("id") Long id) {
		
		service.deleteUser(id);
	}
}
