package com.example.myfirstwebapp.services;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isCorrectInfo(String name, String password){
        return (name.equals("Thierry") && password.equals("Marcelin"));
    }
}
