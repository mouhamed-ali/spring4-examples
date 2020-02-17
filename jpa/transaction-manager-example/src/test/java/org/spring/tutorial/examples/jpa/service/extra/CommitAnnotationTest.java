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
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DefaultConfig.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// this annotation is used to run tests in the order (name ascending)
@DirtiesContext
public class CommitAnnotationTest {

    static User toCreateUser = new User(5, "Abraham", "Lincoln");

    @Autowired
    IUserService userService;

    @Test
    @Sql("/db/sql/insert-data.sql") // this script will be rollback also
    @Commit
    /*
     * data will be persisted in the database after running this test
     */
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
