package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
	@Autowired
	TodoListRepository repository;

	@Override
	public void run(String... String) throws Exception {
		TodoList todoList = new TodoList("Home Work", "tonight", "top");
		repository.save(todoList);

		todoList = new TodoList("cook", "today", "low");
		repository.save(todoList);

	}
	
}
