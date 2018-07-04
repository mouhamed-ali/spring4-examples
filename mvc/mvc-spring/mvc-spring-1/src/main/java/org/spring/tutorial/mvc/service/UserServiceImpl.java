package org.spring.tutorial.mvc.service;

import org.spring.tutorial.mvc.dao.IUserDao;
import org.spring.tutorial.mvc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

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
