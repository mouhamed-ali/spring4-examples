package org.spring.tutorial.examples.security.dao;

import org.spring.tutorial.examples.security.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ICustomerDao extends JpaRepository<Customer, Long> {
}
