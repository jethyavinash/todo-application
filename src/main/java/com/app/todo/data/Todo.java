package com.app.todo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String todoName;
    private String todoDesc;
    private Timestamp lastUpdateTime;

    public Todo() {
    }

    public Todo(Integer id, String todoName, String todoDesc, Timestamp lastUpdateTime) {
        this.id = id;
        this.todoName = todoName;
        this.todoDesc = todoDesc;
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }

    public String getTodoDesc() {
        return todoDesc;
    }

    public void setTodoDesc(String todoDesc) {
        this.todoDesc = todoDesc;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
