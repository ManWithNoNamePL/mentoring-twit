package com.tweet.core.serverui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ui")
public class SearchControllerUI {

    @PostMapping("/search")
    public String search(@RequestParam("searchCriteria") String searchCriteria) {
        return "users";
    }
}
