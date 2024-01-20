package com.app.todo.dao;

import com.app.todo.data.Todo;
import com.app.todo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoAppDao {
    @Autowired
    TodoRepository todoRepository;

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo fetchTodoById(Integer id) {
        return todoRepository.findById(id).get();
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id).get();
    }
}
