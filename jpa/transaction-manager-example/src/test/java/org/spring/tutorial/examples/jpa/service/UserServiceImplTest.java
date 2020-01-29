package org.spring.tutorial.examples.jpa.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jpa.DefaultConfig;
import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= DefaultConfig.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    /*
     * ----------------------------------------------------------------------------------
     *  CREATE ENTITY TESTS
     * ----------------------------------------------------------------------------------
     */
    /*
     * the create method is transactional which means if we have an error it will be rolled back
     * let's test this behavior
     */
    @Test
    @Sql(scripts = "/db/sql/delete-data.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testCreateWithoutRollback() throws Exception{

        User toCreateUser = new User(1,"John","snow@gmail.com");
        int rows = userService.createUser(toCreateUser,false, false);
        Assert.assertEquals(1,rows);
        Assert.assertEquals(toCreateUser, userService.findUserById(1L));

        toCreateUser = new User(2,"John","johny@gmail.com");
        try {

            userService.createUser(toCreateUser,true, false);
        }catch (Exception e){

            Assert.assertEquals(toCreateUser, userService.findUserById(2L));
        }
    }

    @Test
    @Sql(scripts = "/db/sql/delete-data.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testCreateWithRollback() {

        User toCreateUser = new User(1,"John","snow@gmail.com");
        try {

            userService.createUser(toCreateUser,false, true);
        }catch (Exception e){

            Assert.assertEquals(null, userService.findUserById(1L));
        }
    }

    /*
     * ----------------------------------------------------------------------------------
     *  UPDATE ENTITY TESTS
     * ----------------------------------------------------------------------------------
     */
    /*
     * as we can see in service interface IUserService the update method
     * will be rolled back if a MyDataBaseException is thrown
     * and we will not have a rollback if a MyAppException is thrown
     */
    @Test
    @Sql("/db/sql/insert-data.sql")
    @Sql(scripts = "/db/sql/delete-data.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdateWithRollback(){

        User originalUser = userService.findUserById(1L);

        // we will modify the first user 'mkyong'
        User toUpdateUser = new User(1,"Abraham","Lincoln");
        try{

            userService.updateUser(toUpdateUser, true, false, false);
        }catch(Exception e){

            Assert.assertEquals(originalUser, userService.findUserById(1L));
        }

        // And if we generate an Exception --> there is no rollback, check the next test
    }

    @Test
    @Sql("/db/sql/insert-data.sql")
    @Sql(scripts = "/db/sql/delete-data.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testUpdateWithoutRollback(){

        // we will try to modify the first user 'mkyong'
        User toUpdateUser = new User(1,"Abraham","Lincoln");
        try{

            userService.updateUser(toUpdateUser, false, true, false);
        }catch(Exception e){

            Assert.assertEquals(toUpdateUser, userService.findUserById(1L));
        }

        // generate exception
        toUpdateUser = new User(2,"Abraham","Lincoln");
        try{

            userService.updateUser(toUpdateUser, false, false, true);
        }catch(Exception e){
            Assert.assertEquals(toUpdateUser, userService.findUserById(2L));
        }
    }

    /*
     * ----------------------------------------------------------------------------------
     *  GET ALL TEST
     * ----------------------------------------------------------------------------------
     */
    @Test
    @Sql("/db/sql/insert-data.sql")
    @Sql(scripts = "/db/sql/delete-data.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testGetAll(){

        List<User> list = Arrays.asList(
                new User(1,"mkyong","mkyong@gmail.com"),
                new User(2,"alex","alex@yahoo.com"),
                new User(3,"joel","joel@gmail.com")
        );
        List<User> dbList = userService.getAll();
        Assert.assertEquals(list,dbList);
    }

    /*
     * ----------------------------------------------------------------------------------
     *  DELETE ENTITY TESTS
     * ----------------------------------------------------------------------------------
     */
    // the removeById uses the Propagation.REQUIRED annotation which means that the transaction will continue which means if an exception will be thrown
    // we gonna rollback the transaction
    @Test
    @Sql("/db/sql/insert-data.sql")
    @Sql(scripts = "/db/sql/delete-data.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testDeleteWithtRollback(){

        User toDeleteUser = userService.findUserById(1L);
        try {

            userService.removeById(1L,true);
        }catch (Exception e){

            Assert.assertEquals(toDeleteUser, userService.findUserById(1L));
        }
    }

    // the removeById uses the Propagation.REQUIRES_NEW (check the IUserDao interface) annotation which means that we will create a new transaction which means if an exception will be thrown
    // in the service layer we gonna continue the transaction of the dao because it is isolated
    @Test
    @Sql("/db/sql/insert-data.sql")
    @Sql(scripts = "/db/sql/delete-data.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testDeleteWithoutRollback(){

        try {

            userService.removeByIdNewTransaction(1L,true);
        }catch (Exception e){

            Assert.assertEquals(null, userService.findUserById(1L));
        }
    }
}
