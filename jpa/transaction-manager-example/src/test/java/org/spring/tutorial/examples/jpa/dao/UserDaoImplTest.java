package org.spring.tutorial.examples.jpa.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jpa.DefaultConfig;
import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//TODO
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
public class UserDaoImplTest {

    @Autowired
    IUserDao userDao;

    @Before
    @Sql(
            scripts="/db/sql/insert-data.sql",
            executionPhase=ExecutionPhase.BEFORE_TEST_METHOD
    )
    public void onInit(){
        System.out.println("insert-data.sql executed");
    }

    //?? exceptions

    @Test
    public void testSelect(){
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    //@Test
    public void testSelectAll(){
        List<User> user = userDao.findAll();
        Assert.assertNotNull(user);
    }

    //@Test
    public void testDelete(){
        userDao.deleteById(2);
    }
}
