package org.spring.tutorial.examples.jdbc.dao.impl;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.jdbc.ApplicationConfig;
import org.spring.tutorial.examples.jdbc.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class CustomerDaoImplTest {

    @Autowired
    CustomerDaoImpl customerDao;

    @Test
    public void testGetByNationality() {

        Customer customer = customerDao.getCustomersByNationality("BL");
        Assert.assertNull(customer);
    }

    @Test
    public void testAddCustomer() {

        int updatedRows = customerDao.addCustomer();
        Assert.assertEquals(1,updatedRows);
    }
}
