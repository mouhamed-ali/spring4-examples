package org.spring.tutorial.examples.core.dao;

import org.spring.tutorial.examples.core.domain.User;
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
			return (User) jdbcTemplate.queryForObject(
				sql, new Object[] { id }, new BeanPropertyRowMapper(User.class));
	}
	
}
