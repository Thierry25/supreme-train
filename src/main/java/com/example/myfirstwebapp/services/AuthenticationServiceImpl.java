package com.example.myfirstwebapp.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service

public class AuthenticationServiceImpl implements AuthenticationService{

    @Override
    public String getSignedInUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
