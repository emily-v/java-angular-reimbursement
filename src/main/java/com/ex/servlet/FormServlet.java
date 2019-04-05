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

import static java.lang.Integer.parseInt;

public class FormServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public FormServlet() {

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("type"));
//		response.getWriter().append("Type Testing").append(request.getContextPath());
		setAccessControlHeaders(response);
		PrintWriter out = response.getWriter();
		FormService formService = new FormService();
		try {
			Integer userId = null;
			Integer formId = null;
			if (request.getParameter("userId") != null) {
				userId = Integer.valueOf(request.getParameter("userId"));
				List<Form> forms = formService.getEmpForm(userId);
				out.print(forms);
			}
			if (request.getParameter("formId") != null) {
				formId = Integer.valueOf(request.getParameter("formId"));
				Form form = formService.getForm(formId);
				out.print(form);
			}
			if (userId == null && formId == null) {
				List<Form> forms = formService.getManagerForms();
				out.print(forms);
			}
		} catch (NumberFormatException e) {
			out.print("param is not an integer value");
		}

//		ObjectMapper om = new ObjectMapper();
//		for (Form form: forms) {
//			out.print(om.writeValueAsString(form));
//		}
//		out.print(om.writeValueAsAString(forms));
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		String json = request.getReader().readLine();
		ObjectMapper om = new ObjectMapper();
		Form form = om.readValue(json, Form.class);
		FormService service = new FormService();
		service.formInsert(form);
		PrintWriter out = response.getWriter();
		out.print(form);
//		if ("pending".equals(form.getStatus())) {
//			service.formInsert(form);
//		}else if ("approved".equals(form.getStatus()) || "denied".equals(form.getStatus())) {
//			service.UpdateFormStatus(form);
//		}else if("manager".equals(form.getStatus())) {
//			List<Form> temp = service.getManagerForms();
//			PrintWriter out = response.getWriter();
//			out.print(om.writeValueAsString(temp));
//			out.flush();
//		}else {
//			List<Form> temp = service.getEmpForm(form.getUserId());
//			PrintWriter out = response.getWriter();
//			out.print(om.writeValueAsString(temp));
//			out.flush();
//		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setAccessControlHeaders(response);
		String json = request.getReader().readLine();
		ObjectMapper om = new ObjectMapper();
		Form form = om.readValue(json, Form.class);
		FormService service = new FormService();
		service.updateForm(form);
		PrintWriter out = response.getWriter();
		out.print(form);
	}

	private void setAccessControlHeaders(HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		resp.setHeader("Access-Control-Allow-Methods", "POST");
	}
	
}