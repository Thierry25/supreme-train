package com.example.myfirstwebapp.services;

import com.example.myfirstwebapp.models.Todo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> allTodos();
    List<Todo> findByUsername(String username);

    void addTodo(Todo todo);

    void deleteTodo(int id);

    void updateTodo(Todo todo);

    Optional<Todo> getTodo(int id);

}
