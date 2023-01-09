package com.example.myfirstwebapp.services;

import com.example.myfirstwebapp.models.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public void addTodo(String username, String description, LocalDate date, boolean isCompleted) {
        int id = todos.size();
        var newTodo = new Todo(id + 1, username, description, date, isCompleted);
        todos.add(newTodo);
    }

    @Override
    public void deleteTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    @Override
    public void updateTodo(int id, Todo todo) {
        var current = getTodo(id);
        todo.setTargetDate(LocalDate.now().plusMonths(6));
        todos.set(current.get().getId() - 1, todo);
    }

    @Override
    public Optional<Todo> getTodo(int id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

}
