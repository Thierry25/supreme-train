package com.example.myfirstwebapp.controllers;

import com.example.myfirstwebapp.services.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
@SessionAttributes("name")
public class WelcomeController {

    private final AuthenticationService authenticationService;

    public WelcomeController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String goToWelcomePage(Model model ){
        model.addAttribute("name", authenticationService.getSignedInUser());
        return "welcome";
    }

}
