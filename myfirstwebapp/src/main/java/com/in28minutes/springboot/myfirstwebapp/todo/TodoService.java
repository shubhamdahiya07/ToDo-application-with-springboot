package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	
	private static int todoCount=0;
	
	static {
		todos.add(new Todo(++todoCount,"Mohit","Learn A",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"Mohit","Learn AW",LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoCount,"Mohit","Learn AWS",LocalDate.now().plusYears(1),false));
	}
	
	public List<Todo>findByUsername(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done){
		Todo todo = new Todo(++todoCount,username,description,LocalDate.now().plusYears(1),false);
		todos.add(todo);
	}
	
	public void deleteByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findByID(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get(); 
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteByID(todo.getId());
		todos.add(todo);
	}
}
