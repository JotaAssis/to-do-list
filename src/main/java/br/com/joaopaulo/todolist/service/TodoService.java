package br.com.joaopaulo.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.joaopaulo.todolist.entity.Todo;
import br.com.joaopaulo.todolist.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository tr;

    public TodoService(TodoRepository tr) {
        this.tr = tr;
    }
    
    //Criar um todo
    public List<Todo> create(Todo todo){
        tr.save(todo);
        return list();
    }

    //Lista ordenada por prioridade>nome
    public List<Todo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending());
        return tr.findAll(sort);
    }
    
    //Atualizar um todo
    public List<Todo> update(Todo todo){
        tr.save(todo);
        return list();
    }

    //Deletar um todo
    public List<Todo> delete(Long id){
        tr.deleteById(id);
        return list();
    }


}
