package com.rama.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Darsh ";
    }

    @RequestMapping("/hi")
    public String sayHi() {
        return "Hi Darsh ";
    }
}
