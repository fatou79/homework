package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.LoginService;
import com.todo.Todo;
import com.todo.TodoService;

@WebServlet(urlPatterns = "/addtodo.do")

public class AddTodoServlet extends HttpServlet {
	private LoginService pen = new LoginService();
	private TodoService todoService = new TodoService();


	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String newTodo = request.getParameter("todo");
		String category = request.getParameter("category");
		todoService.addTodo(new Todo(newTodo,category));
		request.setAttribute("todos", todoService.retrieveTodos());
		request.getRequestDispatcher("/WEB-INF/views/todo.jsp").forward(request, response);
	}
	
	}
