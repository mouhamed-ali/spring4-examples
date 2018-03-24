package org.spring.tutorial.examples.jpa.dao;


import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IUserDao {

	void createUser(User user);
	User updateUser(User user);
	User getUserById(long userId);
	List<User> findAll();
	void deleteById(User user);
}
