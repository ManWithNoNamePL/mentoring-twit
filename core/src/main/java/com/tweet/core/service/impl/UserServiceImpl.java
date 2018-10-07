package com.tweet.core.service.impl;

import com.tweet.core.model.User;
import com.tweet.core.repository.UserRepository;
import com.tweet.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(User user) {
        // to do some validation
        // create user in DB
    }

    @Override
    public User getByName(String username) {
        return null;
    }

    @Override
    public void update(User update) {
        // validate user
        // update user in db
    }

    @Override
    public void delete(String username) {
        // delete user
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
