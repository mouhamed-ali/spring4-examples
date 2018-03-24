package org.spring.tutorial.examples.junit.dao;

import java.util.List;

import org.spring.tutorial.examples.junit.domain.User;
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
	
	public List<User> findAll(){
		String sql = "SELECT * FROM users";
		List<User> users  = jdbcTemplate.query(sql,new BeanPropertyRowMapper(User.class));

		return users;
	}
	
	public void deleteById(long id) {
		
		String deleteStatement = "DELETE FROM users WHERE id=?";
		jdbcTemplate.update(deleteStatement, id);
	}
}
