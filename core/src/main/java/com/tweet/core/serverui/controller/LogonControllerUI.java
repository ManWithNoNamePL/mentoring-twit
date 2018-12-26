package com.tweet.core.serverui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/ui")
public class LogonControllerUI {

    @GetMapping({"/", "/logon"})
    public String displayHome() {
        return "home";
    }

}
