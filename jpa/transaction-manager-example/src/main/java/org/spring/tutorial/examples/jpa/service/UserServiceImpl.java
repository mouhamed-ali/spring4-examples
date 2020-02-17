package org.spring.tutorial.examples.jpa.service;

import org.spring.tutorial.examples.jpa.dao.IUserDao;
import org.spring.tutorial.examples.jpa.domain.User;
import org.spring.tutorial.examples.jpa.exceptions.MyAppException;
import org.spring.tutorial.examples.jpa.exceptions.MyDataBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public User findUserById(long id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	public void removeById(long id, boolean generateRuntimeException) {
		userDao.deleteById(id);
		if(generateRuntimeException)
			throw new RuntimeException("removeById - generateRuntimeException");
	}

	@Override
	public void removeByIdNewTransaction(long id, boolean generateRuntimeException) {

		// the userDao.deleteByIdNewTransaction will create a new transaction and stop this one which means if this method
		// generate a runtime exception the transaction (of the dao) gonna be done anyway
		userDao.deleteByIdNewTransaction(id);
		if(generateRuntimeException)
			throw new RuntimeException("removeByIdNewTransaction - generateRuntimeException");
	}

	@Override
	public int createUser(User user, boolean generateException, boolean generateRuntimeException) throws Exception{
		int rows = userDao.createUser(user);
		if(generateException)
			throw new Exception("createUser - generateException");
		if(generateRuntimeException)
			throw new RuntimeException("createUser - generateRuntimeException");
		return rows;
	}

	@Override
	public int updateUser(User user, boolean generateDBExc, boolean generateMyAppExc, boolean generateException) throws Exception {
		int userChanged = userDao.updateUser(user);
		if(generateDBExc)
			throw new MyDataBaseException("updateUser - generateDBExc");
		if(generateMyAppExc)
			throw new MyAppException("updateUser - generateMyAppExc");
		if(generateException)
			throw new Exception("updateUser - generateException");
		return userChanged;
	}
}
