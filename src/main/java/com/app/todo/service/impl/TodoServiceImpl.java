package com.app.todo.service.impl;

import com.app.todo.dao.TodoAppDao;
import com.app.todo.data.Todo;
import com.app.todo.repo.TodoRepository;
import com.app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoAppDao todoAppDao;

    @Override
    public List<Todo> getAllTodos() {
        return todoAppDao.getAllTodos();
    }

    @Override
    public Todo saveTodo(Todo todo) {
        todo.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
        Todo savedTodo = todoAppDao.saveTodo(todo);
        return savedTodo;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        Todo todoToUpdate = todoAppDao.fetchTodoById(todo.getId());
        todoToUpdate.setTodoName(todo.getTodoName());
        todoToUpdate.setTodoDesc(todo.getTodoDesc());
        todoToUpdate.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
        todoAppDao.saveTodo(todoToUpdate);
        return todoToUpdate;
    }

    @Override
    public void deleteTodo(int id) {
        todoAppDao.deleteTodo(id);
    }

    @Override
    public Todo getTodoById(int id) {
        return todoAppDao.getTodoById(id);
    }
}
