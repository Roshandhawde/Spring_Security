package com.example.springSecurity.service;

import com.example.springSecurity.entity.Users;
import com.example.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public void registerUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
userRepository.save(user);


    }
}
