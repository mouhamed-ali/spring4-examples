package org.spring.tutorial.examples.jpa.service;

import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IUserService {

	void createUser(User user);
	User updateUser(User user);
	User findUserById(Long id);
	List<User> getAll();
	void removeById(User user);
}
