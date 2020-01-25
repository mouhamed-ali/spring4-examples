package org.spring.tutorial.examples.rest.war.exception.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Sorry, we did not find this book")//409
/*
 * we can also use an another status like NOT_ACCEPTABLE
 * if we use this exception in our controller it will return the 409 status
 * to the customer app
 */
public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8399052128516750385L;

    public BookNotFoundException(Exception e) {
        super(e);
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
