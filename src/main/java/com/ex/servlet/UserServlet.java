package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ex.model.User;
import com.ex.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserService userService;

	public UserServlet() {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getReader().readLine();

		ObjectMapper om = new ObjectMapper();
		User user = om.readValue(json, User.class);

		UserService service = new UserService();
		User temp = service.authenticateUser(user);
		PrintWriter out = response.getWriter();

		if (temp == null) {
			out.print("user doesn't match");
		} else {
			out.print(om.writeValueAsString(temp));
		}
//		out.flush();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		ObjectMapper om = new ObjectMapper();
		String email = request.getParameter("email");
		UserService service = new UserService();
		User temp = service.retrieveUserByEmail(email);
		if (temp == null) {
			out.print("no user with that email");
		} else {
			out.print(om.writeValueAsString(temp));
		}
	}
}