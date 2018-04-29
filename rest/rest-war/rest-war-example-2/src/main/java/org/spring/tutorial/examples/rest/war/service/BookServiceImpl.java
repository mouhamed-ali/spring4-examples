package org.spring.tutorial.examples.rest.war.service;

import org.spring.tutorial.examples.rest.war.domain.Book;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl {

    private List<Book> books;

    @PostConstruct
    public void init() {

        books = new ArrayList<Book>();
        books.add(new Book("Veronika decide de mourir", "Coelho"));
        books.add(new Book("Les miserables", "Hugo"));
        books.add(new Book("Notre damme de paris", "Hugo"));
        books.add(new Book("Oliver Twist", "Dickens"));
        books.add(new Book("David Cooperfild", "Dickens"));
    }

    public Book addBook(Book Book) {

        books.add(Book);
        return Book;
    }

    public Book updateBook(String id, Book Book) {

        books.remove(findBookById(id));
        return addBook(Book);
    }

    public List<Book> findAll() {

        return books;
    }

    public boolean deleteBook(String name) {

        boolean found = false;
        for (Book u : books) {
            if (u.getName().equals(name)) {
                books.remove(u);
                found = true;
                break;
            }
        }
        return found;
    }

    public Book findBookById(String name) {

        for (Book u : books) {
            if (u.getName().equals(name)) {
                return u;
            }
        }
        return null;
    }

}
