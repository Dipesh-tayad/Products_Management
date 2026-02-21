package com.zest.product.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.zest.product.entity.User;
import com.zest.product.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) 
    {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) 
    {

        User user = repository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().name().replace("ROLE_", ""))
                .build();
    }
}