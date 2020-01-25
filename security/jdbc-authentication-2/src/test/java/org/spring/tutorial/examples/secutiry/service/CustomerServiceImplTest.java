package org.spring.tutorial.examples.secutiry.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.security.RootConfig;
import org.spring.tutorial.examples.security.domain.Customer;
import org.spring.tutorial.examples.security.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class CustomerServiceImplTest {

    @Autowired
    ICustomerService customerService;

    @Test
    @WithMockUser
    public void testGetAll(){

        Assert.assertNotNull(customerService.getAll());
    }

    @Test
    @WithMockUser
    public void testCreateFind(){

        Customer customer = new Customer(55, "Kia", "Asia");
        customerService.createCustomer(customer);
        Assert.assertEquals(customer,customerService.findCustomerById(55L));
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void testCreateFindAdmin(){

        Customer customer = new Customer(66, "Kia", "Asia");
        customerService.createCustomer(customer);
        Assert.assertEquals(customer,customerService.findCustomerById(66L));
    }

    @Test(expected= AccessDeniedException.class)
    @WithMockUser
    public void testUpdateException(){

        customerService.updateCustomer(new Customer());
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void testUpdate(){


        Customer customer = new Customer(99, "Toyota", "Asia");
        customerService.updateCustomer(customer);
        Assert.assertEquals(customer,customerService.findCustomerById(99L));
    }


    @Test(expected= AccessDeniedException.class)
    @WithMockUser
    public void testDeleteException(){

        customerService.removeById(1L);
    }

    @Test
    @WithMockUser(username="admin",roles={"USER","ADMIN"})
    public void testDelete(){

        customerService.removeById(1L);
    }
}
