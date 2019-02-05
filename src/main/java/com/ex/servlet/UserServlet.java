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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getReader().readLine();
		ObjectMapper om = new ObjectMapper();
		User user = om.readValue(json, User.class);
		UserService service = new UserService();
		User temp = service.authenticateUser(user);
		
		if (temp==null) {
			System.out.println("incorrect login");
		}else {
			System.out.println(temp.getFirstname());
		}
		
		PrintWriter out = response.getWriter();
		out.print(om.writeValueAsString(temp));
		out.flush();	
	}
}