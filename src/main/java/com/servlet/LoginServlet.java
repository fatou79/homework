package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.LoginService;
import com.todo.TodoService;

@WebServlet(urlPatterns = "/login.do")

public class LoginServlet extends HttpServlet {
	private LoginService pen = new LoginService();
	private TodoService todoService = new TodoService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean red = pen.validateUser(name, password);
		if (red) {
			response.sendRedirect("/todo.do");

	} else {
		request.setAttribute("errorMessage", "Invalid Credentials!!");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
		
	}
}