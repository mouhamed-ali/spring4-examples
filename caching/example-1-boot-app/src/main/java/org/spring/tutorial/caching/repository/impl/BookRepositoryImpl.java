package org.spring.tutorial.caching.repository.impl;

import org.spring.tutorial.caching.entities.Book;
import org.spring.tutorial.caching.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryImpl implements BookRepository {

    public Book getByIsbn(String isbn) {
        //in a real project, this method will retrieve data from a database
        simulateSlowService();
        return new Book(isbn, "Some book");
    }

    // Don't do this at home
    protected void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
