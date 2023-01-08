package com.example.myfirstwebapp.controllers;

import com.example.myfirstwebapp.services.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
@RequestMapping("list-todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public String listAllTodos(Model model){
        model.addAttribute("todos", todoService.allTodos());
        return "listTodos";
    }
}
