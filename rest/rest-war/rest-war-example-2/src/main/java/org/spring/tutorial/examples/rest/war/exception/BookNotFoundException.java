package org.spring.tutorial.examples.rest.war.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)//409
public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8399052128516750385L;

    public BookNotFoundException(Exception e) {
        super(e);
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}
