package org.spring.tutorial.examples.security.service;

import org.spring.tutorial.examples.security.dao.ICustomerDao;
import org.spring.tutorial.examples.security.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*
 * the security of this layer methods can be done by the spring annotations or the jsr
 * if we are going to use the jsr
 * @EnableGlobalMethodSecurity (jsr250Enabled = true)
 * but in this case we will use the spring annotations
 */
@EnableGlobalMethodSecurity(securedEnabled = true)
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao userDao;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public Customer createCustomer(Customer customer) {

        return userDao.save(customer);
    }

    @Secured("ROLE_ADMIN")
    public Customer updateCustomer(Customer customer) {

        return userDao.save(customer);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public Customer findCustomerById(Long id) {

        return userDao.findOne(id);
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public List<Customer> getAll() {

        return userDao.findAll();
    }

    @Secured("ROLE_ADMIN")
    public void removeById(Long id) {
        userDao.delete(id);
    }
}
