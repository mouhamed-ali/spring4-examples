package org.spring.tutorial.examples.jpa.dao;

import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserDao {

	int createUser(User user);
	int updateUser(User user);
	User getUserById(long id);
	List<User> findAll();
	@Transactional(propagation=Propagation.REQUIRED)
	/*
	 * this method is called by the method removeById in the interface IUserService which is a transactional method.
	 * Propagation.REQUIRED : this method will be executed in the transaction created by IUserService and if
	 * it is called by a non-transactional method it will create a new transaction.
	 * Propagation.REQUIRED_NEW : this method will abandon the transaction created by IUserService and create a new
	 * one.
	 * there is 5 other types of propagation see spring documentation
	 */
	void deleteById(long id);
}
