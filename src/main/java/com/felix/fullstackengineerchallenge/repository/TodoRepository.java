package com.felix.fullstackengineerchallenge.repository;

import com.felix.fullstackengineerchallenge.domain.SaveTodoCommand;
import com.felix.fullstackengineerchallenge.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepository {
    Calendar calendar = Calendar.getInstance();
    private List<Todo> todos =  new ArrayList<>(Arrays.asList(
                new Todo(1L, "Todo number 1", calendar),
                new Todo(2L, "Todo number 2", calendar),
                new Todo(3L, "Todo number 3", calendar),
                new Todo(4L, "Todo number 4", calendar)));

    public List<Todo> getTodos() {
        return todos;
    }

    public void saveTodo(SaveTodoCommand command) {
//        var id = todos.stream().map(Todo::id).max();
//        todos.add(new Todo())
    }
}
