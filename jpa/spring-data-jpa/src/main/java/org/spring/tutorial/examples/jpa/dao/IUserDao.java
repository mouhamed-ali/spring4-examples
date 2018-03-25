package org.spring.tutorial.examples.jpa.dao;

import javax.transaction.Transactional;

import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Transactional// you can delete this annotation (keep it if you want to manage transactions between IUserService and this class)
@Repository
public interface IUserDao extends JpaRepository<User, Long>{
	
	/*
	 *	we can also extend the CrudRepository interface but it has
	 * only the basic operations. we cannot do pagination results for example using it
	 */
	
	/*
	 * spring data will transform this method to an sql request (see hibernate logs)
	 */
	User findByEmail(String passedEmail);
	
	User findByEmailAndName(String passedEmail, String passedName);
	/*
	 * see more :
	 * http://docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/#jpa.query-methods.query-creation
	 */
	
	/*
	 * named query
	 */
	@Query("SELECT u FROM User u WHERE LOWER(u.name) = LOWER(:name)")
	User retrieveByName(@Param("name") String name);
	
	/*
	 * jpql query
	 */
	@Query(value="SELECT u FROM User u WHERE u.email = ?1",nativeQuery=false)
	User retrieveByEmail(String mail);
	
	/*
	 * native query
	 */
	@Query(value = "SELECT * FROM USERS WHERE ID = ?1 OR EMAIL = ?2", nativeQuery = true)
	User retrieveById(Long id, String email);
	
	@Query(value = "SELECT COUNT(*) FROM USERS", nativeQuery = true)
	Integer retrieveCount();
}
