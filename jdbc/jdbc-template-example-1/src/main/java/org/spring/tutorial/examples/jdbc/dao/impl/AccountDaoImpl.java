package org.spring.tutorial.examples.jdbc.dao.impl;

import org.spring.tutorial.examples.jdbc.dao.AccountDao;
import org.spring.tutorial.examples.jdbc.entity.Account;
import org.spring.tutorial.examples.jdbc.mapper.AccountRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    // jdbc template injection
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

        String sql = "SELECT * FROM account";

        List<Account> accounts = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Account account = new Account();
            account.setId((Integer)row.get("id"));
            account.setAccountName((String)row.get("account_name"));
            account.setBalance((Double)row.get("balance"));
            account.setDateOpened((String)row.get("date_opened"));
            account.setCustomerId((Integer)row.get("customer_id"));
            accounts.add(account);
        }

        return accounts;
    }
}
