package org.spring.tutorial.examples.jdbc.dao.impl;


import org.junit.Assert;
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
    public void testFindAll() {

        List<Account> accounts = accountDao.findAll();
        Assert.assertEquals(5,accounts.size());
    }

    @Test
    public void testFindById() {

        Account account = accountDao.findById(21);
        Assert.assertEquals(21l,account.getId().longValue());
        Assert.assertEquals("223.5", account.getBalance().toString());
        Assert.assertEquals("account21", account.getAccountName());
        Assert.assertEquals("08/08/2018", account.getDateOpened());
        Assert.assertEquals(1l, account.getCustomerId().longValue());
    }
}
