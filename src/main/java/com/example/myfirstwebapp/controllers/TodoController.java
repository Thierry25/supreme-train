package com.example.myfirstwebapp.controllers;

import com.example.myfirstwebapp.models.Todo;
import com.example.myfirstwebapp.services.AuthenticationService;
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

    private final TodoService todoService;
    private final AuthenticationService authenticationService;

    public TodoController(TodoService todoService, AuthenticationService authenticationService) {
        this.todoService = todoService;
        this.authenticationService = authenticationService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(Model model) {
        String username = authenticationService.getSignedInUser();
        model.addAttribute("todos", todoService.findByUsername(username));
        return "listTodos";
    }

    @GetMapping("add-todo")
    public String showNewTodoPage(Model model) {
        // WEIRD: Putting a default todo in the model
        String username = authenticationService.getSignedInUser();
        var newTodo = new Todo(0, username, "",
                LocalDate.now().plusMonths(4), false);
        model.addAttribute("todo", newTodo);
        return "newTodo";
    }

    @PostMapping("add-todo")
    public String addNewTodo(Model model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "newTodo";
        }

        String username = authenticationService.getSignedInUser();
        todo.setUsername(username);
        todoService.addTodo(todo);
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
//        todo.get().setTargetDate(LocalDate.now().plusMonths(8));
        model.addAttribute("todo", todo);
        return "newTodo";
    }

    @PostMapping("update-todo")
    public String updateTodo(Model model, @Valid Todo todo, BindingResult result, @RequestParam int id){
        if(result.hasErrors()){
            return "newTodo";
        }
        String username = authenticationService.getSignedInUser();
        todo.setUsername(username);
//        todoService.updateTodo(id, todo);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }

}
