package com.wjoansah.ex4mvc.todos;

import java.util.List;

public interface TodoService {
    TodoItem createTodo(String title, String description, boolean completed);
    TodoItem updateTodo(int id, String title, String description, boolean completed);
    TodoItem getTodoItem(int id);
    List<TodoItem> getTodos();
    void deleteTdoItem(int id);
}
