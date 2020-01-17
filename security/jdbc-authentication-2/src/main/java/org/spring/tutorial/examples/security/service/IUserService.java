package org.spring.tutorial.examples.security.service;

import org.spring.tutorial.examples.security.domain.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IUserService {


    User createUser(User user);

    User updateUser(User user);

    User findUserById(Long id);

    List<User> getAll();

    void removeById(Long userId);
}
