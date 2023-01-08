package com.example.myfirstwebapp.controllers;

import com.example.myfirstwebapp.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("login")
public class LoginController {

//    private Logger logger = LoggerFactory.getLogger(getClass());

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String login( ){
        return "login";
    }

    @PostMapping
    public String welcome(@RequestParam String name, @RequestParam String password, Model model){
        model.addAttribute("name", name);
        model.addAttribute("password", password);
        return authenticationService.isCorrectInfo(name, password) ? "welcome" : "login";
    }
}
