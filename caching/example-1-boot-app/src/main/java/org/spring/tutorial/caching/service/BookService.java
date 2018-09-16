package org.spring.tutorial.caching.service;

import org.spring.tutorial.caching.entities.Book;

public interface BookService {

    Book getBookByIsbn(String isbn);
}
