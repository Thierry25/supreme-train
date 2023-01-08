package com.example.myfirstwebapp.services;

import com.example.myfirstwebapp.models.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> allTodos();
    List<Todo> findByUsername(String username);

}
