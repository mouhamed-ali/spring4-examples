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

	public User findUserById(long id) {
		return userDao.getUserById(id);
	}

	public List<User> getAll() {
		return userDao.findAll();
	}

	public void removeById(long id) {
		userDao.deleteById(id);
	}

	public void manipulateHim(User us, boolean generateException, boolean removeAfterCreation) {
		createUser(us);
		System.out.println("created user : "+us);
		
		User user = findUserById(us.getId());
		System.out.println("find user : "+user);
		
		user.setEmail("transaction@transaction.com");
		user.setName("transaction");
		userDao.updateUser(user);
		user = userDao.getUserById(user.getId());
		System.out.println("update user : "+user);
		
		if(generateException){
			User userToCreate = new User(user.getId(), "Anonymous", "Anonymous@Anonymous.com");
			userDao.createUser(userToCreate);
			System.out.println("created exception user : "+userToCreate);
		}
		
		if(removeAfterCreation){
			removeById(user.getId());
			System.out.println("removed user : "+user);
		}
	}

	public int createUser(User user) {
		return userDao.createUser(user);
	}

	public int updateUser(User user, boolean generateDBExc, boolean generateMyAppExc, boolean generateException) throws MyDataBaseException, MyAppException, Exception {
		int userChanged = userDao.updateUser(user);
		if(generateDBExc)
			throw new MyDataBaseException("generateDBExc");
		if(generateMyAppExc)
			throw new MyAppException("generateMyAppExc");
		if(generateException)
			throw new Exception("generateException");
		return userChanged;
	}
}
