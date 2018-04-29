package org.spring.tutorial.rest.boot.services;

import org.spring.tutorial.rest.boot.models.User;

import java.util.List;

public interface UserService {

    List<User> findAllUsers();

    User findById(int id);

    boolean isUserExist(User user);

    void saveUser(User user);

    void updateUser(User currentUser);

    void deleteUserById(int id);

    void deleteAllUsers();

}
