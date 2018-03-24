package org.spring.tutorial.examples.jpa.dao;

import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class UserDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User getUserById(long id){
		String sql = "SELECT * FROM users WHERE ID = ?";
		/*
		 * If no database name is defined via EmbeddedDatabaseBuilder.setName(), Spring will assign a default database name 'testdb'.
		 */
		return (User) jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new BeanPropertyRowMapper(User.class));
	}
	
}
