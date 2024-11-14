package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/api/greeting")
    public String getGreeting() {
        return "Hello World!";
    }

    @GetMapping("/api/greeting/{name}")
    public String getGreetingWithName(@PathVariable String name) {
        return "Hello " + name + "! Nice to see you!";
    }

}
