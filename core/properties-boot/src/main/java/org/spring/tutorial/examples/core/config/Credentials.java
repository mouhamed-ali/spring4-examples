package org.spring.tutorial.examples.core.config;

public class Credentials {

    private String username;
    private String password;
    private String authMethod;

    public String getUsername() {
        return username;
    }

    public Credentials setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Credentials setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAuthMethod() {
        return authMethod;
    }

    public Credentials setAuthMethod(String authMethod) {
        this.authMethod = authMethod;
        return this;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authMethod='" + authMethod + '\'' +
                '}';
    }
}
