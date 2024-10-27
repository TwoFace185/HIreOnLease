package com.Bonami.HireOnlease.controller;

import com.Bonami.HireOnlease.model.Users;
import com.Bonami.HireOnlease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);


    @PostMapping("/register")
    private Users resgiter(@RequestBody Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return userService.register(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users){
        System.out.println(users +"------------");
        return userService.verify(users);
    }
}
