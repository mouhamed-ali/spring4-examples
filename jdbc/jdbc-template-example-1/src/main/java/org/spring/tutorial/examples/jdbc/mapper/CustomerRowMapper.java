package org.spring.tutorial.examples.jdbc.mapper;

import org.spring.tutorial.examples.jdbc.entity.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {


    @Override
    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {

        Customer customer = new Customer();
        customer.setId(resultSet.getInt("id"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPhoneNumber(resultSet.getString("phone_number"));
        customer.setBirthDate(resultSet.getString("birth_date"));
        customer.setBirthPlace(resultSet.getString("birth_place"));
        return customer;
    }
}
