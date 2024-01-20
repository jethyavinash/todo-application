package com.app.todo.controller;

import com.app.todo.data.Todo;
import com.app.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todos",method = RequestMethod.POST,produces = {"application/json"})
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {

        Todo savedTodo = todoService.saveTodo(todo);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todos",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos",method = RequestMethod.PUT,produces = {"application/json"})
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo){
        todo.setLastUpdateTime(new Timestamp(System.currentTimeMillis()));
        Todo updatedTodo = todoService.updateTodo(todo);
        return new ResponseEntity<>(updatedTodo, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos/{id}",method = RequestMethod.DELETE,produces = {"application/json"})
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") int id){
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/todos/{id}",method = RequestMethod.GET,produces = {"application/json"})
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id){
        Todo todo = todoService.getTodoById(id);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }
}
