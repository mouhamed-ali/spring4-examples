package org.spring.tutorial.examples.core;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.core.domain.User;
import org.spring.tutorial.examples.core.wrapper.PropertiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DevConfig.class, DefaultConfig.class, ProdConfig.class})
/*
 * according to the order of the declaration of config classes in annotation @ContextConfiguration
 * the profile will be selected (in our case the profile used is prod if
 * we reverse the class declaration it will be dev)
 */
@ActiveProfiles({"prod", "dev"})
public class ProdConfigTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    PropertiesWrapper properties;

    @Test
    public void testProperties() {

        properties.showProperties();
        Assert.assertEquals("production@ipAdress", properties.getPropertyValue("db.host"));
        Assert.assertEquals("prod-database", properties.getPropertyValue("db.name"));
        Assert.assertEquals("prod-user-name", properties.getPropertyValue("db.user"));
        Assert.assertEquals("prodPassword", properties.getPropertyValue("db.password"));
    }

    @Test
    public void testDatabase() {
        String sql = "SELECT * FROM users WHERE ID = ?";
        /*
         * If no database name is defined via EmbeddedDatabaseBuilder.setName(), Spring will assign a default database name testdb.
         */
        User user = (User) jdbcTemplate.queryForObject(
                sql, new Object[]{2}, new BeanPropertyRowMapper(User.class));

        Assert.assertEquals(2, user.getId());
        Assert.assertEquals("prod2", user.getName());
        Assert.assertEquals("prod2@yahoo.com", user.getEmail());
    }
}
