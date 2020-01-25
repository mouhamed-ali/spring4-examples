package org.spring.tutorial.examples.rest.war.exception.book;

public class NotAuthorizedException extends RuntimeException {

    public NotAuthorizedException(String s) {
        super(s);
    }

    public NotAuthorizedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NotAuthorizedException(Throwable throwable) {
        super(throwable);
    }
}
