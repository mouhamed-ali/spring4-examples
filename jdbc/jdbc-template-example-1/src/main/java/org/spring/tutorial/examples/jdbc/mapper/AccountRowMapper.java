package org.spring.tutorial.examples.jdbc.mapper;

import org.spring.tutorial.examples.jdbc.entity.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {


    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {

        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setAccountName(resultSet.getString("account_name"));
        account.setBalance(resultSet.getDouble("balance"));
        account.setDateOpened(resultSet.getString("date_opened"));
        account.setCustomerId(resultSet.getInt("customer_id"));
        return account;
    }
}
