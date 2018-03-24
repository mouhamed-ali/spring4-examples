package org.spring.tutorial.examples.jpa.service;

import java.util.List;

import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IUserService {

	void createUser(User user);
	User updateUser(User user);
	User findUserById(long id);
	List<User> getAll();
	void removeById(User user);
}
