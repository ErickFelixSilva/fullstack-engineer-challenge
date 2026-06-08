package com.felix.fullstackengineerchallenge.service;

import com.felix.fullstackengineerchallenge.domain.SaveTodoCommand;
import com.felix.fullstackengineerchallenge.domain.Todo;
import com.felix.fullstackengineerchallenge.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return todoRepository.getTodos();
    }


    public Todo saveTodo(SaveTodoCommand command) {
        return todoRepository.saveTodo(command);
    }
}
