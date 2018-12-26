package com.tweet.core.serverui.config;

import com.tweet.core.model.User;
import com.tweet.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfo {

    @Autowired
    private UserService userService;

    private User user;

    public User getCurrentUser() {
        if (user == null) {
            user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        }
        return user;
    }

    public void reload() {
        user = userService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
