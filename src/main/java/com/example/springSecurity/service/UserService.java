package com.example.springSecurity.service;

import com.example.springSecurity.DTO.LoginRequestDTO;
import com.example.springSecurity.entity.Users;
import com.example.springSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    public void registerUser(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
userRepository.save(user);


    }

    public String verify(LoginRequestDTO user) {

        Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
if(authentication.isAuthenticated()){
    return jwtService.generateToken(user.getUsername());
}else {
    return "fail";
}
    }
}
