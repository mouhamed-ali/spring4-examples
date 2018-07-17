package org.spring.tutorial.examples.jdbc.dao.impl;

import org.spring.tutorial.examples.jdbc.dao.AccountDao;
import org.spring.tutorial.examples.jdbc.entity.Account;
import org.spring.tutorial.examples.jdbc.mapper.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Account findById(Integer id) {

        String query = "SELECT * FROM account WHERE id = ?";
        Account account = jdbcTemplate.queryForObject(
                query, new Object[]{id}, new AccountRowMapper());
        /*
         * In JdbcTemplate , queryForInt, queryForLong, queryForObject all such methods expects that executed query will return one and only one row.
         */
        return account;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public List<Account> getAccountsByCustomerId(Integer customerId) {

        String query = "SELECT * FROM account WHERE customer_id = ?";
        List<Account> accounts = jdbcTemplate.query(
                query, new Object[]{customerId}, new AccountRowMapper());
        return accounts;
    }
}
