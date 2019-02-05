package com.ex.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ex.model.Form;
import com.ex.services.FormService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public FormServlet() {

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("type"));
		response.getWriter().append("Type Testing").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getReader().readLine();
		ObjectMapper om = new ObjectMapper();
		Form form = om.readValue(json, Form.class);
		FormService service = new FormService();
		
		if ("pending".equals(form.getStatus())) {
			service.formInsert(form);
		}else if ("approved".equals(form.getStatus()) || "denied".equals(form.getStatus())) {
			service.UpdateFormStatus(form);
		}else if("manager".equals(form.getStatus())) {
			List<Form> temp = service.getManagerForms();
			PrintWriter out = response.getWriter();
			out.print(om.writeValueAsString(temp));
			out.flush();
		}else {
			List<Form> temp = service.getEmpForm(form.getEmpid());
			PrintWriter out = response.getWriter();
			out.print(om.writeValueAsString(temp));
			out.flush();
		}
	}	
	
}