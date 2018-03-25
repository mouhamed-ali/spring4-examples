package org.spring.tutorial.examples.jpa.service;

import java.util.List;

import org.spring.tutorial.examples.jpa.dao.IUserDao;
import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl{

	@Autowired
	private IUserDao userDao;
	
	private static final Integer PAGE_SIZE = 10;
	
	public User findUserById(Long userId) {
		/*
		 * we can also use the method userDao.getOne (userId); it does the same treatment. the difference is that
		 * The getOne method is a JpaRepository method so it is a specific jpa but
		 * findOne is a crudRepository method. more generic (used for MongoDB for example)
		 */
		return userDao.findOne(userId);
	}

	public User findUserByEmail(String mail) {
		return userDao.findByEmail(mail);
	}
	
	public User findUserByEmailEtName(String mail,String name) {
		return userDao.findByEmailAndName(mail,name);
	}
	
	public User retrieveUserByItsEmail(String name) {
		return userDao.retrieveByEmail(name);
	}
	
	public User retrieveUserByItsName(String name) {
		return userDao.retrieveByName(name);
	}
	
	public Integer retrieveCount() {
		return userDao.retrieveCount();
	}
	
	public User retrieveUserByItsId(Long id, String mail) {
		return userDao.retrieveById(id,mail);
	}
	
	public List<User> getAll() {
		return userDao.findAll();
	}
	
	public Page<User> getPage(Integer pageIdentifier) {
		/*
		 * this method is inherited from the PagingAndSortingRepository interface
		 */
		PageRequest request = new PageRequest(pageIdentifier, PAGE_SIZE);
		return userDao.findAll(request);
	}
	
	public Page<User> getSortedByEmailPage(Integer pageIdentifier) {
		/*
		 * this method is inherited from the PagingAndSortingRepository interface
		 * allows to return ordered pages by ascending email
		 */
		PageRequest request = new PageRequest(pageIdentifier, PAGE_SIZE, Sort.Direction.ASC,"email");
		return userDao.findAll(request);
	}

	public void removeById(Long userId) {
		userDao.delete(userId);
	}
	
	public void removeUser(User user) {
		userDao.delete(user);
	}
	
	public long getUsersCount() {
		return userDao.count();
	}

	public User createUser(User user) {
		/*
		 * we can use saveAndFlush. difference ;
		 * On saveAndFlush, changes will be flushed to DB immediately in this command. 
		 * With save, this is not necessarily true, and might stay just in memory, until flush or commit commands are issued.
		 * if we use saveAndFlush in a transaction. it will be stopped.
		 */
		return userDao.save(user);
	}

	public User updateUser(User user){
		/*
		 * save used also to update entities
		 */
		return userDao.save(user);
	}
	
	public boolean existUser(Long id) {
		return userDao.exists(id);
	}
	
	public void commit() {
		userDao.flush();
	}
	
	public User selectUserByExample() {
		/*
		 * we will use here the queryExample matching of spring its like in hibernate we create an example object
		 * and we try to select objects that looks like it in the database
		 */
		User person = new User();                          
		person.setName("mkyong");
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("email").withIncludeNullValues();
		Example<User> example = Example.of(person, matcher);
		return userDao.findOne(example);
	}
}
