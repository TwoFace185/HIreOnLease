package com.Bonami.HireOnlease.service;

import com.Bonami.HireOnlease.dao.UserRepo;
import com.Bonami.HireOnlease.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public Users register(Users user){
        return userRepository.save(user);
    }


    public String verify(Users users) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));

                if(authentication.isAuthenticated()){
                    return jwtService.generateToken(users.getUsername());
                }
                return "failure";
    }
}
