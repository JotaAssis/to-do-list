package br.com.joaopaulo.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.joaopaulo.todolist.entity.Todo;
import br.com.joaopaulo.todolist.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService ts;

    public TodoController(TodoService ts) {
        this.ts = ts;
    }

    @PostMapping
    List<Todo> create(@RequestBody Todo todo){
        return ts.create(todo);
    }

    @GetMapping
    List<Todo> list(Todo todo){
        return ts.list();

    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo){
        return ts.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable("id") Long id){
        return ts.delete(id);   
    }

}
