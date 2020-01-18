package org.spring.tutorial.examples.jdbc.dao.impl;

import org.spring.tutorial.examples.jdbc.dao.CustomerDao;
import org.spring.tutorial.examples.jdbc.entity.Customer;
import org.spring.tutorial.examples.jdbc.mapper.CustomerRowMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    private JdbcTemplate jdbcTemplate;

    public CustomerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Customer getCustomersByNationality(String nationality) {

        try {
            String query = "SELECT * FROM CUSTOMER WHERE BIRTH_PLACE = ?";
            return jdbcTemplate.queryForObject(query, new Object[]{nationality}, new CustomerRowMapper());
        }catch (EmptyResultDataAccessException ex){
            return null;
        }
    }


    @Override
    public int addCustomer() {
        return jdbcTemplate.update(
                "INSERT INTO customer VALUES (99, 'spring', 'jdbc', 'jdbc@gmail.com', '+33 6 xx xx xx xx' , '11/11/2011', 'France')"
        );
    }
}
