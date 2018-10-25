package com.tweet.core.service;

import com.tweet.core.model.User;

import java.util.List;

public interface UserService {

    void create(User user);

    User getById(Long id);

    List<User> getAll();

    void update(User update);

    void delete(String username);

}
