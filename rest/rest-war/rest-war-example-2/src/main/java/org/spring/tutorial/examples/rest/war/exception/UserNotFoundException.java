package org.spring.tutorial.examples.rest.war.exception;


public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8399052128516750385L;

    public UserNotFoundException(Exception e) {
        super(e);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
