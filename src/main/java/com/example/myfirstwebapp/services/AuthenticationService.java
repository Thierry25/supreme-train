package com.example.myfirstwebapp.services;

import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    String getSignedInUser();
}
