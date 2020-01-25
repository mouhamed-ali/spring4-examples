package org.spring.tutorial.examples.security.service;

import org.spring.tutorial.examples.security.domain.Customer;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICustomerService {


    Customer createCustomer(Customer customer);

    Customer updateCustomer(Customer customer);

    Customer findCustomerById(Long id);

    List<Customer> getAll();

    void removeById(Long userId);
}
