package org.spring.tutorial.mvc.service;

import org.spring.tutorial.mvc.domain.User;

import java.util.List;

public interface IUserService {

    public User addUser(User user);

    public User updateUser(User user);

    public List<User> getUsers();

    public boolean deleteUser(Long id);

    public User findUserById(Long id);
}
