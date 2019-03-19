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

import static java.lang.Integer.parseInt;

public class UserServlet extends HttpServlet{

	public UserServlet() {
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		String json = request.getReader().readLine(); // request must be sent as one line

		ObjectMapper om = new ObjectMapper();
		User user = om.readValue(json, User.class);

		UserService userService = new UserService();
		User temp = userService.authenticateUser(user);
		PrintWriter out = response.getWriter();

		if (temp == null) {
			out.print("user doesn't match");
		} else {
			out.print(om.writeValueAsString(temp));
		}
//		out.flush();
	}

	// need to use doPost to authenticate instead of doGet by email
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		ObjectMapper om = new ObjectMapper();
//		UserService service = new UserService();
//		String email = request.getParameter("email");
//		User temp = service.retrieveUserByEmail(email);
//		if (temp == null) {
//			out.print("no user with that email");
//		} else {
//			out.print(om.writeValueAsString(temp));
//		}
//	}

	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
	}
}