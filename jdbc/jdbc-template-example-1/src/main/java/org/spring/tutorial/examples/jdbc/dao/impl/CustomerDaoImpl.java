package org.spring.tutorial.examples.jdbc.dao.impl;

import org.spring.tutorial.examples.jdbc.dao.CustomerDao;
import org.spring.tutorial.examples.jdbc.entity.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer findById(Integer integer) {

        return null;
    }

    @Override
    public List<Customer> findAll() {

        throw new RuntimeException("not yet implemented");
    }
}
