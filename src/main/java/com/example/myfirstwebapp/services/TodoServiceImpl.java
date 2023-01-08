package com.example.myfirstwebapp.services;

import com.example.myfirstwebapp.models.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    private static final List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(1, "thierrymarcelin", "Learn React JS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(2, "thierrymarcelin", "Learn Spring Boot",
                LocalDate.now().plusMonths(3), false));
        todos.add(new Todo(3, "fmarcelin", "Learn Kubernetes",
                LocalDate.now().plusMonths(5), false));
        todos.add(new Todo(4, "fmarcelin", "Learn AWS",
                LocalDate.now().plusMonths(2), false));
        todos.add(new Todo(5, "kathb", "Learn Candle Making",
                LocalDate.now().plusMonths(2), false));
    }

    @Override
    public List<Todo> allTodos() {
        return todos;
    }

    @Override
    public List<Todo> findByUsername(String username) {
        return todos.stream()
                .filter(todo -> todo.getUsername().equals(username))
                .collect(Collectors.toList());
    }
}
