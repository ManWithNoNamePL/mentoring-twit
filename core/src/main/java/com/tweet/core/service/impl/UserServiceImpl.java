package com.tweet.core.service.impl;

import com.tweet.core.error.UserNotFoundException;
import com.tweet.core.model.User;
import com.tweet.core.repository.UserRepository;
import com.tweet.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User user) {
        // to do some validation
        // create user in DB
        // TODO mpoborowski: for now simple insert to keep tests happy :)
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(id));
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new UserNotFoundException(username));
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
        return userRepository.findAll();
    }
}
