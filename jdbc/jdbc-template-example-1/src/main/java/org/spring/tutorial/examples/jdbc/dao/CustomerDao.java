package org.spring.tutorial.examples.jdbc.dao;

import org.spring.tutorial.examples.jdbc.entity.Customer;

public interface CustomerDao {

    Customer getCustomersByNationality(String customerName);

    int addCustomer();
}
