package com.app.todo.service;

import com.app.todo.data.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getAllTodos();
    public Todo saveTodo(Todo todo);
    public Todo updateTodo(Todo todo);
    public void deleteTodo(int id);
    public Todo getTodoById(int id);
}
