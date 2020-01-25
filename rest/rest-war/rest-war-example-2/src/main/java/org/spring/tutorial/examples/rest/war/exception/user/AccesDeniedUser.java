package org.spring.tutorial.examples.rest.war.exception.user;

public class AccesDeniedUser extends RuntimeException {

    private static final long serialVersionUID = -4250063119663086364L;

    public AccesDeniedUser(Exception e) {
        super(e);
    }

    public AccesDeniedUser(String message) {
        super(message);
    }
}
