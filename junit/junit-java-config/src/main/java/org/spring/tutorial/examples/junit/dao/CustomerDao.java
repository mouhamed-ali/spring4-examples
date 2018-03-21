package org.spring.tutorial.examples.junit.dao;


import org.spring.tutorial.examples.junit.entities.Customer;

public interface CustomerDao {

	Customer findById(Long id);
}
