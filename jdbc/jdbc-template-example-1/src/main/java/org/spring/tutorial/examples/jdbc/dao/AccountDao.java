package org.spring.tutorial.examples.jdbc.dao;

import org.spring.tutorial.examples.jdbc.entity.Account;

import java.util.List;

public interface AccountDao extends AbstractDao<Account, Integer> {

    List<Account> getAccountsByCustomerId(Integer customerId);
}
