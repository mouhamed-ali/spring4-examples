package org.spring.tutorial.examples.jpa.service;

import java.util.List;

import org.spring.tutorial.examples.jpa.dao.IUserDao;
import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	public User findUserById(long userId) {
		return userDao.getUserById(userId);
	}

	public List<User> getAll() {
		return userDao.findAll();
	}

	public void removeById(User user) {
		userDao.deleteById(user);
	}

	public void createUser(User user) {
		userDao.createUser(user);
	}

	public User updateUser(User user){
		return userDao.updateUser(user);
	}
}
