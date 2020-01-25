package org.spring.tutorial.examples.rest.war.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.tutorial.examples.rest.war.config.AppConfig;
import org.spring.tutorial.examples.rest.war.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
@DirtiesContext
public class CustomerDAOTest {

    @Autowired
    CustomerDAO customerDAO;

    @Test
    public void globalTest() {

        //test of find all
        assertThat(customerDAO.list()).size().isEqualTo(3);

        //test create entity
        Customer customer = new Customer(701, "John", "Snow", "john@gmail.com", "876-237-2987");
        customerDAO.create(customer);
        assertThat(customerDAO.list()).size().isEqualTo(4);

        //test find entity
        assertThat(customerDAO.get(customer.getId())).isEqualTo(customer);

        //test update entity
        customer.setEmail("johny@gmail.com");
        customer.setFirstName("Mike");
        assertThat(customerDAO.update(101L,customer)).isTrue();

        //test remove entity
        customerDAO.delete(201L);
        assertThat(customerDAO.list()).size().isEqualTo(3);

    }
}
