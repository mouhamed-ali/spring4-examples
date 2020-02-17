package org.spring.tutorial.examples.jpa.service.extra;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.spring.tutorial.examples.jpa.DefaultConfig;
import org.spring.tutorial.examples.jpa.domain.User;
import org.spring.tutorial.examples.jpa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DirtiesContext
public class DefaultBehaviorTest {

    /*
     * We will test the default behavior if we don't use @Transactional or the @Commit annotations
     * well after doing the test the default behavior is @Commit
     */

    static User toCreateUser = new User(5, "Abraham", "Lincoln");

    @Autowired
    IUserService userService;

    @Test
    @Sql("/db/sql/insert-data.sql") // this script will be rollback also
    public void aTestCreate() throws Exception {

        userService.createUser(toCreateUser, false, false);
        Assert.assertEquals(toCreateUser, userService.findUserById(5L));
    }

    @Test
    public void bTestCommit() {


        Assert.assertEquals(4, userService.getAll().size());
        Assert.assertEquals(toCreateUser, userService.findUserById(5L));
    }
}
