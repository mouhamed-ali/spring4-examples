package org.spring.tutorial.examples.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
@Sql("/db/sql/insert-data.sql")
public class TestService {
	

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Test
	public void test(){
		String sql = "SELECT * FROM users WHERE ID = ?";
		User a = (User) jdbcTemplate.queryForObject(
				sql, new Object[] { 1 }, new BeanPropertyRowMapper(User.class));

		System.out.println(a);
	}
}
