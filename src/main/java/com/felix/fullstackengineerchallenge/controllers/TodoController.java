package com.felix.fullstackengineerchallenge.controllers;

import com.felix.fullstackengineerchallenge.domain.SaveTodoCommand;
import com.felix.fullstackengineerchallenge.domain.Todo;
import com.felix.fullstackengineerchallenge.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public Todo saveTodo(@RequestBody SaveTodoCommand command) {
        return todoService.saveTodo(command);
    }
}
