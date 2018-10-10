package com.tweet.core.controller;

import com.tweet.core.model.User;
import com.tweet.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity createUser(User user) {
        userService.create(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity getUserByName(@PathVariable String username) {
        return ResponseEntity.ok(userService.getByName(username));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PutMapping
    public ResponseEntity updateUser(User user) {
        userService.update(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{name}")
    public ResponseEntity deleteUser(@PathVariable String username) {
        userService.delete(username);
        return ResponseEntity.ok().build();
    }
}
