package org.wjoansah.lab4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public String greet(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }
}
