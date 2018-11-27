package com.tweet.core.serverui.controller;

import com.tweet.core.model.User;
import com.tweet.core.model.UserRole;
import com.tweet.core.repository.UserRoleRepository;
import com.tweet.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Set;

@Controller
@RequestMapping("/ui")
public class LogonController {

    @Autowired
    private UserService userService;
    // TODO mpoborowski: this repo need to go to userService
    @Autowired
    private UserRoleRepository userRoleRepository;


    @GetMapping({"/", "/logon"})
    public String displayHome() {
        return "home";
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping("/register")
    public String submitRegistrationForm(@Valid @ModelAttribute("user") User user, HttpServletRequest request)
            throws ServletException {
        // TODO: mpoborowski: temporary - this logic need to go to userService.create method
        user.setUserRoles(Set.of(userRoleRepository.findByName(UserRole.Name.USER)
                .orElseThrow(() -> new IllegalStateException("No user role defined for role USER."))));
        user.setActive(1);
        userService.create(user);
        request.login(user.getUsername(), user.getPassword());
        return "wall";
    }
}
