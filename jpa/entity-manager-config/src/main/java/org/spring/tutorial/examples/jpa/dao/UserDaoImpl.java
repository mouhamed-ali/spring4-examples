package org.spring.tutorial.examples.jpa.dao;

import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class UserDaoImpl implements IUserDao {

	private EntityManager entityManager;
	
	/*
	 * injection was used with a setter instead of autowired to facilitate unit tests
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManger(){
		return entityManager;
	}
	
	public User getUserById(long id) {
		return entityManager.find(User.class, id);
	}

	public List<User> findAll() {
		return entityManager.createQuery("select user from User user").getResultList();
	}

	public void deleteById(User user) {
		entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
	}

	public void createUser(User user) {
		entityManager.persist(user);
	}

	public User updateUser(User user) {
		return entityManager.merge(user);
	}
}
