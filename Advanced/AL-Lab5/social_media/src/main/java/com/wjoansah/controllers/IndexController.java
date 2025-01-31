package com.wjoansah.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class IndexController {
    @GetMapping
    public String home() {
        return "Welcome to the best social media in Africa...";
    }
}
