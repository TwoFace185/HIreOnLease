package com.Bonami.HireOnlease.service;

import com.Bonami.HireOnlease.config.MyUserDetails;
import com.Bonami.HireOnlease.dao.UserRepo;
import com.Bonami.HireOnlease.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userReposotory;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userReposotory.findByUsername(username);
        if(user == null){
            System.out.println("Username not found ");
            throw new UsernameNotFoundException("User not found");
        }

        return new MyUserDetails(user);
    }
}
