package com.tweet.core.serverui.controller;

import com.tweet.core.model.User;
import com.tweet.core.model.UserRole;
import com.tweet.core.repository.UserRoleRepository;
import com.tweet.core.serverui.config.UserInfo;
import com.tweet.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("user")
@RequestMapping("/ui")
public class UserControllerUI {

    private static final List<String> LANGUAGE_NAMES = Arrays.stream(Locale.getISOLanguages())
            .map(Locale::new)
            .map(Locale::getDisplayLanguage)
            .collect(Collectors.toList());
    private static final List<String> COUNTRY_NAMES = Arrays.stream(Locale.getISOCountries())
            .map(country -> new Locale("", country))
            .map(Locale::getDisplayCountry)
            .collect(Collectors.toList());

    @Autowired
    private UserService userService;
    @Autowired
    private UserInfo userInfo;
    // TODO mpoborowski: this repo need to go to userService
    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping("/profile")
    public String displayProfile(@RequestParam(value = "id", required = false) Long userId, Model model) {
        User user = userId == null ? userInfo.getCurrentUser() : userService.getById(userId);
        populateDefaultModel(model, user);
        return "userProfile";
    }

    @GetMapping("/register")
    public String displayRegistrationForm(Model model) {
        model.addAttribute("edit_action", "/ui/register");
        populateDefaultModel(model, new User());
        return "registerUser";
    }

    @GetMapping("/edit")
    public String displayEditForm(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("edit_action", "/ui/update");
        model.addAttribute("is_update", true);
        populateDefaultModel(model, userService.getById(id));
        return "registerUser";
    }

    /* BindingResult need to be directly after bean, if its not exception will be thrown after not successful form
     * validation! */
    @PostMapping("/register")
    public String submitRegistrationForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
                                         HttpServletRequest request, Model model)
            throws ServletException {

        if (bindingResult.hasErrors()) {
            populateDefaultModel(model, user);
            return "registerUser";
        }
        // TODO: mpoborowski: temporary - this logic need to go to userService.create method
        user.setUserRoles(Set.of(userRoleRepository.findByName(UserRole.Name.USER)
                .orElseThrow(() -> new IllegalStateException("No user role defined for role USER."))));
        user.setActive(1);
        if (user.getUserSettings() != null) {
            user.getUserSettings().setUser(user);
        }
        userService.create(user);
        request.login(user.getUsername(), user.getPassword());
        return "wall";
    }

    @PostMapping("/update")
    public String submitUpdateForm(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model,
                                   SessionStatus status) {
        if (bindingResult.hasErrors()) {
            populateDefaultModel(model, user);
            return "registerUser";
        }
        userService.create(user);
        status.setComplete();
        userInfo.reload();
        return "wall";
    }

    private void populateDefaultModel(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("languages", LANGUAGE_NAMES);
        model.addAttribute("countries", COUNTRY_NAMES);
    }

}
