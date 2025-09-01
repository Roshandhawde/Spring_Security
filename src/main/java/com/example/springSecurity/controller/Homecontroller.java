package com.example.springSecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Homecontroller {

    @GetMapping("/")
    public String home(HttpServletRequest request){
//        return "Welcome to Backend Session ID: "+ request.changeSessionId();
        return "Welcome to Backend Session ID: ";
    }


}
