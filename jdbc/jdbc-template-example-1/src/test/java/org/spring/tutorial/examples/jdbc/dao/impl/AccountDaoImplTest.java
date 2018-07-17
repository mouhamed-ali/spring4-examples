package org.spring.tutorial.examples.jdbc.dao.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jdbc.ApplicationConfig;
import org.spring.tutorial.examples.jdbc.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AccountDaoImplTest {

    @Autowired
    AccountDaoImpl accountDao;

    @Test
    public void testFindByCustomerId() {

        List<Account> accounts = accountDao.getAccountsByCustomerId(1);
        accounts.forEach(System.out::println);
    }

    @Test
    public void testFindById() {

        Account account = accountDao.findById(21);
        System.out.println(account);
    }
}
