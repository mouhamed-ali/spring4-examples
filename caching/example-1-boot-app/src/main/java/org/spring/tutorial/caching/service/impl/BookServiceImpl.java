package org.spring.tutorial.caching.service.impl;

import org.spring.tutorial.caching.entities.Book;
import org.spring.tutorial.caching.repository.BookRepository;
import org.spring.tutorial.caching.service.BookService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Cacheable("books")//the cache name is books
    @Override
    public Book getBookByIsbn(String isbn) {

        //the first call (with new parameter) will always use the repo interface
        return bookRepository.getByIsbn(isbn);
    }
}
