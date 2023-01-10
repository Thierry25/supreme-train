package com.example.myfirstwebapp.repositories;

import com.example.myfirstwebapp.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Optional<List<Todo>> findByUsername(String username);
}
