package com.tweet.core.serverui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class WallController {

    @GetMapping("/wall")
    public String displayWall() {
        return "wall";
    }
}
