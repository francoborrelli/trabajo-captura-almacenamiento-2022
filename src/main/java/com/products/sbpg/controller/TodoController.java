package com.products.sbpg.controller;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.products.sbpg.SbpgApplication;
import com.products.sbpg.exception.ResourceNotFoundException;
import com.products.sbpg.model.Todo;
import com.products.sbpg.repository.TodoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    // for logging
    private static final Logger logger = LoggerFactory.getLogger(SbpgApplication.class);

    @Autowired
    private TodoRepository repo;

    @GetMapping("/todos")
    public List<Todo> getAllTodos() {
        logger.info("listing all todos...");
        return repo.findAll();
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable(value = "id") long todoId) throws ResourceNotFoundException {
        logger.info("getting todo with id: {}", todoId);

        // find by id
        Todo todo = repo.findById(todoId).
            orElseThrow(() -> new ResourceNotFoundException("Todo not found for ID: " + todoId));

        // response
        return ResponseEntity.ok().body(todo);
    }

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        logger.info("creating new todo");
        
        // set created_at and updated_at
        todo.setCreatedAt(System.currentTimeMillis());
        todo.setUpdatedAt(System.currentTimeMillis());

        // save and return response
        return repo.save(todo);
    }

    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodoById(@PathVariable(value = "id") long todoId, @RequestBody Todo updatedEmployee) throws ResourceNotFoundException {
        logger.info("updating todo with id: {}", todoId);

        // find by id
        Todo todo = repo.findById(todoId).
            orElseThrow(() -> new ResourceNotFoundException("Todo not found for ID: " + todoId));

        // set fields
        todo.setTitle(updatedEmployee.getTitle());
        todo.setDescription(updatedEmployee.getDescription());
        todo.setCompleted(updatedEmployee.isCompleted());
        todo.setUpdatedAt(System.currentTimeMillis());

        // update and send response
        repo.save(todo);
        return ResponseEntity.ok().body(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodoById(@PathVariable(value = "id") long todoId) throws ResourceNotFoundException {
        logger.info("deleting todo with id: {}", todoId);

        // find by id
        Todo todo = repo.findById(todoId).
            orElseThrow(() -> new ResourceNotFoundException("Todo not found for ID: " + todoId));

        // just delete
        repo.delete(todo);
    }
}