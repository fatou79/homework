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

@WebServlet(urlPatterns = "/delete-todo.do")

public class DeleteTodo extends HttpServlet {
	private LoginService pen = new LoginService();
	private TodoService todoService = new TodoService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		todoService.deleteTodo(new Todo(request.getParameter("todo"),request.getParameter("category")));
		response.sendRedirect("/todo.do");
	}
	
	
	
	
	}
