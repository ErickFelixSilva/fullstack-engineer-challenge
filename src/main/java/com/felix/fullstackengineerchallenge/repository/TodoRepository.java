package com.felix.fullstackengineerchallenge.repository;

import com.felix.fullstackengineerchallenge.domain.SaveTodoCommand;
import com.felix.fullstackengineerchallenge.domain.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Repository
public class TodoRepository {
    private List<Todo> todos =  new ArrayList<>(Arrays.asList(
                new Todo(1L, "Todo number 1", "2026-06-05T18:15:00"),
                new Todo(2L, "Todo number 2", "2026-06-06T18:15:00"),
                new Todo(3L, "Todo number 3", "2026-06-07T18:15:00"),
                new Todo(4L, "Todo number 4", "2026-06-08T18:15:00")));

    public List<Todo> getTodos() {
        return todos;
    }

    public Todo saveTodo(SaveTodoCommand command) {
        var id = todos.stream().map(Todo::id).max(Comparator.naturalOrder()).orElse(0L) + 1;
        var createdAt = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        var newTodo = new Todo(id, command.text(), createdAt);
        todos.add(newTodo);

        return newTodo;
    }
}
