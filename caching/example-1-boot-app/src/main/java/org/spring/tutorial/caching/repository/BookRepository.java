package org.spring.tutorial.caching.repository;

import org.spring.tutorial.caching.entities.Book;

public interface BookRepository {

    Book getByIsbn(String isbn);
}
