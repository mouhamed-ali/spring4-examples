package org.spring.tutorial.examples.jpa.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jpa.DefaultConfig;
import org.spring.tutorial.examples.jpa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


//TODO
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DefaultConfig.class)
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    @Sql("/db/sql/insert-data.sql")
    public void testManipulation(){
        try{
            User user = new User(
                    99,
                    "Manipulated",
                    "manipulated@manipulated.com");
            userService.manipulateHim(user, true, false);
        }catch(Exception e){} finally{
            selectAll();
        }
    }

    @Test
    @Sql("/db/sql/insert-data.sql")
    public void testUpdate(){
        try{

            User user = new User(1,"Foulen","Foulen@Foulen.com");

            //int a = userService.updateUser(user, true, false, false);
            //rollback EXECUTED

            //int a = userService.updateUser(user, false, true, false);
            //rollback NOT EXECUTED

            //int a = userService.updateUser(user, false, false, true);
            //using rollback not in rollbackFor={MyDataBaseException.class} -> rollback NOT EXECUTED

        }catch(Exception e){
        }finally{
            selectAll();
        }
    }

    @Test
    @Transactional
    /*
     * by annotating the test with @Transactionnal a rollback will be raised at the end of the test so it is
     * not necessary to go and clean the data added by the test in the BDD
     */
    public void testAnything(){}

    @Test
    @Transactional
    @Commit
    /*
     * same as the last test but this time the data will be persisted in the database
     */
    public void testAnything2(){}

    public void selectAll() {
        userService.getAll().forEach(System.out::println);
    }
}
