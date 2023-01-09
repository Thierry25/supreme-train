package com.example.myfirstwebapp.controllers;

import com.example.myfirstwebapp.models.Todo;
import com.example.myfirstwebapp.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@SessionAttributes("name")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(Model model) {
        model.addAttribute("todos", todoService.allTodos());
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(Model model) {
        // WEIRD: Putting a default todo in the model
        var newTodo = new Todo(0, (String) model.getAttribute("name"), "",
                LocalDate.now().plusMonths(4), false);
        model.addAttribute("todo", newTodo);
        return "newTodo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(Model model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "newTodo";
        }
        todoService.addTodo((String) model.getAttribute("name"), todo.getDescription(),
                LocalDate.now().plusMonths(5), false);
        return "redirect:list-todos";
    }

    @GetMapping("delete-todo")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @GetMapping("update-todo")
    public String updateTodo(Model model, @RequestParam int id) {
        var todo = todoService.getTodo(id);
        model.addAttribute("todo", todo);
        return "newTodo";
    }

    @PostMapping("update-todo")
    public String updateTodo(Model model, @Valid Todo todo, BindingResult result, @RequestParam int id){
        if(result.hasErrors()){
            return "newTodo";
        }
        todo.setUsername((String) model.getAttribute("name"));
        todoService.updateTodo(id, todo);
        return "redirect:list-todos";
    }

}
