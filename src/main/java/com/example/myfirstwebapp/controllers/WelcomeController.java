package com.example.myfirstwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
@SessionAttributes("name")
public class WelcomeController {

    @GetMapping
    public String goToWelcomePage(Model model ){
        model.addAttribute("name", "Thierry");
        return "welcome";
    }

//    @PostMapping
//    public String welcome(@RequestParam String name, @RequestParam String password, Model model){
//        model.addAttribute("name", name);
//        model.addAttribute("password", password);
//        return authenticationService.isCorrectInfo(name, password) ? "welcome" : "login";
//    }
}
