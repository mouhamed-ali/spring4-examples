package org.spring.tutorial.mvc.service;

import org.spring.tutorial.mvc.domain.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    User updateUser(User user);

    List<User> getUsers();

    boolean deleteUser(Long id);

    User findUserById(Long id);
}
