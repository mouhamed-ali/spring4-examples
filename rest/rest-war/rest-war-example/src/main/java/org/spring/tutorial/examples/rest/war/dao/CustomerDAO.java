package org.spring.tutorial.examples.rest.war.dao;

import org.spring.tutorial.examples.rest.war.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CustomerDAO {

    // Dummy database. Initialize with some dummy values.
    private static List<Customer> customers;

    static {
        customers = new ArrayList<Customer>();
        customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
        customers.add(new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
        customers.add(new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
    }

    /**
     * Returns list of customers from dummy database.
     *
     * @return list of customers
     */
    public List<Customer> list() {
        return new ArrayList<>(customers);
    }

    /**
     * Return customer object for given id from dummy database. If customer is
     * not found for id, returns null.
     *
     * @param id customer id
     * @return customer object for given id
     */
    public Customer get(Long id) {

        Optional<Customer> customer = customers.stream()
                .filter(c -> Long.compare(c.getId(),id)==0)
                .findFirst();
        if(customer.isPresent())
            return customer.get();
        return null;
    }

    /**
     * Create new customer in dummy database. Updates the id and insert new
     * customer in list.
     *
     * @param customer Customer object
     * @return customer object with updated id
     */
    public Customer create(Customer customer) {
        customer.setId(System.currentTimeMillis());
        customers.add(customer);
        return get(customer.getId());
    }

    /**
     * Delete the customer object from dummy database. If customer not found for
     * given id, returns null.
     *
     * @param id the customer id
     * @return id of deleted customer object
     */
    public boolean delete(Long id) {

        return customers.removeIf(c -> Long.compare(c.getId(),id)==0);
    }

    /**
     * Update the customer object for given id in dummy database. If customer
     * not exists, returns null
     *
     * @param id
     * @param customer
     * @return customer object with id
     */
    public boolean update(Long id, Customer customer) {

        int index = customers.indexOf(get(id));
        if(index > -1){
            customers.set(index, customer);
            return true;
        }
        return false;
    }
}
