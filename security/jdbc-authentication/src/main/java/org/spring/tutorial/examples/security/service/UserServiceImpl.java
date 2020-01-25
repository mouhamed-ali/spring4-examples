package org.spring.tutorial.examples.security.service;

import org.spring.tutorial.examples.security.dao.IUserDao;
import org.spring.tutorial.examples.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @PostConstruct
    private void init() {
        createUser(new User(1, "Linus", "Torvalds"));
        createUser(new User(2, "Rod", "Johnson"));
        createUser(new User(3, "Alan", "Turing"));
    }

    public User createUser(User user) {

        return userDao.save(user);
    }

    public User updateUser(User user) {

        return userDao.save(user);
    }

    public User findUserById(Long id) {

        return userDao.findOne(id);
    }

    public List<User> getAll() {

        return userDao.findAll();
    }

    public void removeById(Long id) {
        userDao.delete(id);
    }
}
