package com.wjoansah.ex4mvc.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository repository;
    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository repository, TodoRepository todoRepository) {
        this.repository = repository;
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoItem createTodo(String title, String description, boolean completed) {
        var newTodo = new TodoItem(title, description, completed);
        return repository.save(newTodo);
    }

    @Override
    public TodoItem updateTodo(int id, String title, String description, boolean completed) {
        var todo = repository.findById(id);
        if (todo.isPresent()) {
            if (!StringUtils.isEmptyOrWhitespace(title)) todo.get().setTitle(title);
            if (!StringUtils.isEmptyOrWhitespace(description)) todo.get().setDescription(description);
            todo.get().setCompleted(completed);

            repository.save(todo.get());
        }
        return repository.findById(id).get();
    }

    @Override
    public TodoItem getTodoItem(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<TodoItem> getTodos() {
        return repository.findAll();
    }

    @Override
    public void deleteTdoItem(int id) {
        repository.deleteById(id);
    }
}
