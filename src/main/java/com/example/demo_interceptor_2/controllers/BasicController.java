package com.example.demo_interceptor_2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/basic")
public class BasicController {
    @GetMapping("/test")
    public String sayWelcome(){
        return "Welcome to the month API";
    }
}
