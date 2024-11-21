package com.wjoansah.p3springsecurity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/open/greeting")
    public String openGreeting() {
        return "Greetings, Guest!";
    }

    @GetMapping("/greeting")
    public String protectedGreeting(@AuthenticationPrincipal OAuth2User principal) {
        return String.format("Hello %s!", principal.getName());
    }
}
