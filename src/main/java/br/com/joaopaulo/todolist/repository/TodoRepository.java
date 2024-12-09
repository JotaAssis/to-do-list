package br.com.joaopaulo.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.joaopaulo.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{

}
