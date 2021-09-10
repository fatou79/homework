package com.todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
	private static List<Todo> todos = new ArrayList();

	static {
		todos.add(new Todo("java","computer science"));
		todos.add(new Todo("eclipse","computer science"));
		todos.add(new Todo("html","computer science"));
	}

	public List<Todo> retrieveTodos() {
		return todos;
	}
	public void addTodo(Todo todo) {
		todos.add(todo);
	}
	public void deleteTodo(Todo todo) {
		
	}

}
