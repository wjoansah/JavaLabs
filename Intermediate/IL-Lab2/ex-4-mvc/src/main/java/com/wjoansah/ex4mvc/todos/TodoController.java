package com.wjoansah.ex4mvc.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public String getTodos(Model model) {
        var todos = service.getTodos();
        model.addAttribute("todos", todos);
        return "todos/list";
    }

    @GetMapping("/{id}")
    public String getTodo(@PathVariable int id, Model model) {
        var todo = service.getTodoItem(id);
        model.addAttribute("todo", todo);
        return "todos/view";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("todo", new TodoItem());
        return "todos/create";
    }

    @PostMapping
    public String createTodo(@ModelAttribute TodoItem todoItem, Model model) {
        service.createTodo(todoItem.getTitle(), todoItem.getDescription(), todoItem.isCompleted());
        return "redirect:/todos";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        var todo = service.getTodoItem(id);
        model.addAttribute("todo", todo);
        return "todos/edit";
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable int id, @ModelAttribute TodoItem todoItem) {
        service.updateTodo(id, todoItem.getTitle(), todoItem.getDescription(), todoItem.isCompleted());
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        service.deleteTdoItem(id);
        return "redirect:/todos";
    }
}
