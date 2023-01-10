package com.example.myfirstwebapp.services;

import com.example.myfirstwebapp.models.Todo;
import com.example.myfirstwebapp.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepo;

    public TodoServiceImpl(TodoRepository todoRepo){
        this.todoRepo = todoRepo;
    }

    @Override
    public List<Todo> allTodos() {
        return todoRepo.findAll();
    }

    @Override
    public List<Todo> findByUsername(String username) {
        return todoRepo.findByUsername(username).get();

    }

    @Override
    public void addTodo(Todo todo) {
        todoRepo.save(todo);
    }

    @Override
    public void deleteTodo(int id) {
        todoRepo.deleteById(id);
    }

    @Override
    public void updateTodo(Todo todo) {
        todoRepo.save(todo);
    }

    @Override
    public Optional<Todo> getTodo(int id) {
        return todoRepo.findById(id);
    }

}
