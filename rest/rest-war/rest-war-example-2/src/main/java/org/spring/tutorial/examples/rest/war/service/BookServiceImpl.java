package org.spring.tutorial.examples.rest.war.service;

import org.spring.tutorial.examples.rest.war.domain.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl {

    private List<Book> books;

    public BookServiceImpl(){
        this.init();
    }

    public void init() {

        books = new ArrayList<>(
                Arrays.asList(
                        new Book(1, "Veronika decide de mourir", "Coelho"),
                        new Book(2, "Les miserables", "Hugo"),
                        new Book(3, "Notre damme de paris", "Hugo"),
                        new Book(4, "Oliver Twist", "Dickens"),
                        new Book(5, "David Cooperfild", "Dickens")
                )
        );
    }

    public Book addBook(Book Book) {

        books.add(Book);
        return Book;
    }

    public Book updateBook(Integer id, Book Book) {

        books.remove(findBookById(id));
        return addBook(Book);
    }

    public List<Book> findAll() {

        return books;
    }

    public boolean deleteBookByName(String name) {

        return books.removeIf(book -> book.getName().equals(name));
    }

    public boolean deleteBookById(Integer id) {

        return books.removeIf(book -> book.getId().equals(id));
    }

    public Book findBookById(Integer id) {

        Optional<Book> book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
        if(book.isPresent()) return book.get();
        return null;
    }

    public Book findBookByName(String name) {

        Optional<Book> book = books.stream()
                .filter(b -> b.getName().equals(name))
                .findFirst();
        if(book.isPresent()) return book.get();
        return null;
    }

}
