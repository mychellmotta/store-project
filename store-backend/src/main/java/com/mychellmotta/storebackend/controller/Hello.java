package com.mychellmotta.storebackend.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class Hello {
    
    @GetMapping("/")
    public String hello() {
        return "Hello World!" + new Date();
    }
}
