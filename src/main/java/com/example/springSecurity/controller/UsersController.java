package com.example.springSecurity.controller;


import com.example.springSecurity.entity.Users;
import com.example.springSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
   private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody Users user){
        userService.registerUser(user);
        return "user registered";
    }

}
